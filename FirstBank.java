import java.util.Scanner;

public class FirstBank {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to KarmaBank!");
        System.out.println("Please enter your name: ");
        String newName = scnr.nextLine();
        String newID = "C204030";


        Account conan = new Account(newName,newID);
        conan.getMenu();
    }

}
