package parking;

public class AbstractCar implements Storable {
    String carNumber;
    int requiredSPace;
    private boolean parked;

    public AbstractCar(String carNumber, int requiredSPace) {
        this.carNumber = carNumber;
        this.requiredSPace = requiredSPace;
    }

    public int getRequiredSPace() {
        return requiredSPace;
    }

    public void setRequiredSPace(int requiredSPace) {
        this.requiredSPace = requiredSPace;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public boolean parked() {
        return false;
    }

    @Override
    public boolean unParked() {
        return false;
    }
}
