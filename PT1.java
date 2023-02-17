import java.io.*;

public class PT1 {

    public static void main (String[] args) throws Exception {

        InputStreamReader inp1 = new InputStreamReader(System.in);
        BufferedReader inp2 = new BufferedReader(inp1);

       

        //Menu

        do{

            int user_input;

            System.out.print("\033[H\033[2J");

            System.out.println("1. [Stack]");
            System.out.println("2. [Queue]");
            System.out.println("3. [Exit Program]");

            System.out.print("\n[Select an Option]: ");
            user_input = Integer.parseInt(inp2.readLine());

            switch(user_input){

                case 1:
                
                {
                    //User Input

                    int nums [] = new int [5];

                    System.out.println("Enter 5 elements: ");
                    for (int i = 0; i < nums.length; i++) {
                        nums[i] = Integer.parseInt(inp2.readLine());
                    }

                    Stack Stack = new Stack();
                    System.out.println("Initial Stack is Empty : " + Stack.isEmpty());

                    Stack.push(nums[0]);
                    Stack.push(nums[1]);
                    Stack.push(nums[2]);
                    Stack.push(nums[3]);
                    Stack.push(nums[4]);
                    System.out.println("After Pushing...");

                    //Print output
                    System.out.println("Element at the top of the stack " + "[" + Stack.peek() + "]");
                    Stack.display();
                    promptAndWait();

                    Stack.pop();
                    Stack.pop();
                    System.out.println("\nAfter Popping...");
                    
                    Stack.display();
                    promptAndWait();
                    break;
                }

                case 2:
                {
                    //User Input

                    int nums [] = new int [4];

                    System.out.println("Enter 4 elements: ");
                    for (int i = 0; i < nums.length; i++) {
                        // reading array elements from the user
                        nums[i] = Integer.parseInt(inp2.readLine());
                    }

                    // Create a queue of capacity 4 
                    Queue que = new Queue(4); 
            
                    System.out.println("Initial Queue:");
                     // print Queue elements 
                    que.QueueDisplay(); 
                    que.Queue_Enqueue(nums[0]); 
                    que.Queue_Enqueue(nums[1]); 
                    que.Queue_Enqueue(nums[2]); 
                    que.Queue_Enqueue(nums[3]); 
            
                    // Print Queue 
                    System.out.println("After Enqueue:");
                    que.QueueDisplay(); 
                    que.QueueFront(); 
                    
                
                    que.Queue_Enqueue(90); 
                    que.QueueDisplay(); 
                    que.Queue_Dequeue(); 
                    que.Queue_Dequeue(); 
                    System.out.printf("\nQueue after two dequeue operations:"); 
                    que.QueueDisplay(); 
                    que.QueueFront(); 
                    promptAndWait();
                    break;
                }

                case 3:
                {
                    System.exit(0);
                    break;
                }
            }
        }while(true);
    }

   
    //Void and class functions
    public static class Stack {  
    int Top;            
    int MAX = 5;      
    int[] stack_array = new int[MAX]; 
    
        Stack()
        {            
            Top = -1;  
        }    

        boolean isEmpty()
        {          
            return (Top < 0);  
        }  

        boolean push (int val)
        {      
                if(Top == MAX-1) 
                {  
                    System.out.println("Stack Overflow");  
                    return false;  
                }  
                else 
                 {  
                    Top++;  
                    stack_array[Top]=val;  
                    return true;  
                }  
            }  

        boolean pop () 
        {            
            if (Top == -1) 
            {  
                System.out.println("Stack Underflow");  
                return false;  
            }  
            else   
            {  
                
                System.out.println("\nItem/s popped: " + stack_array[Top--]);  
                return true;  
            }  
        }  

        int peek()
        {
            return stack_array[Top];
        }

        void display () 
        {           
            System.out.println("Printing stacked elements...");  
            for(int i = Top; i>=0;i--) 
            {  
                System.out.print(stack_array[i] + " ");  
            }  
         }  

    } 

    public static void promptAndWait() throws Exception {

        InputStreamReader x = new InputStreamReader(System.in);
        BufferedReader z = new BufferedReader(x);

        String C;

        System.out.print("\nPress any Key to proceed");
        C = z.readLine();
    }

    public static class Queue { 
        private static int front, back, capacity; 
        private static int queue[]; 
       
        Queue(int size) { 
            front = back = 0; 
            capacity = size; 
            queue = new int[capacity]; 
        } 
       
        static void Queue_Enqueue(int item)  { 
            if (capacity == back) { 
                System.out.printf("\nQueue is full\n"); 
                return; 
            } 
       
            
            else { 
                queue[back] = item; 
                back++; 
            } 
            return; 
        } 
       
        
        static void Queue_Dequeue()  { 
            
            if (front == back) { 
                System.out.printf("\nQueue is empty\n"); 
                return; 
            } 
       
            
            else { 
                for (int i = 0; i < back - 1; i++) { 
                    queue[i] = queue[i + 1]; 
                } 
       
           
          
                if (back < capacity) 
                    queue[back] = 0; 
       
                
                back--; 
            } 
            return; 
        } 
       
        
        static void QueueDisplay() 
        { 
            int i; 
            if (front == back) { 
                System.out.printf("Queue is Empty\n"); 
                return; 
            } 
       
            
            for (i = front; i < back; i++) { 
                System.out.printf(" %d = ", queue[i]); 
            } 
            return; 
        } 
       
        static void QueueFront() 
        { 
            if (front == back) { 
                System.out.printf("Queue is Empty\n"); 
                return; 
            } 
            System.out.printf("\nFront Element of the queue: %d", queue[front]); 
            return; 
        } 
    } 
}
