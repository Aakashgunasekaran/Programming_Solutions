class QueueUsingLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front;
    Node rear;

    // Enqueue
    void enqueue(int data) {

        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;

        System.out.println(data + " inserted into queue");
    }

    // Dequeue
    void dequeue() {

        if (front == null) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(front.data + " removed");

        front = front.next;

        if (front == null)
            rear = null;
    }

    // Peek
    void peek() {

        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Front element: " + front.data);
    }

    // Display
    void display() {

        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        QueueUsingLinkedList q = new QueueUsingLinkedList();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.peek();

        q.dequeue();

        q.display();
    }
}