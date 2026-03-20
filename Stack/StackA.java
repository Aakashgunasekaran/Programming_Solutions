public class StackA {
    int arr[];
    int top;
    int capacity;
    StackA(int size)
    {
        capacity = size;
        arr = new  int[size];
        top =-1;
    }
    void push(int x)
    {
        if(top == capacity-1)
        {
            System.out.println("Stack overflow!!");
            return;
        }
        arr[++top] = x;
        System.out.println(x+ " pushed into stack");
    }
    int pop()
    {
        if(top == -1)
        {
            System.out.println("stack underflow!!");
            return -1;
        }
        return arr[top--];
    }
    int peek()
    {
        if(top==-1)
        {
            System.out.println("Stack is Empty!!");
            return -1;
        }
        return arr[top];
    }
    boolean isEmpty()
    {
        return top==-1;
    }
    void display()
    {
        for(int i=top;i>=0;i--)
        {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {

        StackA s = new StackA(5);

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Top element: " + s.peek());

        System.out.println("Popped: " + s.pop());

        s.display();
    }

}
