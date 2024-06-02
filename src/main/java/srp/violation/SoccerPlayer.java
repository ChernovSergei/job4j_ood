package srp.violation;

import java.time.LocalDateTime;
import java.util.Calendar;

public class SoccerPlayer {
    /*
    soccerPlayer class violets SRP - there is more than one reason to change the class.
    The class has two methods: play(); successProbability.
    Method play() combines complex logic dictating how to kick/stop/catch the ball.
    The play() method has to be split up to five separate methods.
    As soon as there are different types of players (forward, back, goal keeper), these methods should be located in different classes.
    The probabilities to kick, catch, stop the ball are calculated differently.
    The successProbability() methods should be located in different classes for each method.
     */
    private String teamName;
    private String name;
    private Calendar birthDate;
    private Calendar careerStart;

    public SoccerPlayer(String teamName, String name, Calendar birthDate, Calendar careerStart) {
        this.teamName = teamName;
        this.name = name;
        this.birthDate = birthDate;
        this.careerStart = careerStart;
    }

    //setters and getters are here

    public void play() {
        //kick a ball method considering successProbability
        //stop a ball method
        //catch a boll method
        //corner kick method considering successProbability
        //penalty kick method considering successProbability
    }

    public double successProbability(double numberOfKicks, double numberSuccessfulKicks) {
        LocalDateTime today = LocalDateTime.now();
        double experienceCoefficient = (double) (today.getYear() - careerStart.get(Calendar.YEAR)) / 100;
        double ageCoefficient = (double) (today.getYear() - birthDate.get(Calendar.YEAR)) / 100;
        return numberSuccessfulKicks / numberOfKicks + experienceCoefficient - ageCoefficient;
    }

}
