class CircularQueue {

    int size;
    int front;
    int rear;
    int arr[];

    CircularQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        return (rear + 1) % size == front;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enqueue(int data) {

        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1)
            front = 0;

        rear = (rear + 1) % size;
        arr[rear] = data;

        System.out.println(data + " inserted");
    }

    void dequeue() {

        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(arr[front] + " removed");

        if (front == rear) {
            front = rear = -1;
        }
        else {
            front = (front + 1) % size;
        }
    }

    void peek() {

        if (isEmpty()) {
            System.out.println("Queue empty");
            return;
        }

        System.out.println("Front element: " + arr[front]);
    }

    void display() {

        if (isEmpty()) {
            System.out.println("Queue empty");
            return;
        }

        int i = front;

        while (true) {

            System.out.print(arr[i] + " ");

            if (i == rear)
                break;

            i = (i + 1) % size;
        }

        System.out.println();
    }

    public static void main(String args[]) {

        CircularQueue q = new CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.dequeue();

        q.display();

        q.enqueue(40);
        q.enqueue(50);

        q.display();
    }
}
