package parking;

import java.util.List;

abstract class AbstractParking {
    private AbstractParking next;

    public abstract boolean park(AbstractCar car);

    public List<AbstractCar> getParkedCars() {
        return null;
    }

    public static AbstractParking link(AbstractParking first, AbstractParking... chain) {
        AbstractParking head = first;
        for (AbstractParking nextParking : chain) {
            head.next = nextParking;
            head = nextParking;
        }
        return first;
    }

    protected boolean checkNextParking(AbstractCar car) {
        if (next == null) {
            throw new IllegalArgumentException("Sorry! There is no available lots in the parking");
        }
        return next.park(car);
    }
}