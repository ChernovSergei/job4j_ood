package dip.violations.returnvalue;

public class BaseLoan {
    long percentage;
    long monthlyPayment;

    public BaseLoan(long percentage, long monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
        this.percentage = percentage;
    }
}
