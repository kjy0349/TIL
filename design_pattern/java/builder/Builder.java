package builder;

public interface Builder {
    void reset();
    void setSeats(int seatCount);
    void setEngine(boolean hasEngine);
    void setTripComputer(boolean hasTripComputer);
    void setGPS(boolean hasGPS);
}
