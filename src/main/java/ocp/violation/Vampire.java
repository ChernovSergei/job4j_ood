package ocp.violation;

import java.util.Calendar;

/**
 * OCP - software should be open for extention and closed for modification
 * OCP violation - software should be closed for extention and open for modification
 */

public class Vampire {
    private String clan;
    private Calendar birthDay;

    public Vampire(String clan, Calendar birthDay) {
        this.clan = clan;
        this.birthDay = birthDay;
    }

    /**
     * suckTheBlood() method is closed for extention and open for modification
     * If we would like add another behaviour (e.g. add Gangrel clan),
     * we will have to modify the method - add another case "Gangrel"
     */
    public void suckTheBlood() {
        switch (clan) {
            case "Tremere":
                System.out.println("Use magic to get the blood");
                break;
            case "Nosferatu":
                System.out.println("Use invisibility to crouch behind a victim");
                System.out.println("Attack from the back and bite the neck");
                break;
            case "Malkavia":
                System.out.println("Lead a victim into madness");
                System.out.println("Ask him to give you his/ her blood");
            default:
                System.out.println("Run to the victim and bite the neck");
        }
    }
}
