import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Account {
   // Class Variables
    double balance;
    double previousTransaction;
    String customerName;
    String customerID;

    // Set up Account
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }
    // Function to print out the Main Menu with user's options
    public void getMenu() {
        char option = '\0';
        Scanner scnr = new Scanner(System.in);

        System.out.println(customerName + ", welcome" + " to the KarmaBank!");
        System.out.println();
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer ID: " + customerID);
        System.out.println();
        System.out.println("What would you like to do today?");
        System.out.println();
        System.out.println("A. Check my balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawl");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scnr.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {

                // Case A allow the user to check their account balance
                case 'A':
                    System.out.println();
                    System.out.println("=========================================");
                    checkBalance();
                    System.out.println("=========================================");
                    System.out.println();
                    break;

                 // Case B allows the user to deposit
                case 'B':
                    System.out.println("Please enter the amount to deposit: ");
                    double amount = scnr.nextDouble();
                    System.out.println("=========================================");
                    makeDeposit(amount);
                    System.out.println("=========================================");
                    break;

                case 'C':
                    System.out.println("Please enter the amount to withdraw: ");
                    double amountWithdraw = scnr.nextDouble();
                    System.out.println("=========================================");
                    withdraw(amountWithdraw);
                    System.out.println("=========================================");
                    break;

                case 'D':
                    System.out.println();
                    System.out.println("=========================================");
                    viewPreviousTransaction();
                    System.out.println("=========================================");
                    break;

                case 'E':
                    System.out.println();
                    System.out.println("Enter the years of the accrued interest: ");
                    int userYear = scnr.nextInt();
                    System.out.println("Enter the months of the accrued interest: ");
                    int userMonth = scnr.nextInt();
                    System.out.println("=========================================");
                    calculateInterest(userYear, userMonth);
                    System.out.println("=========================================");
                    break;

                case 'F':
                    System.out.println();
                    System.out.println("=========================================");
                    System.out.println("You have successfully exited your account.");
                    System.out.println();
                    System.out.println("=========================================");
                    break;

                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, or F.");
                    break;


            }

        } while (option != 'F');
        System.out.println();
        System.out.println("Thank you for banking with us!");

    }
    // Function to check the user's current balance in the account
    void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }
    // Function to allow the user to make deposit to the account
    void makeDeposit(double userDeposit) {
        balance = balance + userDeposit;
        previousTransaction = userDeposit;
        System.out.println("You have successfully deposited $" + userDeposit);
        checkBalance();
    }

    // Function to allow the user to withdraw from their account
    void withdraw(double userWithdraw) {
        balance = balance - userWithdraw;
        previousTransaction = - userWithdraw;
        System.out.println("You have successfully withdrawn $" + userWithdraw);
        checkBalance();
    }

    // Function to allow the user to view their previous transaction
    void viewPreviousTransaction() {
        System.out.println();
        if(previousTransaction > 0) {
            System.out.println("You deposited $" + previousTransaction);
        }

        else if(previousTransaction < 0) {
            System.out.println("You withdrew $" + Math.abs(previousTransaction));
        }

        else{
            System.out.println("No transaction occurred");
        }
    }

    // Function to allow user to calculate their accrued interest plus the capital in n years and m months
    void calculateInterest (int inYears, int inMonths) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        LocalDate localDate = LocalDate.now();

        double currentInterest = 0.022032003;
        double totalPlusInterest = balance + balance * currentInterest * (inYears + ((double)inMonths / 12));

        System.out.println("Current interest as of " + dtf.format(localDate) + " is: " + currentInterest);
        System.out.print("Your new balance after " + inYears + " years and " + inMonths + " months is: $");
        System.out.println(totalPlusInterest);

    }


}

