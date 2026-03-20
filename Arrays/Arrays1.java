import java.util.Arrays;
import java.util.Scanner;

public class Arrays1 {
    private int size = 0;
    private int capacity = 10;
    private int[] arr;

    // Default constructor
    public Arrays1() {
        this.arr = new int[capacity];
        Arrays.fill(this.arr, -1);
    }

    // Constructor with array, size, capacity
    public Arrays1(int[] a, int s, int c) {
        this.size = s;
        this.capacity = c;
        this.arr = new int[capacity];
        System.arraycopy(a, 0, arr, 0, size);
    }

    // Copy constructor
    public Arrays1(Arrays1 a) {
        this.size = a.size;
        this.capacity = a.capacity;
        this.arr = new int[capacity];
        System.arraycopy(a.arr, 0, this.arr, 0, size);
    }

    // Check if array is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Resize array (dynamic memory allocation)
    private void resize() {
        capacity *= 2;
        arr = Arrays.copyOf(arr, capacity);
    }

    // Insert at first
    public void insertAtFirst(int elt) {
        if (isFull()) resize(); // auto-resize
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = elt;
        size++;
    }

    // Insert at last
    public void insertAtLast(int elt) {
        if (isFull()) resize();
        arr[size++] = elt;
    }

    // Insert at middle
    public void insertAtMiddle(int elt) {
        if (isFull()) resize();
        int m = size / 2;
        for (int i = size; i > m; i--) {
            arr[i] = arr[i - 1];
        }
        arr[m] = elt;
        size++;
    }

    // Delete at first
    public void deleteAtFirst() {
        if (isEmpty()) {
            System.out.println("Array is empty!");
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = -1;
    }

    // Delete at last
    public void deleteAtLast() {
        if (isEmpty()) {
            System.out.println("Array is empty!");
            return;
        }
        arr[--size] = -1;
    }

    // Delete at middle
    public void deleteAtMiddle() {
        if (isEmpty()) {
            System.out.println("Array is empty!");
            return;
        }
        int m = size / 2;
        for (int i = m; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = -1;
    }

    // Display array
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + arr[i]);
        }
    }

    // Sort array
    public void sort() {
        Arrays.sort(arr, 0, size);
    }

    // Merge and sort arrays
    public int[] mergeAndSortArrays(int[] array1, int[] array2) {
        int[] merged = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, merged, 0, array1.length);
        System.arraycopy(array2, 0, merged, array1.length, array2.length);
        Arrays.sort(merged);
        return merged;
    }

    // Binary search
    public int binarySearch(int[] array, int key) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == key) return mid;
            else if (array[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Main program
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Arrays1 myobj1 = new Arrays1(arr, 6, 10);
        Scanner scan = new Scanner(System.in);
        int ch;

        System.out.println("1.Display\n2.Insert First\n3.Insert Last\n4.Delete First\n5.Delete Last\n6.Insert Middle\n7.Delete Middle\n8.Merge & Binary Search\n9.Sort\n0.Exit");

        do {
            System.out.println("Enter your choice:");
            ch = scan.nextInt();
            switch (ch) {
                case 1: myobj1.display(); break;
                case 2: System.out.print("Enter element: "); myobj1.insertAtFirst(scan.nextInt()); break;
                case 3: System.out.print("Enter element: "); myobj1.insertAtLast(scan.nextInt()); break;
                case 4: myobj1.deleteAtFirst(); break;
                case 5: myobj1.deleteAtLast(); break;
                case 6: System.out.print("Enter element: "); myobj1.insertAtMiddle(scan.nextInt()); break;
                case 7: myobj1.deleteAtMiddle(); break;
                case 8:
                    int[] array1 = {1,3,5,7};
                    int[] array2 = {2,4,6,8};
                    int[] merged = myobj1.mergeAndSortArrays(array1,array2);
                    System.out.println("Merged & Sorted: "+Arrays.toString(merged));
                    int key = 5;
                    int result = myobj1.binarySearch(merged,key);
                    System.out.println(result==-1 ? "Element not found" : "Found at index "+result);
                    break;
                case 9: myobj1.sort(); myobj1.display(); break;
                case 0: break;
                default: System.out.println("Invalid choice"); break;
            }
        } while(ch != 0);

        scan.close();
    }
}