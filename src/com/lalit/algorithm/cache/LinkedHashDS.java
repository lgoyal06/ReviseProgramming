package com.lalit.algorithm.cache;

public class LinkedHashDS<K, T> {

    Node<K, T>[] bucket = new Node[10];

    Node<K, T> head;
    Node<K, T> tail;
    int limit;

    public LinkedHashDS(int limit) {
        this.limit = limit;
    }

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
        System.out.println(count);
        return count;
    }

    public void printElement() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.println("Key:" + tempNode.key + " " + "Value:" + tempNode.value);
            tempNode = tempNode.after;
        }
    }

    private Node<K, T> addElement(K key, T value, Node<K, T> rootNode) {
        if (size() == limit) {
            bucket[hash(tail.key)] = remove(tail.key, bucket[hash(tail.key)]);
            addElement(key, value, rootNode);
        } else {
            Node newNode = new Node(key, value);
            if (rootNode == null) {
                rootNode = newNode;
                if (head == null)
                    head = tail = rootNode;
                else {
                    head.before = rootNode;
                    rootNode.after = head;
                    head = rootNode;
                }
            } else {
                Node tempNode = rootNode;
                while (tempNode.next != null) {
                    tempNode = tempNode.next;
                }
                tempNode.next = newNode;
                tempNode.next.previous = tempNode;
                head.before = newNode;
                newNode.after = head;
                head = newNode;
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

                if (tempNode.next != null)
                    tempNode.next.previous = tempNode.previous;

                if (tempNode.after != null) {
                    tempNode.after.before = tempNode.before;
                } else {
                    tail = tail.before;
                }
                if (tempNode.before != null) {
                    tempNode.before.after = tempNode.after;
                } else {
                    head = head.after;
                }

                if ((tempNode.previous == null && tempNode.next == null)) {
                    tempNode = null;
                } else if (tempNode.previous == null) {
                    tempNode = tempNode.next;
                } else if (tempNode.next == null) {
                    tempNode = tempNode.previous;
                }
                return tempNode;
            }
            tempNode = tempNode.next;
        }
        return null;
    }

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
