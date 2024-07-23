package parking;

public class ParkingControlSystem implements Accountable {
    AbstractParking parks;

    public ParkingControlSystem(AbstractParking park1, AbstractParking... chain) {
        parks = AbstractParking.link(
                park1,
                chain
        );
    }

    @Override
    public void registerCar(AbstractCar car) {
        parks.park(car);
    }

    @Override
    public void unRegisterCar(AbstractCar car) {
        /**
         * remove the car from CarPark
         */
    }
}
