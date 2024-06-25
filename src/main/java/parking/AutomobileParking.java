package parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutomobileParking extends AbstractParking {
    Map<Integer, AbstractCar> automobileParking;

    public AutomobileParking(int autoLotsNumber) {
        automobileParking = new HashMap<>(autoLotsNumber);
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
}
