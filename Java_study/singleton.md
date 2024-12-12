### 싱글톤을 만드는 방법
Double-checked locking<br>
소프트웨어 디자인 패턴으로써 Lock을 획득하기 전 Lock Criterion(Lock Hint)를 테스트해 Lock을 얻는 오버헤드를 줄이는 것이 목적이다.<br>
Lock은 Locking criterion 체크가 락이 필요하다고 표시되어질 때에만 락킹이 발생한다.<br>

Pattern Languages of Program Design 3라는 책에 나온 기존 패턴에서는, 사용하고있는 메모리 모델에 따라 data race 현상이 발생했다.<br>
몇몇은 안티패턴이라고도 생각했다. 이러한 패턴을 제대로 사용하기 위해서는, JAVA와 C++내의 volatile 키워드를 사용해야만 했다.

기존 패턴
```java
class Foo {
    private static Helper helper;

    public static Helper getHelper() {
        if (helper == null) {
            helper = new Helper();
        }
        return helper;
    }
}
```

문제는 멀티스레딩 환경에서는 이 방식이 제대로 동작하지 않았다. 별다른 Lock을 잡는 과정이 없었기 때문에, 첫 번째 if문에서 helper==null 조건문이
두개 이상의 스레드에서 true라는 결괏값을 출력할 수 있기 때문이다.<br>

이에 더해서 동시에 객체를 만들거나, 아직 초기화되지 않은 객체를 저장할 수도 있었다.
이를 해결하기위해, synchronized 키워드를 추가해 해결했다.
```java
class Foo {
    private Helper helper;
    public synchronized Helper getHelper() {
        if (helper == null) {
            helper = new Helper();
        }
        return helper;
    }
}
```

해당 방식은 올바르게 동작하고, 대부분의 상황에서 아마도 충분한 성능을 발휘할 것이다. 그러나, 극단적으로 100개 이상의 스레드가 getHelper 메소드에 접근한다고 가정해보자.
처음 객체를 생성할 때에는 Lock이 필요하기 때문에 논외로 둔다고 해도, 이외 스레드들은
이미 생성된 객체의 레퍼런스를 얻기 위해 Lock을 획득하고 해제해야한다는 점에서 불필요한 Lock 획득 및 해제가 계속해서 발생하게 된다.

double-checked locking 디자인 패턴을 만든 사람을 포함한 여러 프로그래머들은, 아래와 같이 이 상황을 최적화하려고 시도했다.
1. 변수가 초기화되었는지 확인한다(Lock 획득 없이). 만약 초기화되었다면, 즉시 return한다.
2. 락을 획득한다.
3. 변수가 이미 초기화되었는지 한 번더 체크한다. 만약 다른 스레드가 Lock을 먼저 획득했다면, 변수는 이미 초기화되어있을 것이다. 만약 초기화되어있다면, 초기화된 변수를 return한다.
4. 아니라면, 새롭게 변수를 초기화하고 변수를 return한다.

```java
// 멀티 스레딩 환경에서는 정상적으로 동작하지 않음
// 최초 "Double-Checked Locking" 패턴의 정의
class Foo {
    private Helper helper;
    public Helper getHelper() {
        if (helper == null) {
            synchronized (this) {
                if (helper == null) {
                    helper = new Helper();
                }
            }
        }
        return helper;
    }
}
```

직관적으로, 이 알고리즘은 위의 문제에 효율적인 해결책입니다. 하지만, 이 패턴은 신중하게 적용되지 않았습니다. 해당 코드는 data race 상태를 만듧니다. 예를 들어 봅시다.

1. Thread A가, helper value가 초기화되지 않았다는걸 알게됩니다. 그래서 이 스레드는 락을 획득하고, value를 초기화하려고 시작합니다.
2. 몇몇 프로그래밍 언어의 문법 때문에, 컴파일러에의해 생성 된 코드는 A 스레드가 초기화를 완전하게 끝내기 전에 공유 value인 helper 변수의 레퍼런스 값을 업데이트하도록 허용하고 있습니다.



[Double-checked locking - wikipedia](https://en.wikipedia.org/wiki/Double-checked_locking)

LazyHolder<br>
Enum<br>
kotlin's object keyword<br>
