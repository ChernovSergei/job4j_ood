package parking;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractParking implements Parking {

    @Override
    public List<Integer> park(AbstractCar car) {
        return new ArrayList<>();
    }

    @Override
    public boolean remove(AbstractCar car, List<Integer> lots) {
        return false;
    }

    public abstract List<Integer> getAvailableLots(AbstractCar car);

    public List<AbstractCar> getParkedCars() {
        return null;
    }
}