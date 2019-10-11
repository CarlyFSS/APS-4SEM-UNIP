package app;

import java.io.IOException;
import java.util.Scanner;

import app.utils.BubbleSort;
import app.utils.RandomNumberGenerator;

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
        int[] arr = {};
        // ----------

        // Main loop
        while (option != 4) {
            showMainMenu();

            option = getUserOption(scn);

            switch (option) {
            case 1:
                clearScreen();
                arr = showGenMenu(scn);
                break;
            case 2:
                clearScreen();
                arr = BubbleSort.sort(arr);
                // Show results
                /*
                 * Data amount: Arr.length()
                 * 
                 * -------- Time results --------
                 * 
                 * Bubble Sort: 5 second(s)
                 * 
                 * Merge Sort: 3 second(s)
                 * 
                 * Selection Sort: 4 second(s)
                 * 
                 * Press any key to continue...
                 * 
                 */
                break;
            case 3:
                clearScreen();
                showArray(arr);
                break;
            case 4:
                option = 4;
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
        System.out.println("1 - Generate number array");
        System.out.println("2 - Test sort algorithms");
        System.out.println("3 - Show Array");
        System.out.println("4 - Exit");
    }

    public static void showArray(int arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] + "]" : arr[i] + ", ");
        }
    }

    public static int[] showGenMenu(Scanner scanner) {
        int[] arr;
        int max;
        int min;
        int size;

        System.out.print("Type the maximum value you want in the array: ");
        max = scanner.nextInt();

        System.out.print("\n");

        System.out.print("Type the minimum value you want in the array: ");
        min = scanner.nextInt();

        System.out.print("\n");

        System.out.print("Type the size of the array: ");
        size = scanner.nextInt();

        System.out.print("\n\n Generating array...");
        arr = generateNumberArray(size, max, min);
        System.out.print("\n\n Array generated!");

        clearScreen();
        return arr;
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

    public static int[] generateNumberArray(int size, int max, int min) {
        RandomNumberGenerator rng = new RandomNumberGenerator();

        return rng.genRandomNumberArray(size, min, max);
    }
}