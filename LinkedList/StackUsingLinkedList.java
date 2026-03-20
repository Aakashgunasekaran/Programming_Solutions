class StackUsingLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top;

    // Push operation
    void push(int data) {

        Node newNode = new Node(data);

        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

        System.out.println(data + " pushed into stack");
    }

    // Pop operation
    void pop() {

        if (top == null) {
            System.out.println("Stack Underflow");
            return;
        }

        System.out.println(top.data + " popped");
        top = top.next;
    }

    // Peek operation
    void peek() {

        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Top element: " + top.data);
    }

    // Display stack
    void display() {

        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        Node temp = top;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        StackUsingLinkedList s = new StackUsingLinkedList();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        s.peek();

        s.pop();

        s.display();
    }
}