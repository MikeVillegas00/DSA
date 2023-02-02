import java.util.Scanner;

public class OE_1_Villegas {
    
    private static final int MAX = 100;
    

    //VOID DIRECTORY
    public static void promptAndWait() {
        System.out.print("Press any key to continue...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }
    
    //SEARCH
    public static void SEARCH(int[] input, int inpt) {
        int searchIndex;
        boolean found = false;
        do {
            System.out.print("Enter an index to find the Element: ");
            Scanner scan = new Scanner(System.in);
            searchIndex = scan.nextInt();
            if (searchIndex >= 0 && searchIndex < inpt) {
                System.out.println("Element at index " + searchIndex + " is " + input[searchIndex]);
                found = true;
            } else {
                System.out.println("Invalid index to search, please try again.");
            }
        } while (!found);
    }

    //DELETE
    public static void DELETE(int[] input, int inpt) {
        Scanner scan = new Scanner(System.in);
        int deleteIndex;
        boolean isDeleted = false;
        do {
            System.out.print("Array list {");
            for (int x = 0; x < inpt; x++) {
                System.out.print(" " + input[x]);
            }
            System.out.println(" }");

            System.out.print("Enter the index to delete: ");
            deleteIndex = scan.nextInt();

            if (deleteIndex >= 0 && deleteIndex < inpt) {
                input[deleteIndex] = 0;
                System.out.println("Element at index " + deleteIndex + " is deleted");
                isDeleted = true;
            } else {
                System.out.println("Invalid index to delete, please try again.");
            }
        } while (!isDeleted);
    }


    //UPDATE
    public static void UPDATE(int[] input, int inpt) {
            Scanner scan = new Scanner(System.in);
            while (true) {
                System.out.print("Array list {");
                for (int x = 0; x < inpt; x++) {
                    System.out.print(" " + input[x]);
                }
                System.out.println(" }");
        
                System.out.print("Enter the index to update: ");
                int updateIndex = scan.nextInt();
                
                if (updateIndex >= 0 && updateIndex < inpt) {
                    
                    System.out.print("Enter the number to update: ");
                    input[updateIndex] = scan.nextInt();
                    System.out.println("Element at index " + updateIndex + " is updated.");
                    break;
                } else {
                    
                    System.out.println("Invalid index to update, please try again");
                }
            }
        }
    
    

    //TRAVERSE
    public static void TRAVERSE(int[] input, int inpt) {
        System.out.println("Array list:");
        for(int x = 0; x < inpt; x++) {
            
            System.out.printf("Number on indexd contains value of %d  \n", x, input[x]);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[MAX];
        int inp, c;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter how many indices in your array : ");
        inp = scan.nextInt();

        // USER INPUT
        for (int i = 0; i < inp; i++) {
            System.out.print("Enter the index [" + i + "] number :");
            input[i] = scan.nextInt();
        }

        do {
            //DISPLAY 
            System.out.print("\nArray list {");
            for (int x = 0; x < inp; x++) {
                System.out.print(" " + input[x]);
            }
            System.out.print(" }\n");

            // UI
            System.out.println("[1] Searching Array");
            System.out.println("[2] Traverse elements on Array");
            System.out.println("[3] Delete element on Array");
            System.out.println("[4] Update an element on Array");
            System.out.println("[0] Exit");
            System.out.print("Enter your choice: ");
            c = scan.nextInt();

            switch (c) {
                case 1 -> {
                    SEARCH(input, inp);
                    promptAndWait();
                }
                
                case 2 -> {
                    TRAVERSE(input, inp);
                    promptAndWait();
                }
                
                case 3 -> {
                    DELETE(input, inp);
                    promptAndWait();
                }
                    
                case 4 -> {
                    UPDATE(input, inp);
                    promptAndWait();
                }
    
                case 0 -> {
                    System.out.println("Exiting the program...");
                    return;
                }
                
                default -> {
                    System.out.println("Please try again...");
                    promptAndWait();
                }
            }
            
        } while (true);
    }
}