import java.util.Scanner;
public class QueueA {
    int arr[];
    int front;
    int rear;
    int size;
    int capacity;

    public QueueA(int capacity)
    {
        this.capacity = capacity;
        arr = new int[capacity];
        front =-1;
        rear =-1;
        size=0;

    }
    boolean isFull()
    {
        return size == capacity;
    }
    boolean isEmpty()
    {
        return size == 0;
    }
    void enqueue(int elt)
    {
        if(isFull())
        {
            System.out.println("Queue is  full!!");
            return ;
        }
        if(front == -1)
        {
            front = 0;
        }
        rear++;
        arr[rear] = elt;
        size++;
        System.out.println(elt+" inserted");
    }
    void dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue Empty");
            return;
        }
        System.out.println(arr[front]+" removed");
        front ++;
        rear --;
        if(size==0)
        {
            front =-1;
            rear=-1;
        }
    }
     void peek()
     {
         if(isEmpty())
         {
             System.out.println("Queue Empty!!");
         }
         System.out.println("Front elements :"+arr[front]);
     }
     void display()
     {
         if(isEmpty())
         {
             System.out.println("Queue Empty");
             return;
         }
         System.out.println("Queue elements:");
         for(int i=front;i<=rear;i++)
         {
             System.out.print(arr[i]+"\t");
         }

     }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter queue capacity: ");
            int capacity = sc.nextInt();

            QueueA q = new QueueA(capacity);

            int choice;

            do {

                System.out.println("\n1. Enqueue");
                System.out.println("2. Dequeue");
                System.out.println("3. Peek");
                System.out.println("4. Display");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter element: ");
                        int x = sc.nextInt();
                        q.enqueue(x);
                        break;

                    case 2:
                        q.dequeue();
                        break;

                    case 3:
                        q.peek();
                        break;

                    case 4:
                        q.display();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } while (choice != 5);

            sc.close();
        }
    }