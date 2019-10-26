package com.lalit.ds.basic.circularDoublyLL;

import com.lalit.ds.basic.tree.TreeDS;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 15-16th Pick top 6 problems FROM 5th problem and just solve them by own
 * TODO From 17th Jump on to Skip List must , complete idea by 18th
 **/
public class CircularDoublyLinkedListDS<T> {
    Node<T> head;
    private Node<T> tail;

    public Node<T> deepCopy() {
        Node<T> temp = head;
        CircularDoublyLinkedListDS<T> copy = new CircularDoublyLinkedListDS<>();
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
        if (head == null) {
            Node<T> newNode = new Node<>();
            newNode.value = element;
            tail = head = newNode;
            head.nextNode = head;
            head.previousNode = head;
            return;
        }
        Node<T> tempNode = head;
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
            if (tempNode.nextNode.hashCode() == head.hashCode()) {
                Node<T> newNode = new Node<>();
                newNode.value = element;
                tempNode.nextNode = newNode;
                head.previousNode = newNode;
                newNode.nextNode = head;
                newNode.previousNode = tempNode;
                tail = newNode;
                return;
            }

        }
    }

    public boolean remove(Node<T> nodeToDelete) {
        Node<T> tempNode = head;
        if (nodeToDelete == tempNode && tempNode.nextNode == tempNode && tempNode == tempNode.previousNode) {
            head = tail = null;
            return true;
        }
        while (tempNode.nextNode != head) {
            if (tempNode == nodeToDelete) {
                tempNode.previousNode.nextNode = tempNode.nextNode;
                tempNode.nextNode.previousNode = tempNode.previousNode;
                if (head == tempNode) {
                    head = tempNode.previousNode;
                } else if (tail == tempNode) {
                    tail = tempNode.previousNode;
                }
                return true;
            }
            tempNode = tempNode.nextNode;
        }
        return false;
    }

    public void reverse() {
        Node<T> currentNode = head;
        Node<T> nextNode = null;

        //Swap Next and Previous Node Pointer of Current Node
        while (currentNode.nextNode != head) {
            nextNode = currentNode.nextNode;
            swapPointersOfCurrentNode(currentNode, nextNode);
            currentNode = nextNode;
        }

        //Swap tail node pointers
        nextNode = currentNode.nextNode;
        swapPointersOfCurrentNode(currentNode, nextNode);

        //Swap Head and tail pointers
        currentNode = head;
        head = tail;
        tail = currentNode;
    }

    private void swapPointersOfCurrentNode(Node<T> tempNode, Node<T> nextNode) {
        tempNode.nextNode = tempNode.previousNode;
        tempNode.previousNode = nextNode;
    }

    public CircularDoublyLinkedListDS<T> treeToCircularDLL(TreeDS tree) {
        tree.inorderTraveral(this);
        return this;
    }

    //TODO redesign solution 19th oct 2019
    public void swapNodes(int kthNodeIndex) throws Exception {
        Node<T> tempNode = head;
        Node<T> pointerKthNodeFromStart = head;
        Node<T> pointerKthNodeFromEnd = head;
        int counter = 1;
        while (tempNode.nextNode != head) {
            if (counter < kthNodeIndex)
                pointerKthNodeFromStart = tempNode = tempNode.nextNode;
            else {
                pointerKthNodeFromEnd = pointerKthNodeFromEnd.nextNode;
                tempNode = tempNode.nextNode;
            }
            ++counter;
        }
        if (counter < kthNodeIndex) {
            throw new Exception("Length of Given List is less than kth Node");
        } else {
            if (pointerKthNodeFromEnd == pointerKthNodeFromStart) {
            } else if (pointerKthNodeFromStart.nextNode == pointerKthNodeFromEnd) {
                swapConsecutiveNodes(pointerKthNodeFromStart, pointerKthNodeFromEnd);
            } else if (pointerKthNodeFromStart == pointerKthNodeFromEnd.nextNode) {
                swapConsecutiveNodes(pointerKthNodeFromEnd, pointerKthNodeFromStart);
            } else {

                //TODO Optimise solution to in co-operate scenario when swapping nodes are consecutive
                Node<T> prevStartNode = pointerKthNodeFromStart.previousNode;
                Node<T> nextStartNode = pointerKthNodeFromStart.nextNode;
                Node<T> prevEndNode = pointerKthNodeFromEnd.previousNode;
                Node<T> nextEndNode = pointerKthNodeFromEnd.nextNode;
                if (nextStartNode == prevEndNode) {

                }
                prevStartNode.nextNode = pointerKthNodeFromEnd;
                pointerKthNodeFromEnd.previousNode = prevStartNode;
                pointerKthNodeFromEnd.nextNode = nextStartNode;
                nextStartNode.previousNode = pointerKthNodeFromEnd;

                prevEndNode.nextNode = pointerKthNodeFromStart;
                pointerKthNodeFromStart.previousNode = prevEndNode;
                nextEndNode.previousNode = pointerKthNodeFromStart;
                pointerKthNodeFromStart.nextNode = nextEndNode;
            }
        }
    }

    private void swapConsecutiveNodes(Node<T> pointerKthNodeFromStart, Node<T> pointerKthNodeFromEnd) {

        pointerKthNodeFromStart.previousNode.nextNode = pointerKthNodeFromEnd;
        pointerKthNodeFromEnd.previousNode = pointerKthNodeFromStart.previousNode;

        Node<T> temp = pointerKthNodeFromEnd.nextNode;
        pointerKthNodeFromStart.nextNode = pointerKthNodeFromEnd.nextNode;
        pointerKthNodeFromStart.previousNode = pointerKthNodeFromEnd;

        pointerKthNodeFromEnd.nextNode = pointerKthNodeFromStart;
        temp.previousNode = pointerKthNodeFromStart;
    }

    static class Node<T> {
        Node<T> nextNode;
        Node<T> previousNode;
        T value;

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        public Node<T> getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(Node<T> previousNode) {
            this.previousNode = previousNode;
        }
    }

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

}
