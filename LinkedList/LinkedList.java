public class LinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Constructor
    public LinkedList() {
        head = null;
    }

    // ================= INSERT OPERATIONS =================

    // Insert at beginning
    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {
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

    // Insert at position
    public void insertAtPosition(int data, int position) {

        if (position == 0) {
            insertAtFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Insert at middle using Floyd algorithm
    public void insertAtMiddle(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = newNode;
        newNode.next = slow;
    }

    // ================= DELETE OPERATIONS =================

    // Delete first
    public void deleteAtFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;
    }

    // Delete last
    public void deleteAtEnd() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }

    // Delete at position
    public void deleteAtPosition(int position) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (position == 0) {
            deleteAtFirst();
            return;
        }

        Node current = head;

        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Position out of bounds");
            return;
        }

        current.next = current.next.next;
    }

    // Delete middle using Floyd algorithm
    public void deleteAtMiddle() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
    }

    // Delete by value
    public void deleteByValue(int data) {

        if (head == null) {
            System.out.println("List empty");
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }

        System.out.println("Element not found");
    }

    // ================= UTILITY METHODS =================

    // Display list
    public void display() {

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Search element
    public boolean search(int data) {

        Node current = head;

        while (current != null) {

            if (current.data == data)
                return true;

            current = current.next;
        }

        return false;
    }

    // Size of list
    public int size() {

        int count = 0;

        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // Reverse linked list
    public void reverse() {

        Node prev = null;
        Node current = head;

        while (current != null) {

            Node next = current.next;

            current.next = prev;

            prev = current;

            current = next;
        }

        head = prev;
    }

    // Clear list
    public void clear() {
        head = null;
    }

    // Check empty
    public boolean isEmpty() {
        return head == null;
    }

    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        System.out.println("=== INSERT OPERATIONS ===");

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.insertAtFirst(5);

        list.display();

        list.insertAtPosition(15, 2);
        list.display();

        list.insertAtMiddle(100);
        list.display();

        System.out.println("\n=== DELETE OPERATIONS ===");

        list.deleteAtFirst();
        list.display();

        list.deleteAtEnd();
        list.display();

        list.deleteAtMiddle();
        list.display();

        list.deleteByValue(15);
        list.display();

        System.out.println("\n=== OTHER OPERATIONS ===");

        System.out.println("Size: " + list.size());

        System.out.println("Search 20: " + list.search(20));
        System.out.println("Search 999: " + list.search(999));

        list.reverse();
        System.out.print("After reverse: ");
        list.display();

        list.clear();
        System.out.println("After clear:");
        list.display();

        System.out.println("Is Empty: " + list.isEmpty());
    }
}
