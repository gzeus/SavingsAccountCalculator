enum AccountType {SAVING, INVESTMENT}

public  class Account {

    private String name;

    private double finalBalance;


    private double monthlyFlatFees;
    private double interestRate;

    public Account(String name, double monthlyFlatFees, double interestRate) {
        this.name = name;
        this.monthlyFlatFees = monthlyFlatFees;
        this.interestRate = interestRate;

    }

    /**
     * Calculates and prints final balance for the account
     */
    public static void calculateBalance(User user, Account account, int months){
        double endBalance = user.getInitialInvestment();
        for (int i = 0; i < months; i++){

            endBalance += user.getMonthlyInvestment();
            endBalance *= 1 + ( account.interestRate / 12 / 100);
            endBalance -= account.monthlyFlatFees;

        }

            account.finalBalance = endBalance;
        System.out.println("""
                %20s       %15.2f Kč""".formatted(account.name, endBalance));

    };


}






