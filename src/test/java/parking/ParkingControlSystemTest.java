package parking;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ParkingControlSystemTest {
    AbstractParking himkiTruckPark = new TruckParking(6);
    AbstractParking himkiAutoPark = new AutomobileParking(6);
    AbstractCar volvoVH500 = new Truck("c560en190", 4);
    AbstractCar manTGX18 = new Truck("y839bx601", 4);
    AbstractCar scaniaR500 = new Truck("i888o903", 4);
    AbstractCar kiaRio = new Automobile("r392xb022", 1);
    AbstractCar bmwX3 = new Automobile("o000o000", 1);
    AbstractCar chevroletMalibu = new Automobile("q969bk101", 1);
    List<AbstractParking> park = new ArrayList<>();
    ParkingControlSystem controlSystem = new ParkingControlSystem(park);
    List<AbstractCar> cars = new ArrayList<>();

    @Test
    public void whenOneAutomobileGoesToAutoParking() {
        park.add(himkiAutoPark);
        park.add(himkiTruckPark);
        cars.add(bmwX3);
        for (AbstractCar car: cars) {
            controlSystem.registerCar(car);
        }
        assertThat(himkiAutoPark.getParkedCars().contains(bmwX3)).isTrue();
    }

    @Test
    public void whenTheSameCarIsParkingTwice() {
        park.add(himkiAutoPark);
        park.add(himkiTruckPark);
        cars.add(bmwX3);
        cars.add(bmwX3);
        for (AbstractCar car: cars) {
            controlSystem.registerCar(car);
        }
        assertThat((long) himkiAutoPark.getParkedCars().size()).isEqualTo(1);
    }

    @Test
    public void whenOneTruckGoesToAutomobileParking() {
        park.add(himkiAutoPark);
        park.add(himkiTruckPark);
        cars.add(scaniaR500);
        cars.add(chevroletMalibu);
        for (AbstractCar car: cars) {
            controlSystem.registerCar(car);
        }
        controlSystem.registerCar(volvoVH500);
        assertThat(himkiAutoPark.getParkedCars().contains(manTGX18)).isTrue();
        assertThat(himkiTruckPark.getParkedCars().contains(manTGX18)).isFalse();
    }

    @Test
    public void whenThereIsNoFreeSpaceForTruck() {
        park.add(himkiAutoPark);
        park.add(himkiTruckPark);
        cars.add(scaniaR500);
        cars.add(manTGX18);
        cars.add(chevroletMalibu);
        cars.add(kiaRio);
        for (AbstractCar car: cars) {
            controlSystem.registerCar(car);
        }
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> controlSystem.registerCar(volvoVH500));
        assertThat(exception.getMessage()).isEqualTo("Sorry! There is no available lots in the parking");
    }

    @Test
    public void whenThereIsNoFreeForAutomobile() {
        park.add(himkiAutoPark);
        park.add(himkiTruckPark);
        cars.add(scaniaR500);
        cars.add(chevroletMalibu);
        cars.add(kiaRio);
        for (AbstractCar car: cars) {
            controlSystem.registerCar(car);
        }
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> controlSystem.registerCar(bmwX3));
        assertThat(exception.getMessage()).isEqualTo("Sorry! There is no available lots in the parking");
    }
}