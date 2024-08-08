package dip.violations.returnvalue;

public class FirstWorldBank {
    long anualIncome;
    long montlyIncome;

    public Mortgage provideMorgage(long percentage, long montlyPayment) {
        System.out.println("add and re calculate bank income");
        return new Mortgage(percentage, montlyPayment);
    }

    public BaseLoan provideBaseLoan(long percentage, long montlyPayment) {
        System.out.println("add and re calculate bank income");
        return new BaseLoan(percentage, montlyPayment);
    }
}
