class DoubleHashing {

    int size = 10;
    int table[];

    DoubleHashing() {

        table = new int[size];

        for(int i=0;i<size;i++)
            table[i] = -1;
    }

    int hash1(int key) {

        return key % size;
    }

    int hash2(int key) {

        return 7 - (key % 7);
    }

    void insert(int key) {

        int index = hash1(key);

        if(table[index] == -1) {

            table[index] = key;
            return;
        }

        int i = 1;

        while(true) {

            int newIndex = (hash1(key) + i * hash2(key)) % size;

            if(table[newIndex] == -1) {

                table[newIndex] = key;
                return;
            }

            i++;
        }
    }

    void display() {

        for(int i=0;i<size;i++)
            System.out.println(i + " : " + table[i]);
    }

    public static void main(String args[]) {

        DoubleHashing h = new DoubleHashing();

        h.insert(25);
        h.insert(35);
        h.insert(45);
        h.insert(55);

        h.display();
    }
}