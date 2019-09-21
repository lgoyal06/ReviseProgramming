package com.lalit.ds.basic.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * And then match solutions
 * Link - https://www.geeksforgeeks.org/data-structures/linked-list/#singlyLinkedList
 **/
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

    /**
     * TODO This solution seems too complex to understand look at solution 25, seems easy but mindful
     * https://www.geeksforgeeks.org/data-structures/linked-list/
     **/
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

    public Node<T> reverseNew() {
        Node<T> tempNode = node;
        Node<T> preTNode = null;
        Node<T> currentNode = tempNode;
        Node<T> nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.nextNode;
            currentNode.nextNode = preTNode;
            preTNode = currentNode;
            currentNode = nextNode;
        }
        this.node = preTNode;
        return node;
    }

    //
    public Node<Integer> segragateEvenOddValueNodes() {
        Node<Integer> evenNode = null;
        Node<Integer> evenNodeEnd = null;
        Node<Integer> oddNode = null;
        Node<Integer> oddNodeEnd = null;
        Node<Integer> tempNode = node;
        while (tempNode != null) {
            Node<Integer> newNode = new Node<>();
            newNode.value = tempNode.value;
            if ((tempNode.value) % 2 == 0) {
                if (evenNode == null) {
                    evenNode = evenNodeEnd = newNode;
                } else {
                    evenNodeEnd.nextNode = newNode;
                    evenNodeEnd = evenNodeEnd.nextNode;
                }
            } else {
                if (oddNode == null) {
                    oddNode = oddNodeEnd = newNode;
                } else {
                    oddNodeEnd.nextNode = newNode;
                }
            }
            tempNode = tempNode.nextNode;
        }
        evenNodeEnd.nextNode = oddNode;
        return evenNode;
    }

    //O(n+m) n= larger linkedlist, m = smaller linked list
    public static Integer findIntersectionPointImplementation1(LinkedListDS<Integer> linkedList1, LinkedListDS<Integer> linkedList2) {
        HashSet<Node> hashSet = new HashSet<>();
        Node<Integer> node1 = linkedList1.node;
        Node<Integer> node2 = linkedList2.node;
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
    public static Integer findIntersectionPointImplementation2(LinkedListDS<Integer> linkedList1, LinkedListDS<Integer> linkedList2) {
        Node<Integer> linkedList1Node = linkedList1.node;
        Node<Integer> linkedList2Node = linkedList2.node;
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

    public static LinkedListDS<Integer> intersectNode(LinkedListDS<Integer> linkedList1, LinkedListDS<Integer> linkedList2) {
        Node<Integer> intersectionNode = null;
        while (linkedList1.node != null && linkedList2.node != null) {
            if (linkedList1.node.value == linkedList2.node.value) {
                Node<Integer> node = new Node<>();
                node.value = (int) linkedList1.node.value;
                if (intersectionNode != null) {
                    node.nextNode = intersectionNode;
                }
                intersectionNode = node;
                linkedList1.node = linkedList1.node.nextNode;
                linkedList2.node = linkedList2.node.nextNode;
            } else if ((int) linkedList1.node.value < (int) linkedList2.node.value) {
                linkedList1.node = linkedList1.node.nextNode;
            } else {
                linkedList2.node = linkedList2.node.nextNode;
            }
        }
        LinkedListDS<Integer> linkedListDSNew = new LinkedListDS<>();
        while (intersectionNode != null) {
            linkedListDSNew.add(intersectionNode.value);
            intersectionNode = intersectionNode.nextNode;
        }
        return linkedListDSNew;
    }


    public void removeDuplicateFromSortedList() {
        Node<T> tempNode = node;
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

    public void removeDuplicateFromUnSortedList() {
        Node<T> tempNode = node;
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

    public void moveLastNodeToFront() {
        Node<T> tempNode = node;
        Node<T> preNode = null;
        while (tempNode != null) {
            if (tempNode.nextNode == null && preNode != null) {
                preNode.nextNode = null;
                tempNode.nextNode = node;
                node = tempNode;
                return;
            }
            preNode = tempNode;
            tempNode = tempNode.nextNode;

        }
    }

    //TODO Match solution with geekforgeek solution https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
    public void nodeSwap(Integer nodeAVal, Integer nodeBVal) {
        Node<T> tempNode = node;
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
            if (preNodeA.hashCode() == node.hashCode()) {
                node = preNodeA;
            }
            return;
        }
        node = nodeB;
    }

    public void swapElements() {
        Node<T> tempNode = node;
        while (tempNode != null && tempNode.nextNode != null) {
            T value = tempNode.value;
            tempNode.value = (T) tempNode.nextNode.value;
            tempNode.nextNode.value = value;
            tempNode = tempNode.nextNode.nextNode;
        }
    }

    //TODO QuickSort on Singly Linked List
    public void quickSort() {

    }

    static class Node<T> {
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
