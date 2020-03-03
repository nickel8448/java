package main.java.trials;

import java.util.Iterator;

public class ImplementIterator {
    private int size = 15;
    int []arr = new int[size];

    ImplementIterator() {
        for (int i = 0; i < size; ++i) {
            arr[i] = i;
        }
    }


    ImplementIterator(int size) {
        this.size = size;
        for (int i = 0; i < size; ++i) {
            arr[i] = i;
        }
    }


    private class EvenIterator implements Iterator<Integer> {
        private int index = 0;

        public boolean hasNext() {
            return (index < size);
        }

        public Integer next() {
            Integer retValue = arr[index];
            index += 2;
            return retValue;
        }
    }


    void printEven() {
        EvenIterator iterator = this.new EvenIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    void testAnonymousClass() {
        ImplementIterator it = new ImplementIterator(10) {
            void printText() {
                System.out.println("this is anonymouse class");
            }
        };
    }


    public static void main(String[] args) {
        ImplementIterator it = new ImplementIterator();
        it.printEven();
    }
}
