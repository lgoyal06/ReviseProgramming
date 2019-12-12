public class LinkedHashDS<K, T> {

    Node[] bucket = new Node[10];

    Node<K, T> head;
    Node<K, T> tail;

    public boolean put(K key, T value) {
        Node node = bucket[hash(key)];
        bucket[hash(key)] = addElement(key, value, node);
        return true;
    }

    public int size() {
        Node tempNode = head;
        int count = 0;
        while (tempNode != null) {
            tempNode = tempNode.next;
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

    private boolean remove(K key, Node<K, T> rootNode) {
        Node tempNode = rootNode;
        while (tempNode != null) {
            if (tempNode.key.equals(key)) {
                if (tempNode.previous != null)
                    tempNode.previous.next = tempNode.next;
                if (tempNode.next != null)
                    tempNode.next.previous = tempNode.previous;
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    public boolean remove(K key) {
        Node node = bucket[hash(key)];
        remove(key, node);
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
