package dip.violations.returnvalue;

public class Mortgage {
    long percentage;
    long monthlyPayment;

    public Mortgage(long percentage, long monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
        this.percentage = percentage;
    }
}