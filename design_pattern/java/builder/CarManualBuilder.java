package builder;

public class CarManualBuilder implements Builder{
    Manual manual;

    private String manualBooleanMaker(String product, boolean isInstalled) {
        return "해당 차에는 " + product + "이(가) " + (isInstalled ? "설치되어 있습니다" : "설치되어 있지 않습니다");
    }

    @Override
    public void reset() {
        this.manual = new Manual();
    }

    @Override
    public void setSeats(int seatCount) {
        manual.setSeatDescription("해당 차에는 좌석이 " + seatCount + " 개 존재합니다.");
    }

    @Override
    public void setEngine(boolean hasEngine) {
        manual.setEngineDescription(manualBooleanMaker("엔진", hasEngine));
    }

    @Override
    public void setTripComputer(boolean hasTripComputer) {
        manual.setTripComputerDescription(manualBooleanMaker("여행 컴퓨터", hasTripComputer));
    }

    @Override
    public void setGPS(boolean hasGPS) {
        manual.setGpsDescription(manualBooleanMaker("GPS", hasGPS));
    }

    Manual getProduct() {
        Manual product = this.manual;
        this.reset();
        return product;
    }
}
