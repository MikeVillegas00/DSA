import java.util.*;


public class PT5 {

    //Node Element
    public static class Node {
        int data;
        Node left, right;
    
        public Node(int value) {
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }
    //Function for Pre-Order 
    public static void PreOrd(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(" [" + root.data + "] " );
        PreOrd(root.left);
        PreOrd(root.right);
    }

    //Function for Post-Order
    public static void PostOrd(Node root) {
        if (root == null) {
            return;
        }
        PostOrd(root.left);
        PostOrd(root.right);
        System.out.print(" [" + root.data + "] ");
    }

    //Function for Insert
    public static Node Insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = Insert(root.left, data);
        } else {
            root.right = Insert(root.right, data);
        }
        return root;
    }

    //Function for In-Order
    public static void InOrd(Node root) {
        if (root == null) {
            return;
        }
        InOrd(root.left);
        System.out.print(" [" + root.data + "] ");
        InOrd(root.right);
    }

    //Function for Prompt and Wait
    public static void promptAndWait() {
        System.out.println("\nPress any key to Continue..");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    //Main 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Node Size: ");
        int k = input.nextInt();

        Node elem = null;
        for (int i = 0; i < k; i++) {
            System.out.print("Enter the value of node " + "[" +  (i + 1) + "]: ");
            int val = input.nextInt();
            elem = Insert(elem, val);
        }
        
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("[1] In-order Traversal");
            System.out.println("[2] Pre-order Traversal");
            System.out.println("[3] Post-order Traversal");
            System.out.println("[0] Exit Program");
            System.out.print("Enter method of Traversal: ");
            int option = input.nextInt();
        
           //Switch Case 
            switch (option) {
                case 1:
                    System.out.println("\nIn-ordered Elements:");
                    InOrd(elem);
                    promptAndWait();
                    break;
                case 2:
                    System.out.println("\nPre-ordered Elements:");
                    PreOrd(elem);
                    promptAndWait();
                    break;
                case 3:
                    System.out.println("\nPost-ordered Elements:");
                    PostOrd(elem);
                    promptAndWait();
                    break;
                case 0:
                    System.out.println("Exiting the program"); //End Program
                    System.exit(0);
                    return;
                default:
                    System.out.println("Please try again");
                }
        }while (true);        
    }
}