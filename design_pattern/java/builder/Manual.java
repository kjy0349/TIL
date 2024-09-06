package builder;

public class Manual {
    private String seatDescription;
    private String engineDescription;
    private String tripComputerDescription;
    private String gpsDescription;


    public void setSeatDescription(String seatDescription) {
        this.seatDescription = seatDescription;
    }

    public void setEngineDescription(String engineDescription) {
        this.engineDescription = engineDescription;
    }

    public void setTripComputerDescription(String tripComputerDescription) {
        this.tripComputerDescription = tripComputerDescription;
    }

    public void setGpsDescription(String gpsDescription) {
        this.gpsDescription = gpsDescription;
    }

    @Override
    public String toString() {
        return "Manual{" +
                "seatDescription='" + seatDescription + '\'' +
                ", engineDescription='" + engineDescription + '\'' +
                ", tripComputerDescription='" + tripComputerDescription + '\'' +
                ", gpsDescription='" + gpsDescription + '\'' +
                '}';
    }
}
