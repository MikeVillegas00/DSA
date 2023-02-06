import java.util.Scanner;

public class OE_2_Villegas {

    public static void bubbleSort(int[] arr) {
        int z = arr.length;
        int iteration = 0;

        for (int i = 0; i < z - 1; i++) {
            for (int x = 0; z < z - i - 1; z++) {
                if (arr[x] > arr[x + 1]) {
                    int temp = arr[z];
                    arr[x] = arr[x + 1];
                    arr[x + 1] = temp;
                }
                iteration++;
            }
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < z; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nNumber of iterations: " + iteration);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int ite = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                ite++;
            }
            arr[j + 1] = key;
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nNumber of iterations: " + ite);
    }

    public static void promptAndWait() {
        System.out.print("Press any key to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the index [" + i + "] number :");
            arr[i] = sc.nextInt();
        }

        do {
            System.out.println("Enter [1] for Bubble Sort.");
            System.out.println("Enter [2] for Insertion Sort.");
            System.out.println("Enter [0] to Exit the Program.");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bubbleSort(arr);
                    promptAndWait();
                    break;
                case 2:
                    insertionSort(arr);
                    promptAndWait();
                    break;
                case 0:
                    System.out.println("Closing the program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
                    promptAndWait();
            }
        } while (true);
    }
}