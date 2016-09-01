import java.util.HashMap;

/**
 * Created by halleyfroeb on 8/31/16. User Interface of an ATM Machine
 */
public class User {
    public static int options;

    public static void runProgram() {

            System.out.println("Welcome to The Bank of Halley");
            chooseName();

            System.out.println("Thank you for using the Bank of Halley, have a nice day :)");
    }

    public static HashMap<String, Double> accounts = new HashMap<>();

    public User() {
        accounts.put("summer", 535.0);
        accounts.put("jerry", 1000.0);
        accounts.put("rick", 3000.0);
        accounts.put("morty", 82.0);
        accounts.put("beth", 2000.0);
        accounts.put("shaggy", 5.0);
        accounts.put("scooby", 100.0);
        accounts.put("fred", 3567.0);
        accounts.put("daphne", 4433.0);
        accounts.put("velma", 3333.0);
    }




    public static void chooseName() {
        String name;
        System.out.println("Please enter your name");

        name = Main.scanner.nextLine().toLowerCase();

        Double newBalance = 0.;
        int makeAccount;

        if (accounts.containsKey(name.toLowerCase())) {
            System.out.println("Welcome, " + name);
        } else if (name.isEmpty()) {
            System.out.println("You must enter a name to continue");
        } else {
            System.out.println("Account not recognized, would you like to make one? [1. Yes Please/ 2. No Thank you]");
            makeAccount = Main.scanner.nextInt();
            if (makeAccount == 1) {
                System.out.println("Please Enter your current balance");
                newBalance = Main.scanner.nextDouble();
                accounts.put(name, newBalance);
                System.out.println("Welcome, " + name + ", to the bank of Halley!, your current balance is $" + newBalance);
            } else if (makeAccount == 2) {
                System.out.println("Thank you, have a nice day!");
            } else {
                System.out.println("Invalid option!");
            }
        }
        chooseOptions(name);
    }



        public static void chooseOptions (String name) {
            Double balance = accounts.get(name);
            int withdraw;

            do {
                System.out.println("Would you like to...[1.Check my balance/ 2.Withdraw funds/ 3.Remove Account/ 4.Exit]");
                options = Main.scanner.nextInt();
                if (options == 1) {
                    System.out.println("Your balance is $" + balance);

                } else if (options == 2) {
                    System.out.println("How much money would you like to withdraw?");
                    withdraw = Main.scanner.nextInt();
                    if (withdraw > 1000) {
                        System.out.println("You have exceeded the amount of money that you can withdraw at one time");
                    } else if (balance < withdraw) {
                        System.out.println("Insufficient Funds, your balance is $" + balance);
                    } else if (withdraw < 1000 && withdraw > 0) {
                        balance = balance - withdraw;
                        System.out.println("Please take your cash, your remaining balance is $" + (balance));
                    } else {
                        System.out.println("Invalid Withdraw");
                    }
                } else if (options == 4) {
                    runProgram();

                } else if (options == 3) {
                    accounts.remove(name, balance);
                    System.out.println("Your account has been deactivated");
                } else {
                    System.out.println("Invalid option" + options);
                }

            } while (options != 3 && options != 4);
        }

    }







