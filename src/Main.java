import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        User user = createUser();
        createAccount(user);
        optionMenu(user);


    }

    /**
     * Get the user's input and create a user instance
     */
    public static User createUser() {

        System.out.println("""
                Vítejte do kalkulačky pro účely srovnání bankovních účtů!
                Níže zadejte parametry svého spoření.
                """);


        System.out.println("Zadejte Vaše jméno:");
        String name = scanner.nextLine();


        System.out.println("Zadejte Váš počáteční vklad:");
        double initialInvestment = parseDoubleInput();

        System.out.println("Zadejte Váš měsíční vklad:");
        double monthlyInvestment = parseDoubleInput();

        System.out.println("Jak dlouho budete investovat? Nejprve zadejte počet let:");
        int years = parseIntInput();

        System.out.println("A nyní počet měsíců:");
        int months = parseIntInput();


        User user = new User(name, initialInvestment, monthlyInvestment, years * 12 + months);

        System.out.println(user);
        return user;

    }

    /**
     * create new account for the user
     */
    public static void createAccount(User user) {
        System.out.println("Vytvářím nový účet");
        System.out.println("-".repeat(30));
        System.out.println("Zadejte popis nového účtu:");
        String name = scanner.nextLine();

        System.out.println("Zadejte měsíční poplatek tohoto účtu (v Kč):");
        double monthlyFlatFees = parseDoubleInput();

        System.out.println("Zadejte roční úrokovou sazbu (v %):");
        double interestRate = parseDoubleInput();


        user.addAccount(new Account(name, monthlyFlatFees, interestRate));


    }


    /**
     * print out the option menu repeatedly until quitting the program
     */
    public static void optionMenu(User user) {

        boolean quitting = false;

        while (!quitting) {
            System.out.println("-".repeat(30));
            System.out.println("""
                    Co chcete udělat? Zvolte možnost pomocí číslice:
                    1) Přidat další účet
                    2) Vytisknout srovnání všech účtů
                    3) Opustit aplikaci
                    """);


            switch (parseIntInput()) {
                case 1 -> createAccount(user);
                case 2 -> user.printAccounts();
                case 3 -> quitting = true;
            }
        }

        System.out.println("Děkujeme za použití aplikace!");


    }

    /**
     * Checks the user input and parses it as double
     */
    public static double parseDoubleInput() {
        double input;
        while (true)
            try {
                input = Double.parseDouble(scanner.nextLine());
                if (input < 0) {
                    System.out.println("Hodnota nesmí být záporná! Zadej znovu");
                } else {
                    break;
                }


            } catch (NumberFormatException chyba) {
                System.out.println("Neplatné zadání čísla, zkuste to znovu (desetinné číslo musí být odděleno tečkou): ");
            }
        return input;
    }

    /**
     * Checks the user input and parses it as int
     */
    public static int parseIntInput() {
        int input;
        while (true)
            try {
                input = Integer.parseInt(scanner.nextLine());

                if (input < 0) {
                    System.out.println("Hodnota nesmí být záporná! Zadej znovu");
                } else {
                    break;
                }

            } catch (NumberFormatException chyba) {
                System.out.println("Neplatné zadání, zkuste to znovu (nesmí být desetinná čísla): ");
            }
        return input;
    }

}
