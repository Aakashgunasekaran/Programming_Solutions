class HasLinear {

    int size = 10;
    int table[];

    HasLinear() {
        table = new int[size];

        for(int i=0;i<size;i++)
            table[i] = -1;
    }

    int hash(int key) {
        return key % size;
    }

    void insert(int key) {
        int index = hash(key);

        while(table[index] != -1)
            index = (index + 1) % size;

        table[index] = key;
    }

    void display() {
        for(int i=0;i<size;i++)
            System.out.println(i + " : " + table[i]);
    }

    public static void main(String args[]) {
        HasLinear h = new HasLinear();

        h.insert(25);
        h.insert(35);
        h.insert(55);

        h.display();
    }
}
