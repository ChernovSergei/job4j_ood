package parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TruckParking extends AbstractParking {
    Map<Integer, Truck> truckParking;

    public TruckParking(int truckLotsNumber) {
        truckParking = new HashMap<>(truckLotsNumber);
    }

    @Override
    public List<Integer> park(AbstractCar car) {
        return new ArrayList<>();
    }

    @Override
    public boolean remove(AbstractCar car, List<Integer> lots) {
        return false;
    }

    @Override
    public List<Integer> getAvailableLots(AbstractCar car) {
        return null;
    }

    @Override
    public List<AbstractCar> getParkedCars() {
        return null;
    }
}
