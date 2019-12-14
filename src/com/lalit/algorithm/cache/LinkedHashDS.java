package com.lalit.algorithm.cache;


import com.sun.org.apache.regexp.internal.RE;

//TODO Complete Removal of element by element and from head
public class LinkedHashDS<K, T> {

    Node[] bucket = new Node[10];

    Node<K, T> head;
    Node<K, T> tail;

    //TODO Add element to tail
    //TODO remove element from LinkedList if it already exists
    public boolean put(K key, T value) {
        Node node = bucket[hash(key)];
        bucket[hash(key)] = addElement(key, value, node);
        return true;
    }

    public int size() {
        Node tempNode = head;
        int count = 0;
        while (tempNode != null) {
            tempNode = tempNode.after;
            ++count;
        }
        return count;
    }

    private Node<K, T> addElement(K key, T value, Node<K, T> rootNode) {
        Node newNode = new Node(key, value);
        if (rootNode == null) {
            rootNode = newNode;
            if (head == null)
                head = tail = rootNode;
            else {
                tail.after = rootNode;
                tail.after.before = tail;
                tail = tail.after;
            }
        } else {
            Node tempNode = rootNode;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
            tempNode.next.previous = tempNode;
            tail.after = newNode;
            tail.after.before = tail;
            tail = tail.after;
        }
        return rootNode;
    }

    private Node<K, T> remove(K key, Node<K, T> rootNode) {
        Node tempNode = rootNode;
        while (tempNode != null) {
            if (tempNode.key.equals(key)) {
                if (tempNode.previous != null)
                    tempNode.previous.next = tempNode.next;
                else if (tempNode.next != null)
                    tempNode.next.previous = tempNode.previous;

                if (tempNode.before != null) {
                    tempNode.before.next = tempNode.after;
                } else if (tempNode.after != null) {
                    tempNode.after.before = tempNode.before;
                }
                if ((tempNode.previous == null && tempNode.next == null) || (tempNode.before == null && tempNode.after == null)) {
                    tempNode = null;
                }
                return tempNode;
            }
            tempNode = tempNode.next;
        }
        return null;
    }

    //TODO Remove from tail in case size is exceeded called by put method
    private boolean remove() {
        return false;
    }

    //TODO Remove by element evict
    public boolean remove(K key) {
        bucket[hash(key)] = remove(key, bucket[hash(key)]);
        return true;
    }

    private int hash(K element) {
        return (element == null) ? 0 : element.hashCode() % 10;
    }

    public class Node<K, T> {
        Node<K, T> next;
        Node<K, T> previous;
        Node<K, T> after;
        Node<K, T> before;
        T value;
        K key;

        public Node(K key, T value) {
            this.value = value;
            this.key = key;
        }

    }

}
