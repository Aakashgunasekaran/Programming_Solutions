class QuadraticHashing {

    int size = 10;
    int table[];

    QuadraticHashing() {
        table = new int[size];

        for(int i=0;i<size;i++)
            table[i] = -1;
    }

    int hash(int key) {
        return key % size;
    }

    void insert(int key) {

        int index = hash(key);
        int i = 1;

        while(table[index] != -1) {

            index = (hash(key) + i*i) % size;
            i++;
        }

        table[index] = key;
    }

    void display() {

        for(int i=0;i<size;i++) {
            System.out.println(i + " : " + table[i]);
        }
    }

    public static void main(String args[]) {

        QuadraticHashing h = new QuadraticHashing();

        h.insert(25);
        h.insert(35);
        h.insert(45);
        h.insert(55);

        h.display();
    }
}