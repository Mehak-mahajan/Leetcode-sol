// 
import java.util.*;

class LFUCache {

    // =========================
    // Node
    // =========================
    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    // =========================
    // Doubly Linked List
    // =========================
    class DoublyLinkedList {

        Node head;
        Node tail;

        DoublyLinkedList() {

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        // Add node at FRONT → MRU
        void addNode(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        // Remove a particular node
        void removeNode(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Remove LRU node
        Node removeLast() {

            if (head.next == tail) {
                return null;
            }

            Node node = tail.prev;

            removeNode(node);

            return node;
        }
    }

    // =========================
    // Variables
    // =========================

    int capacity;
    int minFreq;

    HashMap<Integer, Node> keyMap;
    HashMap<Integer, DoublyLinkedList> freqMap;


    // =========================
    // Constructor
    // =========================

    public LFUCache(int capacity) {

        this.capacity = capacity;

        minFreq = 0;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }


    // =========================
    // GET
    // =========================

    public int get(int key) {

        // Key doesn't exist
        if (!keyMap.containsKey(key)) {
            return -1;
        }

        // Find node
        Node node = keyMap.get(key);

        // Increase frequency
        increaseFrequency(node);

        return node.value;
    }


    // =========================
    // PUT
    // =========================

//   New key
//    ↓
// Cache full?
//    ↓ YES
// Evict LFU + LRU
//    ↓
// Create new node
//    ↓
// Add to freq 1
//    ↓
// minFreq = 1


public void put(int key, int value) {

    // Capacity is 0
    if (capacity == 0) {
        return;
    }

    // Key already exists
    if (keyMap.containsKey(key)) {

        Node node = keyMap.get(key);

        // Update value
        node.value = value;

        // Increase frequency
        increaseFrequency(node);

        return;
    }

    // =========================
    // New key
    // =========================

    // If cache is full, evict first
    if (keyMap.size() == capacity) {

        DoublyLinkedList list = freqMap.get(minFreq);

        // Remove LRU from minimum frequency
        Node lru = list.removeLast();

        // Remove from keyMap
        keyMap.remove(lru.key);
    }

    // Create new node
    Node node = new Node(key, value);

    // Add to keyMap
    keyMap.put(key, node);

    // Frequency 1 list doesn't exist
    if (!freqMap.containsKey(1)) {
        freqMap.put(1, new DoublyLinkedList());
    }

    // Add new node at FRONT
    // of frequency 1 list
    freqMap.get(1).addNode(node);

    // New minimum frequency is 1
    minFreq = 1;
}


    // =========================
    // INCREASE FREQUENCY
    // =========================

    private void increaseFrequency(Node node) {

        // Store old frequency
        int oldFreq = node.freq;

        // Get old frequency list
        DoublyLinkedList oldList = freqMap.get(oldFreq);

        // Remove node from old list
        oldList.removeNode(node);


        // If old frequency was minimum
        // and its list became empty
        if (oldFreq == minFreq &&
            oldList.head.next == oldList.tail) {

            minFreq++;
        }


        // Increase frequency
        node.freq++;


        // Create new frequency list
        // if it doesn't exist
        if (!freqMap.containsKey(node.freq)) {

            freqMap.put(
                node.freq,
                new DoublyLinkedList()
            );
        }


        // Add node at FRONT
        // of new frequency list
        freqMap.get(node.freq).addNode(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */