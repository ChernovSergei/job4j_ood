package parking;

public class Automobile extends AbstractCar {

    public Automobile(String carNumber, int requiredSPace) {
        super(carNumber, requiredSPace);
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
