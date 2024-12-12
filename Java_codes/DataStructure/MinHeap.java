package DataStructure;
import java.util.*;
public class MinHeap {
    private final int[] heapArray;
    private final int capacity;
    private int current_heap_size;

    /*
        최솟값에대한 접근시간을 O(1)로 보장하기 위해서 배열로 힙을 구현했다.
    */
    public MinHeap(int n) {
        capacity = n;
        heapArray = new int[capacity];
        current_heap_size = 0;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /*
        0번 인덱스를 사용하기 위해서 left와 right를 *2, *2 + 1이 아닌 각각 1과 2를 더하는 방식을 선택했다.
     */
    private int parent(int key) {
        return (key - 1) / 2;
    }

    private int left(int key) {
        return 2 * key + 1;
    }

    private int right(int key) {
        return 2 * key + 2;
    }

    public boolean insertKey(int key) {
        if (current_heap_size == capacity) { // full check
            return false;
        }

        /*
            힙 자료구조의 insert는, 완전 이진트리를 유지하면서 가장 마지막 인덱스에 새 값을 넣어준다.
            이후 자신의 부모를 타고 올라가면서, 최소힙일 경우에는 자신이 부모보다 작다면 자신과 부모를 바꿔가며 heap 구조를 유지시킨다.
         */
        int i = current_heap_size;
        heapArray[i] = key;
        current_heap_size++;

        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(heapArray, i, parent(i));
            i = parent(i);
        }
        return true;
    }

    public int getMin() {
        return heapArray[0];
    }

    public int extractMin() {
        if (current_heap_size <= 0) {
            return Integer.MAX_VALUE;
        }

        if (current_heap_size == 1) {
            current_heap_size--;
            return heapArray[0];
        }

        int root = heapArray[0];
        heapArray[0] = heapArray[current_heap_size - 1];
        current_heap_size--;
        MinHeapify(0);
        return root;
    }

    public void deleteKey(int key) {
        decreaseKey(key, Integer.MIN_VALUE);
        extractMin();
    }

    private void MinHeapify(int key) {
        int l = left(key);
        int r = right(key);

        int smallest = key;
        if (l < current_heap_size && heapArray[l] < heapArray[smallest]) {
            smallest = l;
        }

        if (r < current_heap_size && heapArray[r] < heapArray[smallest]) {
            smallest = l;
        }

        if (smallest != key) {
            swap(heapArray, key, smallest);
            MinHeapify(smallest);
        }
    }
    public void decreaseKey(int key, int new_val) {
        heapArray[key] = new_val;
        while (key != 0 && heapArray[key] < heapArray[parent(key)]) {
            swap(heapArray, key, parent(key));
            key = parent(key);
        }
    }

    public void increaseKey(int key, int new_val) {
        heapArray[key] = new_val;
        MinHeapify(key);
    }

    /*
        힙 자료구조의 특정 노드의 값을 바꿀 때 사용한다. 기존 힙 구조를 유지하기 위해서 더 큰 값이나 작은 값이 들어왔을 때 각각 다른 방식을 선택한다
        최소힙 자료구조에서 노드의 값이 커지게 된다면 자신이 자식보다 값이 더 커질 수 있으므로, 밑으로 내려가면서 heapify를 수행하고
        반대로 값이 작아지게 된다면 위로 올라가면서 부모를 찾아가며 heapify를 수행한다.
     */
    public void changeValueOnKey(int key, int new_val) {
        if (heapArray[key] == new_val) {
            return;
        }
        if (heapArray[key] < new_val) {
            increaseKey(key, new_val);
        } else {
            decreaseKey(key, new_val);
        }
    }
}