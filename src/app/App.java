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
        int[] arr1 = {};
        int[] arr2 = {};
        int[] arr3 = {};
        int[] arr4 = {};
        int[] arr5 = {};

        long[][] times = new long[5][3];

        int max = 100000;
        int min = 1;

        // ----------

        // Main loop
        while (option != 4) {
            option = getUserOption(scanner);

            switch (option) {
            case 1:
                clearScreen();

                System.out.println("Generating all arrays, please wait...");

                System.out.println("Generating Array 1...");
                arr1 = generateArray(1000, max, min);
                System.out.println("Array 1 generated with " + arr1.length + " numbers.");

                System.out.println("Generating Array 2...");
                arr2 = generateArray(5000, max, min);
                System.out.println("Array 2 generated with " + arr2.length + " numbers.");

                System.out.println("Generating Array 3...");
                arr3 = generateArray(10000, max, min);
                System.out.println("Array 3 generated with " + arr3.length + " numbers.");

                System.out.println("Generating Array 4...");
                arr4 = generateArray(30000, max, min);
                System.out.println("Array 4 generated with " + arr4.length + " numbers.");

                System.out.println("Generating Array 5...");
                arr5 = generateArray(100000, max, min);
                System.out.println("Array 5 generated with " + arr5.length + " numbers.");

                break;
            case 2:
                clearScreen();
                // showSingleSortResult(arr, scanner);

                System.out.println("Starting all sorts.");
                times = runAllSortAndStoreTimes(arr1, arr2, arr3, arr4, arr5);
                System.out.println("Sorting finished.");

                break;
            case 3:
                clearScreen();
                // showArray(arr);

                showAllSortResults(times, scanner);

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

    public static void showSingleSortResult(int[] arr, Scanner scanner) {
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

    public static long[][] runAllSortAndStoreTimes(int[] arr1, int[] arr2, int[] arr3, int[] arr4, int[] arr5) {
        long[][] times = new long[5][3];

        // Stores times for array 1
        System.out.println("\nStarting sorts for Array 1 ...");

        System.out.println("Running Bubble sort on Array 1 ...");
        times[0][0] = runBubbleSortAndGetTime(arr1);
        System.out.println("Finished running Bubble sort on Array 1 ...");

        System.out.println("Running Merge sort on Array 1 ...");
        times[0][1] = runMergeSortAndGetTime(arr1);
        System.out.println("Finished running Merge sort on Array 1 ...");

        System.out.println("Running Selection sort on Array 1 ...");
        times[0][2] = runSelectionSortAndGetTime(arr1);
        System.out.println("Finished running Selection sort on Array 1 ...");

        // Stores times for array 2
        System.out.println("\nStarting sorts for Array 2 ...");

        System.out.println("Running Bubble sort on Array 2 ...");
        times[1][0] = runBubbleSortAndGetTime(arr2);
        System.out.println("Finished running Bubble sort on Array 2 ...");

        System.out.println("Running Merge sort on Array 2 ...");
        times[1][1] = runMergeSortAndGetTime(arr2);
        System.out.println("Finished running Merge sort on Array 2 ...");

        System.out.println("Running Selection sort on Array 2 ...");
        times[1][2] = runSelectionSortAndGetTime(arr2);
        System.out.println("Finished running Selection sort on Array 2 ...");

        // Stores times for array 3
        System.out.println("\nStarting sorts for Array 3 ...");

        System.out.println("Running Bubble sort on Array 3 ...");
        times[2][0] = runBubbleSortAndGetTime(arr3);
        System.out.println("Finished running Bubble sort on Array 3 ...");

        System.out.println("Running Merge sort on Array 3 ...");
        times[2][1] = runMergeSortAndGetTime(arr3);
        System.out.println("Finished running Merge sort on Array 3 ...");

        System.out.println("Running Selection sort on Array 3 ...");
        times[2][2] = runSelectionSortAndGetTime(arr3);
        System.out.println("Finished running Selection sort on Array 3 ...");

        // Stores times for array 4
        System.out.println("\nStarting sorts for Array 4 ...");

        System.out.println("Running Bubble sort on Array 4 ...");
        times[3][0] = runBubbleSortAndGetTime(arr4);
        System.out.println("Finished running Bubble sort on Array 4 ...");

        System.out.println("Running Merge sort on Array 4 ...");
        times[3][1] = runMergeSortAndGetTime(arr4);
        System.out.println("Finished running Merge sort on Array 4 ...");

        System.out.println("Running Selection sort on Array 4 ...");
        times[3][2] = runSelectionSortAndGetTime(arr4);
        System.out.println("Finished running Selection sort on Array 4 ...");

        // Stores times for array 5
        System.out.println("\nStarting sorts for Array 5 ...");

        System.out.println("Running Bubble sort on Array 5 ...");
        times[4][0] = runBubbleSortAndGetTime(arr5);
        System.out.println("Finished running Bubble sort on Array 5 ...");

        System.out.println("Running Merge sort on Array 5 ...");
        times[4][1] = runMergeSortAndGetTime(arr5);
        System.out.println("Finished running Merge sort on Array 5 ...");

        System.out.println("Running Selection sort on Array 5 ...");
        times[4][2] = runSelectionSortAndGetTime(arr5);
        System.out.println("Finished running Selection sort on Array 5 ...");

        return times;
    }

    public static void showAllSortResults(long[][] times, Scanner scanner) {
        String leftAlignFormat = "|%-15s | %-10d | %-10d | %-10d | %-10d | %-10d | %n";

        System.out.format("+---------------------------------------------------------------------------------+%n");
        System.out.format("|Time is shown in Milliseconds                                                    |%n");
        System.out.format("+---------------------------------------------------------------------------------+%n");
        System.out.format("+    Results     |                          Size                                  |%n");
        System.out.format("+----------------+----------------------------------------------------------------+%n");
        System.out.format("|Method          |    10000   |    5000    |    10000   |    30000   |   100000   |%n");
        System.out.format("+----------------+------------+------------+------------+------------+------------+%n");

        System.out.format(leftAlignFormat, "Bubble Sort", times[0][0], times[1][0], times[2][0], times[3][0],
                times[4][0]);
        System.out.format(leftAlignFormat, "Merge Sort", times[0][1], times[1][1], times[2][1], times[3][1],
                times[4][1]);
        System.out.format(leftAlignFormat, "Selection Sort", times[0][2], times[1][2], times[2][2], times[3][2],
                times[4][2]);

        System.out.format("+---------------------------------------------------------------------------------+%n");

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

        return timeCounter.calculateElapsedTimeInMillis();
    }

    public static long runSelectionSortAndGetTime(int[] arr) {
        TimeCounter timeCounter = new TimeCounter();

        timeCounter.startCounter();
        // arr = SelectionSort.sort(arr);
        timeCounter.stopCounter();

        return timeCounter.calculateElapsedTimeInMillis();
    }

    public static long runMergeSortAndGetTime(int[] arr) {
        TimeCounter timeCounter = new TimeCounter();

        timeCounter.startCounter();
        // arr = MergeSort.sort(arr);
        timeCounter.stopCounter();

        return timeCounter.calculateElapsedTimeInMillis();
    }

    public static void showMainMenu() {
        System.out.println("\n\nWhat do you want to do?");
        System.out.println("1 - Generate number array");
        System.out.println("2 - Test sort algorithms");
        System.out.println("3 - Show results");
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

    public static int[] generateArray(int size, int max, int min) {
        int[] arr = null;

        arr = generateNumberArray(size, max, min);

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