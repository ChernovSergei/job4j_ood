package srp.violation;

public class Car {
    /*
    Class Car violates SRP
    it has multiple possible reasons to change it.
    The class has three methods start(), stop() and calcFuelConsumption().
    All three methods are defined for reciprocating liquid fuel engine car.
    If we try to create gas fuel car, we will have to override calcFuelConsumption() method.
    If we try to create electric car, we will have to change all three methods.
    All methods should be located in separate classes and implement related interfaces runnable & energyConsumption
    After these methods relocation we can re define them for any other means of transportation.
     */
    private String model;
    private int numberOfDoor;
    private boolean run = false;

    public Car(String model, int numberOfDoor) {
        this.model = model;
        this.numberOfDoor = numberOfDoor;
    }

    //setters and getters are here

    public void start() {
        //software check all parameters for reciprocating engine cars.
        //software switch on all necessary equipment and start the reciprocating engine car.
        run = true;
    }

    public void stop() {
        //software check all car parameters for reciprocating engine cars.
        //software switch off all necessary equipment and stop the reciprocating engine car.
        run = false;
    }

    public int fuelConsumption(boolean run, int pedalPosition) {
        int result = 0;
        if (run) {
            //software calcs liquid fuel consumption
            result = pedalPosition * 342;
        }
        return result;
    }

    public static void main(String[] args) {
        //we can create object with reciprocating engine on liquid fuel
        Car cosmich = new Car("Cosmich", 5);
        cosmich.start();
        cosmich.stop();

       /* we cannot create new car on gas fuel.
        Fuel consumption is calculated in another way.
        The fuel consumption should be in separate class and implements energyCalculation interface*/
        Car weCannotCreateZIL130G = new Car("ZIL130G", 2);

        /* we cannot create new electro car.
        Fuel consumption is calculated in another way.
        The start and stop processes are different.
        Start and stop methods should be located in another separate class, which implements method runnable
         */
        Car weCannotCreateTESLA = new Car("Teslo Model A", 5);
    }
}
