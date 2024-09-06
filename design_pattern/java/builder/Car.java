package builder;

public class Car {
    private int seatCount;
    private boolean hasEngine;
    private boolean hasTripComputer;
    private boolean hasGPS;

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public void setHasEngine(boolean hasEngine) {
        this.hasEngine = hasEngine;
    }

    public void setHasTripComputer(boolean hasTripComputer) {
        this.hasTripComputer = hasTripComputer;
    }

    public void setHasGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seatCount=" + seatCount +
                ", hasEngine=" + hasEngine +
                ", hasTripComputer=" + hasTripComputer +
                ", hasGPS=" + hasGPS +
                '}';
    }
}
