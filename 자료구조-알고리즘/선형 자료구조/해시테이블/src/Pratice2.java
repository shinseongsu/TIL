
class MyHashTable2 extends MyHashTable {

    MyHashTable2(int size) {
        super(size);
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        if(this.elemCnt == this.table.length) {
            System.out.println("Hash Table is full!");
            return;
        } else if (this.table[idx] == null ) {
            this.table[idx] = data;
        } else {
            int newIdx = idx;
            while (true) {
                newIdx = (newIdx + 1) % this.table.length;
                if (this.table[newIdx] == null) {
                    break;
                }
            }
            this.table[newIdx] = data;
        }
        elemCnt++;
    }
}

public class Pratice2 {
    public static void main(String[] args) {
        MyHashTable2 ht = new MyHashTable2(5);
        ht.setValue(1, 1);
        ht.setValue(3, 3);
        ht.printHashTable();

        ht.setValue(1, 10);
        ht.printHashTable();

        ht.setValue(1, 20);
        ht.setValue(1, 30);
        ht.setValue(1, 40);
        ht.printHashTable();

    }
}
