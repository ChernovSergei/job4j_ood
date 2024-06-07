package ocp.violation;

import java.util.Calendar;

/**
 * OCP - software should be open for extention and closed for modification
 * OCP violation - software should be closed for extention and open for modification
 */
public class Shrine {
    /**
     * It would be better if method accept and return abstract data types.
     * If we would like to call for riverhorse we should modify the class - add another method
     * If we would create a method which accept EvilCreature type and function and return the EvilCreature
     * It would comply with OCP
     */

    public Vampire vampireCall(String clan, Calendar bithDate) {
        Vampire calledVampire = new Vampire(clan, bithDate);
        /**
         * wait for a night
         * spill the blood
         * wait till vampire knock the window
         * invite the vampire
         */
        return calledVampire;
    }

    /**
     * public Witch witchCall(...) {
     *     go to the nearest fortuneteller
     *     request meeting with witch
     *     tell the address, date, time
     *     ask about sacrifice requirement
     *     wait for a witch
     *     repeat all above actions with another fortuneteller in case of misfortune
     * }
     */

    /**
     * public Bogie inviteBogie(...) {
     *     you should be alone at home
     *     prepare four spoons and piece of papers
     *     wrap each spoon with piece of paper
     *     close the eyes
     *     say loudly 3 times "Grandfather neighbor, nice and good, come out dear!"
     *     if Bogie wants to speak with he will appear.
     * }
     */
}
