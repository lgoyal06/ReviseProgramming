package com.lalit.ds.basic.linkedlist;

import java.util.HashSet;
import java.util.Set;
/**
 * TODO Start from Problem number 14 till 24
 * And then match solutions
 * Link - https://www.geeksforgeeks.org/data-structures/linked-list/
 * **/
public class LinkedListDS<T> {
    Node node;

    public void add(T element) {
        Node<T> tempNode = node;
        if (node == null) {
            Node<T> newNode = new Node<>();
            newNode.value = element;
            node = newNode;
        } else {
            while (tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
            }
            Node<T> newNode = new Node<>();
            newNode.value = element;
            tempNode.nextNode = newNode;
        }
    }

    public boolean remove(T element) {
        Node<T> tempNode = node;
        Node<T> previouNode = null;
        if (tempNode != null && tempNode.value == element) {
            node = tempNode.nextNode;
            return true;
        }
        while (tempNode != null) {
            Node<T> nextNode = tempNode.nextNode;
            if (tempNode.value == element) {
                previouNode.nextNode = nextNode;
                return true;
            }
            previouNode = tempNode;
            tempNode = tempNode.nextNode;
        }
        return false;
    }

    public boolean removeAtIndex(int index) {
        Node<T> tempNode = node;
        Node<T> previouNode = null;
        int currentIndex = 0;
        if (index == 0) {
            node = tempNode.nextNode;
            return true;
        }
        while (tempNode != null && currentIndex <= index) {
            Node<T> nextNode = tempNode.nextNode;
            if (currentIndex == index) {
                previouNode.nextNode = nextNode;
                return true;
            }
            ++currentIndex;
            previouNode = tempNode;
            tempNode = tempNode.nextNode;
        }
        throw new ArrayIndexOutOfBoundsException("Index out of bound");
    }

    // Iterative
    public int size() {
        Node<T> tempNode = node;
        int size = 0;
        while (tempNode != null) {
            ++size;
            tempNode = tempNode.nextNode;
        }
        return size;
    }

    /**TODO This solution seems too complex to understand look at solution 25, seems easy but mindful
     * https://www.geeksforgeeks.org/data-structures/linked-list/
     * **/
    public void reverse() {
        node = reverse(node, new Node<T>());
    }

    private Node<T> reverse(Node<T> node, Node<T> reverseNode) {
        Node<T> tempNode = node;
        while (tempNode != null) {
            if (tempNode.nextNode == null) {
                Node<T> newNode = new Node<>();
                newNode.value = tempNode.value;
                return newNode;
            }
            reverseNode = reverse(tempNode.nextNode, reverseNode);
            Node<T> tempRevNode = reverseNode;
            while (tempRevNode.nextNode != null) {
                tempRevNode = tempRevNode.nextNode;
            }
            Node<T> newNode = new Node<>();
            newNode.value = tempNode.value;
            tempRevNode.nextNode = newNode;
            return reverseNode;
        }
        return null;
    }

    //Detect and remove loop in linked list
    public void removeLoop() {
        Set<Node> hashCodeSets = new HashSet<>();
        Node<T> tempNode = node;
        Node<T> previouNode = null;
        while (tempNode != null) {
            if (hashCodeSets.add(tempNode)) {
                previouNode = tempNode;
                tempNode = tempNode.nextNode;
            } else {
                previouNode.nextNode = null;
                break;
            }
        }
    }

    public Node findMiddleNode() {
        Node<T> tempNode = node;
        Node<T> tempNodeDoubleJump = node;
        while (tempNode.nextNode != null && tempNodeDoubleJump.nextNode != null && tempNodeDoubleJump.nextNode.nextNode != null) {
            tempNode = tempNode.nextNode;
            tempNodeDoubleJump = tempNodeDoubleJump.nextNode.nextNode;
        }
        return tempNode;
    }

    //
    public Node getFromEndIndex(int index) {
        Node<T> main_ptr = node;
        Node<T> another_ptr = node;

        if (another_ptr != null) {
            while (index > 1) {
                another_ptr = another_ptr.nextNode;
                if (another_ptr == null) {
                    System.out.println("Null pointer");
                    return null;
                }
                --index;
            }
        }
        while (another_ptr.nextNode != null) {
            another_ptr = another_ptr.nextNode;
            main_ptr = main_ptr.nextNode;
        }
        return main_ptr;
    }

    //
    public Node getFromHeadIndex(int index) {
        return null;
    }

    class Node<T> {
        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        Node nextNode;
        T value;
    }

}
