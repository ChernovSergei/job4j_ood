package srp.violation;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Vampire {
    /**
    * Vampire class violates SRP
    * There are more than one reason to change it.
    * Class has two methods: suckTheBlood(); fly;
    * All clans are feeding in the same way, but fly in different.
    * Method fly() has to be determined in another class and implements interface flyable.
    * Another creatures could you that flyable interface (e.g. Witches, Gins, Pegasus etc).
     */
    private String clan;
    private String name;
    private Calendar birthDate;

    public Vampire(String clan, String name, Calendar birthDate) {
        this.clan = clan;
        this.name = name;
        this.birthDate = birthDate;
    }

    /**
     * setters and getters are here
     */
    public boolean suckTheBlood() {
        /**
         * find a victim and byte the neck
         */
        return true;
    }

    public void fly() {
        /**
        * turn vampire into a bat.
        * Bat flies to somewhere.
        */
    }

    public static void main(String[] args) {
        /**
         * We can create tremere representative
         */
        Vampire tremereVasiliy = new Vampire("Tremere", "Vasiliy", new GregorianCalendar(2, 1, 03));
        tremereVasiliy.suckTheBlood();
        tremereVasiliy.fly();

        /**
        * But we cannot create another clan representative.
        * All clans feed in the same way, but not all clans fly in the same way.

        * We cannot create nosferatu representative. They cannot fly.
        * We cannot create Ventru. They fly in another way.
         */
        Vampire nosferatuNatasha = new Vampire("Nosferatu", "Natasha", new GregorianCalendar(1900, 05, 27));
        /**
        * we cannot use nosferatuNatasha.fly(), they cannot fly
         */
    }
}
