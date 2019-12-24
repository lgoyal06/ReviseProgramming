package com.lalit.algorithm.cache;

public class LinkedHashDS<K, T> {

    Node<K, T>[] bucket = new Node[10];

    Node<K, T> head;
    Node<K, T> tail;

    public LinkedHashDS(int limit) {
        this.limit = limit;
    }

    int limit;

    public boolean put(K key, T value) {
        Node node = bucket[hash(key)];
        Node existingNode = search(node, key);
        //If element already exists
        if (existingNode != null) {
            existingNode.value = value;
            if (!head.key.equals(existingNode.key)) {
                existingNode.before.after = existingNode.after;
                existingNode.after.before = existingNode.before;
                existingNode.before = null;
                existingNode.after = head;
                head.before = existingNode;
                head = existingNode;
            }

        } else {
            //Add new element
            bucket[hash(key)] = addElement(key, value, node);
        }
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
                // Node tempHead = head;
                head.before = rootNode;
                rootNode.after = head;
                head = rootNode;
            }
        } else {
            if (size() < limit) {
                Node tempNode = rootNode;
                while (tempNode.next != null) {
                    tempNode = tempNode.next;
                }
                tempNode.next = newNode;
                tempNode.next.previous = tempNode;
                head.before = newNode;
                newNode.after = head;
                head = newNode;
            } else {
                //eviction from tail
            }
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

    private Node<K, T> search(Node node, K key) {
        Node tempNode = node;
        while (tempNode != null) {
            if (tempNode.key.equals(key)) {
                return tempNode;
            }
            tempNode = tempNode.next;
        }
        return null;
    }

    //Search for an element and if found move it to Head
    public T search(K key) {
        Node<K, T> node = bucket[hash(key)];
        Node<K, T> nodeToSearch = search(node, key);
        if (nodeToSearch != null) {
            if (!head.key.equals(nodeToSearch.key)) {
                nodeToSearch.before.after = nodeToSearch.after;
                nodeToSearch.after.before = nodeToSearch.before;
                nodeToSearch.before = null;
                nodeToSearch.after = head;
                head.before = nodeToSearch;
                head = nodeToSearch;
            }
        }
        return nodeToSearch != null ? nodeToSearch.value : null;
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
