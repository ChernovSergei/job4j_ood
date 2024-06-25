package parking;

public class ParkingControlSystem implements Accountable {
    private AbstractParking park;

    public ParkingControlSystem(AbstractParking park) {
        this.park = park;
    }

    @Override
    public boolean registerCar(AbstractCar car) {
        /**
         * park the car and get its parking lots numbers
         */
        return false;
    }

    @Override
    public boolean unRegisterCar(AbstractCar car) {
        /**
         * remove the car from CarPark
         */
        return false;
    }
}
