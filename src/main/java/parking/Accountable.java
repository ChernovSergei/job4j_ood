package parking;

import java.util.List;

public interface Accountable {
    boolean registerCar(AbstractCar car);

    boolean unRegisterCar(AbstractCar car);
}
