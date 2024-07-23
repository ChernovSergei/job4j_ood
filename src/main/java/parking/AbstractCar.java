package parking;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractCar that = (AbstractCar) o;
        return carNumber.equals(that.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }
}
