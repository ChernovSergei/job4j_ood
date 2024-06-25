package parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingControlSystem implements Accountable {
    private List<AbstractParking> parks;

    public ParkingControlSystem(List<AbstractParking> parks) {
        this.parks = parks;
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

    public static void main(String[] args) {
        AbstractParking himkiTruckPark = new TruckParking(12);
        AbstractParking himkiAutoPark = new AutomobileParking(12);
        List<AbstractParking> park = new ArrayList<>();
        park.add(himkiAutoPark);
        park.add(himkiTruckPark);
        ParkingControlSystem controlSystem = new ParkingControlSystem(park);
        List<AbstractCar> cars = new ArrayList<>();
        AbstractCar volvoVH500 = new Truck("c560en190", 4);
        AbstractCar manTGX18 = new Truck("y839bx601", 3);
        AbstractCar scaniaR500 = new Truck("i888o903", 6);
        AbstractCar kiaRio = new Automobile("r392xb022", 1);
        AbstractCar bmwX3 = new Automobile("o000o000", 1);
        AbstractCar chevroletMalibu = new Automobile("q969bk101", 1);
        cars.add(volvoVH500);
        cars.add(manTGX18);
        cars.add(scaniaR500);
        cars.add(kiaRio);
        cars.add(bmwX3);
        cars.add(chevroletMalibu);
        for (AbstractCar car: cars) {
            controlSystem.registerCar(car);
        }
    }
}
