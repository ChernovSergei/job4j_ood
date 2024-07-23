package parking;

import java.util.List;

public interface Parking {
    void putIntoParkingLot(AbstractCar car, List<Integer> availableLots);

    boolean removeFromParkingLot(AbstractCar car, List<Integer> lots);
}
