package com.lalit.ds.basic.circularLinkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO
 *  Task 1 - Complete Problem 4,6,9,11,12,15,16
 *  Task2 - Compare Solutions and understand best and optimised way
 *
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

    //TODO
    //Sorted insert for circular linked list
    public void sortedInsert(T element) {
        Node<T> tempNode = head;
        while(tempNode!=null) {
          //  if(tempNode.value>(Integer) element)){

            //}
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

    private boolean removeAtIndex(int index) {
        Node<T> tempNode = head;
        Node<T> previouNode = null;
        int currentIndex = 0;
        if (index == 0) {
            head = tempNode.nextNode;
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
    private int size() {
        Node<T> tempNode = head;
        int size = 0;
        while (tempNode != null) {
            ++size;
            tempNode = tempNode.nextNode;
        }
        return size;
    }

    /**
     * TODO This solution seems too complex to understand look at solution 25, seems easy but mindful
     * https://www.geeksforgeeks.org/data-structures/linked-list/
     **/
    private void reverse() {
        head = reverse(head, new Node<T>());
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
    private void removeLoop() {
        Set<Node> hashCodeSets = new HashSet<>();
        Node<T> tempNode = head;
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

    private Node findMiddleNode() {
        Node<T> tempNode = head;
        Node<T> tempNodeDoubleJump = head;
        while (tempNode.nextNode != null && tempNodeDoubleJump.nextNode != null && tempNodeDoubleJump.nextNode.nextNode != null) {
            tempNode = tempNode.nextNode;
            tempNodeDoubleJump = tempNodeDoubleJump.nextNode.nextNode;
        }
        return tempNode;
    }

    //
    private Node getFromEndIndex(int index) {
        Node<T> main_ptr = head;
        Node<T> another_ptr = head;

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

    private Node<T> reverseNew() {
        Node<T> tempNode = head;
        Node<T> preTNode = null;
        Node<T> currentNode = tempNode;
        Node<T> nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.nextNode;
            currentNode.nextNode = preTNode;
            preTNode = currentNode;
            currentNode = nextNode;
        }
        this.head = preTNode;
        return head;
    }

    //

    //O(n+m) n= larger linkedlist, m = smaller linked list
    private static Integer findIntersectionPointImplementation1(CircularLinkedListDS<Integer> linkedList1, CircularLinkedListDS<Integer> linkedList2) {
        HashSet<Node> hashSet = new HashSet<>();
        Node<Integer> node1 = linkedList1.head;
        Node<Integer> node2 = linkedList2.head;
        while (node1 != null) {
            hashSet.add(node1);
            node1 = node1.nextNode;
        }
        while (node2 != null) {
            if (hashSet.contains(node2)) {
                return node2.value;
            }
            node2 = node2.nextNode;
        }
        return null;
    }

    //O(n) n is larger linkedlist
    private static Integer findIntersectionPointImplementation2(CircularLinkedListDS<Integer> linkedList1, CircularLinkedListDS<Integer> linkedList2) {
        Node<Integer> linkedList1Node = linkedList1.head;
        Node<Integer> linkedList2Node = linkedList2.head;
        int diff = linkedList1.size() - linkedList2.size();
        if (diff > 0) {
            diff = Math.abs(diff);
            while (linkedList1Node != null && diff > 0) {
                linkedList1Node = linkedList1Node.nextNode;
                --diff;
            }
        } else if (diff < 0) {
            while (linkedList2Node != null) {
                linkedList2Node = linkedList2Node.nextNode;
                --diff;
            }
        }
        while (linkedList1Node != null && linkedList2Node != null) {
            if (linkedList1Node.value == linkedList2Node.value) {
                return linkedList1Node.value;
            }
            linkedList1Node = linkedList1Node.nextNode;
            linkedList2Node = linkedList2Node.nextNode;
        }
        return null;
    }

    private static CircularLinkedListDS<Integer> intersectNode(CircularLinkedListDS<Integer> linkedList1, CircularLinkedListDS<Integer> linkedList2) {
        Node<Integer> intersectionNode = null;
        while (linkedList1.head != null && linkedList2.head != null) {
            if (linkedList1.head.value == linkedList2.head.value) {
                Node<Integer> node = new Node<>();
                node.value = (int) linkedList1.head.value;
                if (intersectionNode != null) {
                    node.nextNode = intersectionNode;
                }
                intersectionNode = node;
                linkedList1.head = linkedList1.head.nextNode;
                linkedList2.head = linkedList2.head.nextNode;
            } else if ((int) linkedList1.head.value < (int) linkedList2.head.value) {
                linkedList1.head = linkedList1.head.nextNode;
            } else {
                linkedList2.head = linkedList2.head.nextNode;
            }
        }
        CircularLinkedListDS<Integer> circularLinkedListDSNew = new CircularLinkedListDS<>();
        while (intersectionNode != null) {
            circularLinkedListDSNew.add(intersectionNode.value);
            intersectionNode = intersectionNode.nextNode;
        }
        return circularLinkedListDSNew;
    }


    private void removeDuplicateFromSortedList() {
        Node<T> tempNode = head;
        while (tempNode != null && tempNode.nextNode != null) {
            Node<T> currentNode = tempNode;
            Node<T> nextNode = tempNode.nextNode;
            if (currentNode.value == nextNode.value) {
                currentNode.nextNode = nextNode.nextNode;
                nextNode = null;
            }
            tempNode = tempNode.nextNode;
        }
    }

    private void removeDuplicateFromUnSortedList() {
        Node<T> tempNode = head;
        HashSet<T> hashSet1 = new HashSet<>();
        Node<T> preNode = null;
        while (tempNode != null && tempNode.nextNode != null) {
            if (hashSet1.contains(tempNode.value)) {
                preNode.nextNode = tempNode.nextNode;
            } else {
                hashSet1.add(tempNode.value);
                preNode = tempNode;
            }
            tempNode = tempNode.nextNode;
        }
    }

    private void moveLastNodeToFront() {
        Node<T> tempNode = head;
        Node<T> preNode = null;
        while (tempNode != null) {
            if (tempNode.nextNode == null && preNode != null) {
                preNode.nextNode = null;
                tempNode.nextNode = head;
                head = tempNode;
                return;
            }
            preNode = tempNode;
            tempNode = tempNode.nextNode;

        }
    }

    //TODO Match solution with geekforgeek solution https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
    private void nodeSwap(Integer nodeAVal, Integer nodeBVal) {
        Node<T> tempNode = head;
        Node<T> preNodeA = null, preNodeB = null, nodeA = null, nodeB = null, preNode = null;
        while (tempNode != null && (nodeA == null || nodeB == null)) {
            if (tempNode.value == nodeAVal || tempNode.value == nodeBVal) {
                if (nodeA == null) {
                    nodeA = tempNode;
                    preNodeA = preNode;
                } else {
                    nodeB = tempNode;
                    preNodeB = preNode;
                }
            }
            preNode = tempNode;
            tempNode = tempNode.nextNode;
        }
        //Found both nodeA and nodeB
        if (nodeA != null && nodeB != null) {
            //Adjacent nodes to be swapped
            if (nodeA.nextNode.hashCode() == nodeB.hashCode()) {
                nodeA.nextNode = nodeB.nextNode;
                nodeB.nextNode = nodeA;
                resetRootNodePointer((Node<T>) preNodeA, (Node<T>) nodeB);
                return;
            } else {
                //Non-Adjacent nodes to be swapped
                Node<T> nextNodeb = nodeB.nextNode;
                nodeB.nextNode = nodeA.nextNode;
                preNodeB.nextNode = nodeA;
                nodeA.nextNode = nextNodeb;
                resetRootNodePointer(preNodeA, nodeB);
            }
        }
        return;
    }

    private void resetRootNodePointer(Node<T> preNodeA, Node<T> nodeB) {
        if (preNodeA != null) {
            preNodeA.nextNode = nodeB;
            if (preNodeA.hashCode() == head.hashCode()) {
                head = preNodeA;
            }
            return;
        }
        head = nodeB;
    }

    private void swapElements() {
        Node<T> tempNode = head;
        while (tempNode != null && tempNode.nextNode != null) {
            T value = tempNode.value;
            tempNode.value = (T) tempNode.nextNode.value;
            tempNode.nextNode.value = value;
            tempNode = tempNode.nextNode.nextNode;
        }
    }

    //TODO QuickSort on Singly Linked List
    private void quickSort() {

    }

    static class Node<T> {
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
