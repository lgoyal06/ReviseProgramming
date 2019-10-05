package com.lalit.ds.basic.circularLinkedList;

import com.lalit.ds.basic.linkedlist.LinkedListDS;
import com.lalit.ds.basic.tree.TreeDS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO
 * Task 1 - Complete Problem 6,11 from https://www.geeksforgeeks.org/data-structures/linked-list/
 * <p>
 * 6. Convert a Binary Tree to a Circular Doubly Link List
 * 11. Josephus Circle using circular linked list
 * <p>
 * Circular Linked List :
 * Task2 - Compare Solutions and understand best and optimised way
 **/
public class CircularLinkedListDS<T> {
    private Node<T> head;
    private Node<T> tail;

    class IteratorCircularLinkedList<T> implements IteratorCustom<T> {
        private Node<T> node;

        public IteratorCircularLinkedList(Node<T> nodeCopy) {
            this.node = nodeCopy;
        }

        public T next() {
            T value = (T) node.value;
            this.node = node.nextNode;
            return value;
        }
    }

    private Node<T> deepCopy() {
        Node<T> temp = head;
        CircularLinkedListDS<T> copy = new CircularLinkedListDS<>();
        while (temp != null) {
            copy.add(temp.value);
            temp = temp.nextNode;
            if (temp.hashCode() == head.hashCode()) {
                break;
            }
        }
        return copy.head;
    }

    public IteratorCircularLinkedList<T> getIterator() {
        return new IteratorCircularLinkedList<T>(deepCopy());
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
    public int size() {
        Node<T> tempNode = head;
        int size = 1;
        if (tempNode == null) {
            return size;
        }
        while (tempNode.nextNode != null && tempNode.nextNode != head) {
            ++size;
            tempNode = tempNode.nextNode;
        }
        return size;
    }

    // Count Nodes
    public int size(Node<T> head) {
        Node<T> tempNode = head;
        int size = 1;
        if (tempNode == null) {
            return size;
        }
        while (tempNode.nextNode != null && tempNode.nextNode != head) {
            ++size;
            tempNode = tempNode.nextNode;
        }
        return size;
    }

    public void swapFirstAndLastNodes() {
        Node<T> tempNode = head;
        Node<T> previousNode = null;
        if (head == tail && previousNode == null) {
            return;
        } else if (head.nextNode == tail) {
            head = tail;
            tail = tempNode;
            return;
        } else {
            while (tempNode != tail) {
                previousNode = tempNode;
                tempNode = tempNode.nextNode;
            }
            previousNode.nextNode = head;
            tempNode.nextNode = head.nextNode;
            head.nextNode = tempNode;
            tail = head;
            head = tempNode;
            return;
        }
    }

    public void insertFront(T element) {
        Node<T> tempNode = head;
        Node<T> newNode = new Node<>();
        newNode.value = element;
        newNode.nextNode = tempNode;
        head = newNode;
        if (tail == null) {
            tail = head;
            head.nextNode = head;
        } else {
            tail.nextNode = head;
        }
    }

    public void insertRear(T element) {
        Node<T> tempNode = head;
        Node<T> newNode = new Node<>();
        newNode.value = element;
        newNode.nextNode = head;
        if (head == null) {
            head = tail = newNode;
            head.nextNode = head;
        } else {
            while (tempNode.nextNode != tail)
                tempNode = tempNode.nextNode;
            tempNode.nextNode.nextNode = newNode;
            tail = newNode;
        }
    }

    public boolean deleteFront() {
        if (head == null) {
            throw new RuntimeException("Nothing to delete");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.nextNode;
            tail.nextNode = head;
        }
        return true;
    }

    public boolean deleteRear() {
        Node<T> tempNode = head;
        if (head == null) {
            throw new RuntimeException("Nothing to delete");
        } else if (head == tail) {
            head = tail = null;
        } else {
            while (tempNode.nextNode != tail)
                tempNode = tempNode.nextNode;
            tempNode.nextNode = head;
            tail = tempNode;
        }
        return true;
    }

    public void enQueue(T element) {
        insertRear(element);
    }

    public boolean deQueue() {
        return deleteFront();
    }

    /**
     * TODO  11
     **/

    public int josephusCircleLastRemainder(int lenOfCircle, int countToChoseNext) {
        for (Integer i = 0; i < lenOfCircle; ++i) {
            add((T) i);
        }
        Node<T> tempNode = deepCopy();
        Node<T> preNode = null;
        while (size(tempNode) > 1) {
            int skipCounter = 0;
            while (skipCounter < countToChoseNext) {
                preNode = tempNode;
                tempNode = tempNode.nextNode;
                ++skipCounter;
            }
            preNode.nextNode = tempNode.nextNode;
            tempNode = tempNode.nextNode;
        }
        System.out.println(tempNode);
        return 0;
    }

    //TODO 6
    public CircularLinkedListDS<T> treeToCircularLL(TreeDS tree) {
        return null;
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
