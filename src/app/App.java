package app;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to sort algorithm measure");
        System.out.println("Presented sort algorithms:");
        System.out.println("- Bubble Sort");
        System.out.println("- Merge Sort");
        System.out.println("- Selection Sort");

        // Variables
        int option = 0;
        Scanner scn = new Scanner(System.in);
        // ----------

        // Main loop
        while (option != 3) {
            showMainMenu();

            option = getUserOption(scn);

            switch (option) {
            case 1:
                clearScreen();
                System.out.println("Option 1");
                break;
            case 2:
                clearScreen();
                System.out.println("Option 2");
                break;
            case 3:
                option = 3;
                break;
            default:
                System.out.println("Invalid option!!");
                break;
            }
        }
        // End main loop
    }

    // Functions

    public static void showMainMenu() {
        System.out.println("\n\nWhat do you want to do?");
        System.out.println("1 - Generate number file");
        System.out.println("2 - Test sort algorithms");
        System.out.println("3 - Exit");
    }

    public static int getUserOption(Scanner scanner) throws IOException {
        int tempOpt = 0;
        System.out.print("\nOption: ");

        try {
            tempOpt = scanner.nextInt();
        } catch (Error e) {
            System.out.println(e.getMessage());
        }

        return tempOpt;
    }

    public static void clearScreen() {
        for (int i = 0; i < 30; i++) {
            System.out.println("\n");
        }
    }
}