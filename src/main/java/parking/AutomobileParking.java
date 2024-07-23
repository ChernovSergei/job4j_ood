package parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutomobileParking extends AbstractParking implements Parking {
    Map<Integer, AbstractCar> automobileParking;
    int autoLotsNumber;

    public AutomobileParking(int autoLotsNumber) {
        this.autoLotsNumber = autoLotsNumber;
        automobileParking = new HashMap<>(autoLotsNumber);
    }

    @Override
    public void putIntoParkingLot(AbstractCar car, List<Integer> availableLots) {
        availableLots.forEach(i -> automobileParking.put(i, car));
    }

    @Override
    public boolean removeFromParkingLot(AbstractCar car, List<Integer> lots) {
        return false;
    }

    @Override
    public boolean park(AbstractCar car) {
        List<Integer> availableLots = getAvailableLots(car);
        if (car.getRequiredSPace() == 0) {
            return checkNextParking(car);
        }
        if (availableLots.size() == 0) {
            return checkNextParking(car);
        }
        if (!getParkedCars().contains(car)) {
            this.putIntoParkingLot(car, availableLots);
        }
        return true;
    }

    @Override
    public List<AbstractCar> getParkedCars() {
        List<AbstractCar> result = new ArrayList<>();
        for (int i = 0; i < automobileParking.size(); i++) {
            if (automobileParking.get(i) != null) {
                result.add(automobileParking.get(i));
            }
        }
        return result;
    }

    public List<Integer> getAvailableLots(AbstractCar car) {
        List<Integer> result = new ArrayList<>();
        int requiredSpace = car.requiredSPace;
        for (int i = 0, j = 0; i < autoLotsNumber && j != requiredSpace; i++) {
            result.add(i);
            j = (automobileParking.get(i) == null) ? j + 1 : 0;
            if (j == 0 || i + 1 == autoLotsNumber && result.size() != requiredSpace) {
                result.clear();
            }
        }
        return result;
    }
}