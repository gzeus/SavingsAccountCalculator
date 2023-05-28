import java.util.ArrayList;

public class User {

    private String name;
    private double initialInvestment;

    private double monthlyInvestment;


    private int months;

    private ArrayList<Account> accounts = new ArrayList<>();


    public double getInitialInvestment() {
        return initialInvestment;
    }

    public double getMonthlyInvestment() {
        return monthlyInvestment;
    }

    public int getMonths() {
        return months;
    }

    /**
     * Prints out all the accounts and their final balances
     */
    public void printAccounts() {

        System.out.println("%20s       %20s".formatted("ÚČET", "KONEČNÁ ČÁSTKA"));
        System.out.println("-".repeat(40));
        for (Account acc : accounts) {
            Account.calculateBalance(this, acc, months);
        }

    }

    @Override
    public String toString() {

        String lengthString;
        String monthsString;

        if (months % 12 == 0) {
            monthsString = "";
        } else if (months % 12 == 1) {
            monthsString = "1 měsíce";
        } else {
            monthsString = "%d měsíců".formatted(months % 12);
        }


        if (months < 12) {
            lengthString = monthsString;
        } else if (months < 24) {
            if (monthsString.equals("")) {
                lengthString = "%d roku".formatted(months / 12);
            } else {
                lengthString = "%d roku a %s".formatted(months / 12, monthsString);
            }

        } else {
            if (monthsString.equals("")) {
                lengthString = "%d let".formatted(months / 12);
            } else {
                lengthString = "%d let a %s".formatted(months / 12, monthsString);
            }


        }

        return """
                Uživatel/ka %s má počáteční vklad %.2f Kč,
                plánuje investovat měsíčně %.2f Kč po celkovou dobu %s.
                """.formatted(name, initialInvestment, monthlyInvestment, lengthString);

    }

    protected void addAccount(Account account) {
        if (account != null) {
            accounts.add(account);
        }

    }

    ;

    public User(String name, double initialInvestment, double monthlyInvestment, int months) {
        this.name = name;
        this.initialInvestment = initialInvestment;
        this.monthlyInvestment = monthlyInvestment;

        this.months = months;
    }


}
