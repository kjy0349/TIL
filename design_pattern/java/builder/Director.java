package builder;

public class Director {

    void constructSportsCar(Builder builder) {
        builder.reset();
        builder.setSeats(2);
        builder.setEngine(true);
        builder.setTripComputer(true);
        builder.setGPS(true);
    }

    void constructSUV(Builder builder) {
        builder.reset();
        builder.setSeats(5);
        builder.setEngine(true);
        builder.setTripComputer(false);
        builder.setGPS(true);
    }
}
