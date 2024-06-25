package parking;

public class Truck extends AbstractCar {

    public Truck(String carNumber, int requiredSPace) {
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
