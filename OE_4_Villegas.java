import java.util.Scanner;
import java.io.*;

public class OE_4_Villegas {

    //Function Directory
    public static int Fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return Fibo(n-1) + Fibo(n-2);
    }

    //Factor Function
    public static int Factor(int num) {
        if (num == 0) {
            return 1;
        }
        return num * Factor(num-1);
    }

    //Reverse String Function
        public static String RevString(String word) {
            if (word.length() == 0) {
                return "";
            }
            return word.charAt(word.length()-1) + RevString(word.substring(0, word.length()-1));
        }
    //Reverse Number Function
    public static int RevNum(int x, int rev) {
        if (x == 0) {
            return rev;
        }
        return RevNum(x / 10, rev * 10 + x % 10);
    }
    
    //Tower of Hanoi Function
    public static void ToH(int disks, char source, char destination, char auxiliary) {
        if (disks == 1) {
            System.out.println(source + " -> " + destination);
            return;
        }
        ToH(disks-1, source, auxiliary, destination);
        System.out.println(source + " -> " + destination);
        ToH(disks-1, auxiliary, destination, source);
    }
    //Prompt Function
    public static void promptAndWait() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press a key to proceed");
        sc.nextLine();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int UserInput;

        do {
            //Main Menu
            System.out.println("APPLICATION OF RECURSION");
            System.out.println("Please choose a following Recursion operation:");
            System.out.println("[1] Fibonacci series number");
            System.out.println("[2] Factorial of a number");
            System.out.println("[3] Reverse a number");
            System.out.println("[4] Reverse a word");
            System.out.println("[5] Tower of Hanoi");
            System.out.println("[0] Exit the program");
            System.out.print("Select your choice: ");
            UserInput = sc.nextInt();

            //Switch Case
            switch (UserInput) {
                case 1:
                    System.out.print("Enter how many elements in the Fibonacci series: ");
                    int n = sc.nextInt();
                    System.out.print("Fibonacci series: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(Fibo(i) + " ");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter an Integer (Positive Only):");
                    int XX = sc.nextInt();
                    System.out.println("The Factorial of " + XX + " = " + Factor(XX));
                    break;
                case 3:
                    System.out.print("Enter an Integer (Positive Only):");
                    int ZZ = sc.nextInt();
                    System.out.println("Reverse of " + ZZ + " = " + RevNum(ZZ, 0));
                    break;
                case 4:
                    System.out.print("Enter a String:");
                    String Word = sc.next();
                    System.out.println("Reverse of " + Word + " = " + RevString(Word));
                    break;
                case 5:
                    System.out.print("Enter the number of disks:");
                    int Disk = sc.nextInt();
                    System.out.println("Moves needed to solve Tower of Hanoi:");
                    ToH(Disk, 'A', 'C', 'B');
                    break;
                case 0:
                    System.out.println("Exiting the program..");
                    break;
                default:
                    System.out.println("!!Please try again!!");
                    promptAndWait();
            }
        } while (UserInput != 0);
        sc.close();
    }
}