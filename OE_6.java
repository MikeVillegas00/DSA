import java.util.Scanner;

public class OE_6 {

    public static int QSort(int[] arr, int low, int high) {
            int pivot = arr[high];
            int k = low - 1;
            
            for (int i = low; i <= high-1; i++) {
                if (arr[i] <= pivot) {
                    k++;
                    int temp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = temp;
                }
            }
            
            int temp = arr[k+1];
            arr[k+1] = arr[high];
            arr[high] = temp;
            
            return k+1;
        }

    public static void Sort(int[] array, int low, int high) {
        if (low < high) {
            int Index = QSort(array, low, high);
            Sort(array, low, Index-1);
            Sort(array, Index+1, high);
        }
    }
      
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nEnter array size: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.print("\nEnter unsorted array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Sort(arr, 0, n-1);
        
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.println("[" + arr[i] + "]");
        }
    }
    
    
}