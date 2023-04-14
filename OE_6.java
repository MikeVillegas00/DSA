import java.util.*;

public class OE_6 {

    //Void Functions
    public static void Insertion(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int k = i - 1;
            while (k >= left && arr[k] > key) {
                arr[k + 1] = arr[k];
                k--;
            }
            arr[k + 1] = key;
        }
    } 

    public static int Partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

    public static void Hybrid(int[] arr, int left, int right, int threshold) {
        if (left >= right) {
            return;
        }
        if (right - left + 1 <= threshold) {
            Insertion(arr, left, right);
        } else {
            int pivotIndex = Partition(arr, left, right);
            Hybrid(arr, left, pivotIndex - 1, threshold);
            Hybrid(arr, pivotIndex + 1, right, threshold);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input array size and threshold
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        
        System.out.print("Threshold: ");
        int threshold = sc.nextInt();
        
        //Random Generator
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }
        

        //Unsorted Array
        System.out.println("Unsorted array:");
        System.out.println('[' + Arrays.toString(arr) + ']');

        //Hybrid Array
        Hybrid(arr, 0, n - 1, threshold);
        
        //Sorted Array
        System.out.println("Sorted array:");
        System.out.println('[' + Arrays.toString(arr) + ']');
    }
}


