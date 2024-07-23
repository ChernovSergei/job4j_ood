package parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TruckParking extends AbstractParking implements Parking {
    Map<Integer, AbstractCar> truckParking;
    int truckLotsNumber;

    public TruckParking(int truckLotsNumber) {
        this.truckLotsNumber = truckLotsNumber;
        truckParking = new HashMap<>(truckLotsNumber);
    }

    @Override
    public void putIntoParkingLot(AbstractCar car, List<Integer> availableLots) {
        availableLots.forEach(i -> truckParking.put(i, car));
    }

    @Override
    public boolean removeFromParkingLot(AbstractCar car, List<Integer> lots) {
        return false;
    }

    @Override
    public boolean park(AbstractCar car) {
        List<Integer> availableLots = getAvailableLots(car);
        if (car.getRequiredSPace() == 1) {
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
        for (int i = 0; i < truckParking.size(); i++) {
            if (truckParking.get(i) != null) {
                result.add(truckParking.get(i));
            }
        }
        return result;
    }

    public List<Integer> getAvailableLots(AbstractCar car) {
        List<Integer> result = new ArrayList<>();
        int requiredSpace = car.requiredSPace;
        for (int i = 0, j = 0; i < truckLotsNumber && j != requiredSpace; i++) {
            result.add(i);
            j = (truckParking.get(i) == null) ? j + 1 : 0;
            if (j == 0 || i + 1 == truckLotsNumber && result.size() != requiredSpace) {
                result.clear();
            }
        }
        return result;
    }
}
