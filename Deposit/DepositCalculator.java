import java.util.Scanner;

class Deposit {
    double principal;
    double rate;
    int time;

    public Deposit(double principal, double rate, int time) {
        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    public double calculateInterest() {
        return 0;
    }
}

class FixedDeposit extends Deposit {
    public FixedDeposit(double principal, double rate, int time) {
        super(principal, rate, time);
    }

    @Override
    public double calculateInterest() {
        return principal * rate * time / 100;
    }
}

class RecurringDeposit extends Deposit {
    int months;

    public RecurringDeposit(double monthlyDeposit, double rate, int months) {
        super(monthlyDeposit, rate, months / 12); // Converting months to years
        this.months = months;
    }

    @Override
    public double calculateInterest() {
        double totalPrincipal = principal * months; // Total deposited amount
        double maturityValue = (principal * months) + (principal * months * (months + 1) / 2 * rate / 1200);
        return maturityValue - totalPrincipal;
    }
}

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Deposit Type (1 for FD, 2 for RD): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Principal Amount: ");
                double fdPrincipal = sc.nextDouble();
                System.out.print("Enter Annual Interest Rate (%): ");
                double fdRate = sc.nextDouble();
                System.out.print("Enter Time (in years): ");
                int fdTime = sc.nextInt();

                FixedDeposit fd = new FixedDeposit(fdPrincipal, fdRate, fdTime);
                System.out.println("Fixed Deposit Interest: " + fd.calculateInterest());
                break;

            case 2:
                System.out.print("Enter Monthly Deposit Amount: ");
                double rdMonthlyDeposit = sc.nextDouble();
                System.out.print("Enter Annual Interest Rate (%): ");
                double rdRate = sc.nextDouble();
                System.out.print("Enter Time (in months): ");
                int rdMonths = sc.nextInt();

                RecurringDeposit rd = new RecurringDeposit(rdMonthlyDeposit, rdRate, rdMonths);
                System.out.println("Recurring Deposit Interest: " + rd.calculateInterest());
                break;

            default:
                System.out.println("Invalid Choice! Please select 1 or 2.");
        }

        sc.close();
    }
}
