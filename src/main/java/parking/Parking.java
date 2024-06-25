package parking;

import java.util.List;

public interface Parking {
    List<Integer> park(AbstractCar car);

    boolean remove(AbstractCar car, List<Integer> lots);
}
