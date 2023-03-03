import java.util.Scanner;
import java.io.*;

public class OE_3 {
    private static final Scanner scr = new Scanner(System.in);
    private Node head; 

    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static void main(String[] args) {
        OE_3 list = new OE_3();

        while (true) {  //Menu
            System.out.println("Please choose an operation:");
            System.out.println("[1] Add a node in the beginning");
            System.out.println("[2] Add a node in the end");
            System.out.println("[3] add a node after the specific node chosen");
            System.out.println("[4] Print the updated list");
            System.out.println("[0] Exit program");
            System.out.print("Enter choice: ");
            int choice = scr.nextInt();
        
            switch (choice) {
                case 1:
                    System.out.print("Enter integer elements (use space if multiple inputs): ");
                    scr.nextLine();
                    String AddInitial = scr.nextLine();
                    
                    if (AddInitial.isEmpty()) {
                        System.out.println("No input provided.");
                        return;
                    }
                    
                    String[] AddInitial1 = AddInitial.split(" ");
                    for (int i = 0; i < AddInitial1.length; i++) {
                        try {
                            int data = Integer.parseInt(AddInitial1[i]);
                            list.AddNodeBegin(data);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! : [" + AddInitial1[i] + "] Try Again!.");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter integer elements (use space if multiple inputs):");
                    scr.nextLine();
                    String AddEnd = scr.nextLine();
                    
                    if (AddEnd.isEmpty()) {
                        System.out.println("Please try again.");
                        return;
                    }
                    
                    String[] AddEnd1 = AddEnd.split(" ");
                    for (int i = 0; i < AddEnd1.length; i++) {
                        try {
                            int data = Integer.parseInt(AddEnd1[i]);
                            list.AddNodeEnd(data);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! [" + AddEnd1[i] + "] Try Again!.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter 1 element to add: ");
                    int data3 = scr.nextInt();
                    System.out.print("Enter which node you want to insert: ");
                    int nodeData = scr.nextInt();
                    Node prevNode = list.searchNode(nodeData);
                    list.AddNodeSpecified(prevNode, data3);
                    break;

                case 4:
                    list.printList();
                    promptAndWait();
                    break;

                case 0:
                    System.exit(0);
                default:
                    System.out.println("!!Please Try Again!!");
            }
        }
    }
    // Add node in the beginning
    public void AddNodeBegin(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add node in the end
    public void AddNodeEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Add node after specific node
    public void AddNodeSpecified(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Previos node must not be NULL.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Manual Print of the updated linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node searchNode(int data) {
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        return current;
    }
    //Prompt and Wait
    public static void promptAndWait() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Press a key to proceed");
        scn.nextLine();
    }
}