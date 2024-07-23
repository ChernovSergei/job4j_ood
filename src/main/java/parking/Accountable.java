package parking;

public interface Accountable {
    void registerCar(AbstractCar car);

    void unRegisterCar(AbstractCar car);
}
