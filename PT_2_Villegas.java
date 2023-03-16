import java.io.*;

public class PT_2_Villegas {

    public static void promptAndWait() throws Exception {
        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader ab = new BufferedReader(a);

        String zxc;

        System.out.print("Press any key to continue");
        zxc = ab.readLine();

    }
    //Beginning and End Node
    private Node Head;
    private Node Tail;

    private static class Node {
        double Data;
        Node Prev;
        Node Next;

        Node(double data) {
            this.Data = data;
            this.Prev = null;
            this.Next = null;
        }
    }
    
    //Print Elements
    private void Print() {
        Node current = Head;
        while (current != null) {
            System.out.print(current.Data + " ");
            current = current.Next;
        }
        System.out.println();
    }
    //Add node elements
    private void AddNo(double data) {
        Node newNode = new Node(data);
        if (Head == null) {
            Head = Tail = newNode;
        } else {
            Tail.Next = newNode;
            newNode.Prev = Tail;
            Tail = newNode;
        }
    }
    //Delete node elements
    private void DelNo(double data) {
        Node current = Head;
        while (current != null) {
            if (current.Data == data) {
                if (current.Prev != null) {
                    current.Prev.Next = current.Next;
                } else {
                    Head = current.Next;
                }
                if (current.Next != null) {
                    current.Next.Prev = current.Prev;
                } else {
                    Tail = current.Prev;
                }
                return;
            }
            current = current.Next;
        }
    }

    // Search node elements
    private boolean SeaNo(double data) {
        Node current = Head;
        while (current != null) {
            if (current.Data == data) {
                return true;
            }
            current = current.Next;
        }
        return false;
    }

    //Traverse elements forward
    private void TraverseFor() {
        Node current = Head;
        System.out.print("The doubly linked list in forward order is: ");
        while (current != null) {
            System.out.print(current.Data + " ");
            current = current.Next;
        }
        System.out.println();
    }

    // Traverse elements backwards
    private void TraverseBack() {
        Node current = Tail;
        System.out.print("The doubly linked list in reverse order is: ");
        while (current != null) {
            System.out.print(current.Data + " ");
            current = current.Prev;
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {

        InputStreamReader x = new InputStreamReader(System.in);
        BufferedReader xx = new BufferedReader(x);
        PT_2_Villegas list = new PT_2_Villegas();

        int menu_input;

        do{
            //Menu
            System.out.print("\033[H\033[2J");
            System.out.println("1. Delete");
            System.out.println("2. Insert");
            System.out.println("3. Traverse");
            System.out.println("4. Search");
            System.out.println("5. Exit");

            System.out.print("\nChoose an option: ");
            menu_input = Integer.parseInt(xx.readLine());
            //Switch case
            switch(menu_input){

                case 1:
                {
                    System.out.print("Enter the element: ");
                    double data = Double.parseDouble(xx.readLine());
                    list.DelNo(data);
                    System.out.print("Updated List: ");
                    list.Print();
                    promptAndWait();
                    break;
                }
                case 2:
                {
                    System.out.print("Enter total number of elements: ");
                    int n = Integer.parseInt(xx.readLine());

                    System.out.println("Enter the elements:");
                    for (int i = 0; i < n; i++) {
                        double data = Double.parseDouble(xx.readLine());
                        list.AddNo(data);
                    }

                    System.out.print("Updated List: ");
                    list.Print();
                    promptAndWait();
                    break;

                }
                case 3:
                {
                    System.out.println("Press [1] for Ascending Order and [2] for Descending Order: ");
                    int option = Integer.parseInt(xx.readLine());
            
                    if (option == 1) {
                        list.TraverseFor();
                    } else if (option == 2) {
                        list.TraverseBack();
                    } else {
                        System.out.println("!!Please Try Again!!");
                    }

                    promptAndWait();
                    break;
                }
                case 4:
                {
                    System.out.print("Enter what element to search: ");
                    double data = Double.parseDouble(xx.readLine());
                    boolean found = list.SeaNo(data);
            
                    if (found) {
                        System.out.println(data + " is in the link list.");
                    } else {
                        System.out.println(data + " is not in the link list.");
                    }

                    promptAndWait();
                    break;
                }

                case 5:
                {
                    System.exit(0);
                    break;
                }
    
            }
        }while(true);
    }   
} 
