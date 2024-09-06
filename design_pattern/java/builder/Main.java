package builder;

public class Main {
    static void makeSportsCar() {
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);
        Car car = carBuilder.getProduct();

        CarManualBuilder carManualBuilder = new CarManualBuilder();
        director.constructSportsCar(carManualBuilder);
        Manual manual = carManualBuilder.getProduct();


        System.out.println("스포츠카 정보 : " + car);
        System.out.println("스포츠카 메뉴얼 정보 : " + manual);
    }

    static void makeSUVCar() {
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();
        director.constructSUV(carBuilder);
        Car car = carBuilder.getProduct();

        CarManualBuilder carManualBuilder = new CarManualBuilder();
        director.constructSUV(carManualBuilder);
        Manual manual = carManualBuilder.getProduct();


        System.out.println("SUV 정보 : " + car);
        System.out.println("SUV 메뉴얼 정보 : " + manual);
    }

    public static void main(String[] args) {
        makeSportsCar();

        makeSUVCar();
    }
}
