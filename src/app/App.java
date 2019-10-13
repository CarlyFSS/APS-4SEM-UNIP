package app;

import java.io.IOException;
import java.util.Scanner;

import app.utils.BubbleSort;
import app.utils.RandomNumberGenerator;
import app.utils.TimeCounter;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to sort algorithm measure");
        System.out.println("Presented sort algorithms:");
        System.out.println("- Bubble Sort");
        System.out.println("- Merge Sort");
        System.out.println("- Selection Sort");

        // Variables
        int option = 5;
        Scanner scanner = new Scanner(System.in);
        int[] arr = {};

        // ----------

        // Main loop
        while (option != 4) {
            option = getUserOption(scanner);

            switch (option) {
            case 1:
                clearScreen();
                arr = showGenMenu(scanner);
                break;
            case 2:
                clearScreen();
                showSortResult(arr, scanner);
                break;
            case 3:
                clearScreen();
                showArray(arr);
                break;
            case 4:
                scanner.close();
                option = 4;
                break;
            default:
                break;
            }
        }
        // End main loop
    }

    // Functions

    public static void showSortResult(int[] arr, Scanner scanner) {
        clearScreen();
        System.out.println("Data amount: " + arr.length);
        System.out.println("\n");
        System.out.println("-------- Time results --------");
        System.out.println("\n");
        System.out.println("Bubble Sort   : " + runBubbleSortAndGetTime(arr));
        System.out.println("Merge Sort    : " + runSelectionSortAndGetTime(arr));
        System.out.println("Selection Sort: " + runMergeSortAndGetTime(arr));
        System.out.println("\n\n");
        System.out.println("Press any key to continue...");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static long runBubbleSortAndGetTime(int[] arr) {
        TimeCounter timeCounter = new TimeCounter();

        timeCounter.startCounter();
        arr = BubbleSort.sort(arr);
        timeCounter.stopCounter();

        return timeCounter.calculateElapsedTimeInSeconds();
    }

    public static long runSelectionSortAndGetTime(int[] arr) {
        TimeCounter timeCounter = new TimeCounter();

        timeCounter.startCounter();
        // arr = SelectionSort.sort(arr);
        timeCounter.stopCounter();

        return timeCounter.calculateElapsedTimeInSeconds();
    }

    public static long runMergeSortAndGetTime(int[] arr) {
        TimeCounter timeCounter = new TimeCounter();

        timeCounter.startCounter();
        // arr = MergeSort.sort(arr);
        timeCounter.stopCounter();

        return timeCounter.calculateElapsedTimeInSeconds();
    }

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
        // Treat all errors in inputs
        int[] arr = {};
        int max = 0;
        int min = 0;
        int size = 0;
        boolean proceed = false;

        while (proceed != true) {
            try {
                System.out.print("Type the maximum value you want in the array: ");
                max = scanner.nextInt();
                clearScreen();
                proceed = true;
            } catch (Exception e) {
                System.out.println("Value must be a number!!");
                System.out.println("\n Press any key to continue...");
                scanner.nextLine();
                scanner.nextLine();
                clearScreen();
                proceed = false;
            }
        }

        proceed = false;
        System.out.print("\n");

        while (proceed != true) {
            try {
                System.out.print("Type the maximum value you want in the array: " + max + "\n");
                System.out.print("Type the minimum value you want in the array: ");
                min = scanner.nextInt();
                clearScreen();

                if (min > max) {
                    throw new Exception("\nMinimum value must be higher than maximum value!\n");
                }

                proceed = true;
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                } else {
                    System.out.println("Value must be a number!!");
                }

                System.out.println("\n Press any key to continue...");
                scanner.nextLine();
                scanner.nextLine();
                clearScreen();
                proceed = false;
            }
        }

        proceed = false;
        System.out.print("\n");

        while (proceed != true) {
            try {
                System.out.print("Type the maximum value you want in the array: " + max + "\n");
                System.out.print("Type the minimum value you want in the array: " + min + "\n");
                System.out.print("Type the size of the array: ");
                size = scanner.nextInt();
                proceed = true;
            } catch (Exception e) {
                System.out.println("Size must be a number!!");
                System.out.println("\n Press any key to continue...");
                scanner.nextLine();
                scanner.nextLine();
                clearScreen();
                proceed = false;
            }
        }

        System.out.print("\n\n Generating array...");
        arr = generateNumberArray(size, max, min);
        System.out.print("\n\n Array generated!");

        clearScreen();
        return arr;
    }

    public static int getUserOption(Scanner scanner) throws IOException {
        int tempOpt = 0;
        showMainMenu();
        System.out.print("\nOption: ");

        try {
            tempOpt = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("\nOption must be a number!");
            System.out.println("\n Press any key to continue...");
            scanner.nextLine();
            scanner.nextLine();
            clearScreen();
            showMainMenu();
            return getUserOption(scanner);
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