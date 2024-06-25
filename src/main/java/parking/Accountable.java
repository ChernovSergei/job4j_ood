package parking;

public interface Accountable {
    boolean registerCar(AbstractCar car);

    boolean unRegisterCar(AbstractCar car);
}
