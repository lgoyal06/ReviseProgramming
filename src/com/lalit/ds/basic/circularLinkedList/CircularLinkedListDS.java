package com.lalit.ds.basic.circularLinkedList;

import com.lalit.ds.basic.linkedlist.LinkedListDS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO
 * Task 1 - Complete Problem 6,9,11,15,16 from https://www.geeksforgeeks.org/data-structures/linked-list/
 *
 * 6. Convert a Binary Tree to a Circular Doubly Link List
 * 9. Circular Queue | Set 2 (Circular Linked List Implementation)
 * 11. Josephus Circle using circular linked list
 * 15. Implementation of Deque using circular array
 * 16. Exchange first and last nodes in Circular Linked List
 *
 * Circular Linked List :
 * Task2 - Compare Solutions and understand best and optimised way
 **/
public class CircularLinkedListDS<T> {
    private Node<T> head;
    private Node<T> tail;

    class IteratorCircularLinkedList<T> implements IteratorCustom<T> {
        private Node<T> node;

        public IteratorCircularLinkedList() {
            this.node = deepCopy((Node<T>) CircularLinkedListDS.this.head);
        }

        public Node<T> deepCopy(Node<T> node) {
            Node<T> temp = node;
            CircularLinkedListDS<T> copy = new CircularLinkedListDS<>();
            while (temp != null) {
                copy.add(temp.value);
                temp = temp.nextNode;
                if (temp.hashCode() == node.hashCode()) {
                    break;
                }
            }
            return copy.head;
        }

        public T next() {
            T value = (T) node.value;
            this.node = node.nextNode;
            return value;
        }
    }

    public IteratorCircularLinkedList<T> getIterator() {
        return new IteratorCircularLinkedList<T>();
    }

    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        Node<T> temp = head;
        while (temp != null) {
            list.add((Integer) temp.value);
            temp = temp.nextNode;
            if (temp.hashCode() == head.hashCode()) {
                break;
            }
        }
        return list;
    }

    public void add(T element) {
        Node<T> tempNode = head;
        if (head == null) {
            Node<T> newNode = new Node<>();
            newNode.value = element;
            tail = head = newNode;
            head.nextNode = head;
        } else {
            while (tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
                if (tempNode.nextNode.hashCode() == head.hashCode()) {
                    break;
                }
            }
            Node<T> newNode = new Node<>();
            newNode.value = element;
            tempNode.nextNode = newNode;
            newNode.nextNode = head;
            tail = newNode;
        }
    }

    public List<CircularLinkedListDS<T>> splitIntoHalf() {
        Node<T> nodePointer1 = head;
        Node<T> nodePointer2 = head.nextNode.nextNode;
        List<CircularLinkedListDS<T>> list = new ArrayList<>();
        CircularLinkedListDS<T> firstHalf = new CircularLinkedListDS<>();
        CircularLinkedListDS<T> secondHalf = new CircularLinkedListDS<>();
        firstHalf.add(nodePointer1.value);
        while (nodePointer2.hashCode() != head.hashCode() && nodePointer2.nextNode.hashCode() != head.hashCode()) {
            nodePointer2 = nodePointer2.nextNode.nextNode;
            nodePointer1 = nodePointer1.nextNode;
            firstHalf.add(nodePointer1.value);
        }
        while (nodePointer1.nextNode != null && nodePointer1.nextNode.hashCode() != head.hashCode()) {
            secondHalf.add(nodePointer1.nextNode.value);
            nodePointer1 = nodePointer1.nextNode;
        }
        list.add(firstHalf);
        list.add(secondHalf);
        return list;

    }

    //Sorted insert for circular linked list
    public boolean sortedInsert(T element) {
        Node<T> tempNode = head;
        Node<T> previousNode = null;
        //First element to add
        if (head == null) {
            Node<T> newNode = new Node<>();
            newNode.value = element;
            tail = head = newNode;
            head.nextNode = head;
            return true;
        } else {
            while (tempNode.nextNode != null) {
                Integer intVal = (Integer) element;
                if ((Integer) tempNode.value > intVal) {
                    Node<T> newNode = new Node<>();
                    newNode.value = element;
                    newNode.nextNode = tempNode;
                    //Add at starting point
                    if (previousNode == null) {
                        head = newNode;
                        tail.nextNode = head;
                    }
                    //Add at middle point
                    else {
                        previousNode.nextNode = newNode;
                    }
                    return true;
                }
                if (tempNode.nextNode.hashCode() == head.hashCode()) {
                    break;
                }
                previousNode = tempNode;
                tempNode = tempNode.nextNode;

            }
            //Add at the end
            Node<T> newNode = new Node<>();
            newNode.value = element;
            tempNode.nextNode = newNode;
            newNode.nextNode = head;
            tail = newNode;
            return true;
        }
    }

    public boolean remove(T element) {
        Node<T> tempNode = head;
        Node<T> previouNode = null;
        while (tempNode != null) {
            Node<T> nextNode = tempNode.nextNode;
            if (tempNode.value == element) {
                if (nextNode == head) {
                    if (previouNode != null) {
                        previouNode.nextNode = tempNode.nextNode;
                        tail = previouNode;
                    } else {
                        head = tail = null;
                    }
                } else if (previouNode != null) {
                    previouNode.nextNode = nextNode;
                } else {
                    head = head.nextNode;
                    tail.nextNode = head;
                }
                return true;
            }
            previouNode = tempNode;
            tempNode = tempNode.nextNode;
            if (tempNode == head)
                return false;
        }
        return false;
    }

    // Count Nodes
    private int size() {
        Node<T> tempNode = head;
        int size = 0;
        if(tempNode == null){
            return size;
        }
        while (tempNode.nextNode != null && tempNode.nextNode == head) {
            ++size;
            tempNode = tempNode.nextNode;
        }
        return size;
    }

    private static class Node<T> {
        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        Node<T> nextNode;
        T value;
    }

}
