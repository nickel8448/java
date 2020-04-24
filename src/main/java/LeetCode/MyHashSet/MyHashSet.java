package main.java.leetcode.MyHashSet;

public class MyHashSet {

    /**
     * Node class to hold the data and the hashcode
     */
    private class Node {
        int data;
        int hashCode;
        Node next;

        Node(int data, int hashCode) {
            this.data = data;
            this.hashCode = hashCode;
            next = null;
        }
    }

    // Private variables for the class
    private int capacity = 1 << 4; // 16
    private Node[] buckets;    
    private int size;

    /**
     * Constructor
     */
    public MyHashSet() {
        this.buckets = new Node[capacity];        
        size = 0;
    }
    
    /**
     * Adds a new key to the HashSet
     * @param key
     */
    public void add(int key) {
        if(!contains(key)) {
            int keyHash = hash(key);
            int bucket = keyHash % capacity;
            Node node = getNode(key);
            if(node == null) {
                buckets[bucket] = new Node(key, keyHash);
            } else {
                Node prev = null;
                while(node != null) {
                    prev = node;
                    node = node.next;
                }
                prev.next = new Node(key, keyHash);
            }
            size++;
        }
    }
    
    /**
     * Removes the key from the hashSet
     * @param key key to be remove from the set
     */
    public void remove(int key) {
        if(contains(key)) {
            int keyHash = hash(key);
            int keyBucket = keyHash % capacity;
            Node node = getNode(key);
            if(node.next == null) {
                buckets[keyBucket] = null;
            } else {
                Node prev = null;
                while(node.data != key && node.hashCode != keyHash) {
                    prev = node;
                    node = node.next;
                }
                prev.next = node.next;
            }
        } else {
            return;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int keyHash = hash(key);
        Node node = getNode(key);
        while(node != null) {
            if(node.data == key && node.hashCode == keyHash) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private int hash(int key) {
        int k = key;
        return Integer.hashCode(k);
    }

    private Node getNode(int key) {
        int keyHash = hash(key);
        int keyBucket = keyHash % capacity;
        return buckets[keyBucket];
    }

    // private static void resizeSet()

    private void newSize() {
        this.capacity <<= 1;
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(5);
        set.add(10);
        set.add(2);
        set.add(3);
        set.add(100);
        set.add(4);
        System.out.println(set.contains(4));
        set.remove(4);
        System.out.println(set.contains(4));
    }
}
