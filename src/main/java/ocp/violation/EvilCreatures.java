package ocp.violation;

import srp.violation.Vampire;

import java.util.GregorianCalendar;

/**
 * OCP - software should be open for extention and closed for modification
 * OCP violation - software should be closed for extention and open for modification
 */

public class EvilCreatures {
    /**
     *The class variables has to be abstract or primitive.
     *Otherwise, a software engineer has to modify the class in case of changes.
     *E.g. Customer decided delete/ add new evil creature (let say - demon). So, the class has to be modified.
     *It would be better to create abstract class "EvilCreatures" and "SabbathOrganization"
     * Classes Vampire, Witch, Bogie have to be inherited from EvilCreatures.
     * Method sabbathOrganize would be better to put inside "SabbathOrganization"
     */

    srp.violation.Vampire alukard = new Vampire("Tremere", "Alukard", new GregorianCalendar(1, 1, 1));
    /**
     * Here is another variables:
     * RiverHorse riverMan = new RiverHorse("Vanya");
     * Witch joanna = new Witch("Goanna", new GregorianCalendar(1941, 2, 13);
     * Bogie georgi = new Bogie("Georgi", "Home");
     */

    public void sabbathOrganize() {
        /**
         * invite(alukard);
         * invite(riverMan);
         * invite(joanna);
         */
    }
}
