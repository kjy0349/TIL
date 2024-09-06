package builder;

public class CarBuilder implements Builder{
    private Car car;

    CarBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.car = new Car();
    }

    @Override
    public void setSeats(int seatCount) {
        this.car.setSeatCount(seatCount);
    }

    @Override
    public void setEngine(boolean hasEngine) {
        this.car.setHasEngine(hasEngine);
    }

    @Override
    public void setTripComputer(boolean hasTripComputer) {
        this.car.setHasEngine(hasTripComputer);
    }

    @Override
    public void setGPS(boolean hasGPS) {
        this.car.setHasGPS(hasGPS);
    }

    Car getProduct() {
        Car product = this.car;
        this.reset();
        return product;
    }
}
