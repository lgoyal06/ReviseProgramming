package com.lalit.ds.basic.skiplist;

import java.util.Random;

/**
 * Assumptions
 * 1.Only unique elements are allowed
 **/
public class SkipListImpl<T> {

    Node<T> head;

    private Node<T> getFirstSmallerNodeAtLevelZero(T value) {
        Node<T> tempNode = head;
        while (tempNode.nextNode != null) {
            if ((Integer) tempNode.nextNode.value < (Integer) value) {
                tempNode = tempNode.nextNode;
            } else if ((Integer) tempNode.nextNode.value > (Integer) value) {
                if (tempNode.downLevelNode == null) {
                    return tempNode;
                } else {
                    tempNode = tempNode.downLevelNode;
                }
            } else {
                //Element already exists. so can not add again
                return null;
            }
        }
        while (tempNode.downLevelNode != null) {
            tempNode = tempNode.downLevelNode;
        }
        return tempNode;
    }

    public boolean insert(T value) {
        Node<T> tempNode = head;
        Node<T> newNode = new Node(value);
        //Empty List
        if (tempNode == null) {
            Node<T> minusInfinityNode = new Node(-1000000000);
            tempNode = minusInfinityNode;
            newNode.preNode = tempNode;
            tempNode.nextNode = newNode;
            head = tempNode;
            return true;
        } else {
            //if Element found exit
            Node<T> preNodeInList = getFirstSmallerNodeAtLevelZero(value);
            if (preNodeInList != null) {
                newNode.nextNode = preNodeInList.nextNode;
                preNodeInList.nextNode = newNode;
                newNode.preNode = preNodeInList;
                //Flip coin until Head
                while (coinFlip() == 1) {
                    newNode = promoteNode(newNode);
                }
                return true;
            }
            return false;
        }
    }

    private int coinFlip() {
        Random random = new Random();
        return random.nextInt(16) % 2;
    }

    private Node<T> promoteNode(Node<T> nodeToPromote) {
        //if next level does not exists add
        if (nodeToPromote.level == head.level) {
            head.upLevelNode = new Node(-1000000000, head.level + 1);
            head.upLevelNode.downLevelNode = head;
            head = head.upLevelNode;
            nodeToPromote.upLevelNode = new Node(nodeToPromote.value, nodeToPromote.level + 1);
            nodeToPromote.upLevelNode.downLevelNode = nodeToPromote;
            head.nextNode = nodeToPromote.upLevelNode;
            nodeToPromote.upLevelNode.preNode = head;
        } else {
            Node<T> newNode = new Node(nodeToPromote.value, nodeToPromote.level + 1);
            nodeToPromote.upLevelNode = newNode;
            nodeToPromote.upLevelNode.downLevelNode = nodeToPromote;
            //fetch level+1 linked list
            Node<T> node = fetchLinkedListByLevel(nodeToPromote.level + 1, nodeToPromote.value);
            newNode.preNode = node;
            newNode.nextNode = node.nextNode;
            node.nextNode = newNode;
        }
        return nodeToPromote.upLevelNode;
    }

    private Node<T> fetchLinkedListByLevel(int level, T nodeValue) {
        Node<T> tempNode = head;
        while (tempNode.level > level) {
            tempNode = tempNode.downLevelNode;
        }
        while (tempNode.nextNode != null && (Integer) tempNode.nextNode.value < (Integer) nodeValue) {
            tempNode = tempNode.nextNode;
        }
        return tempNode;
    }

    public class Node<T> {
        Node<T> nextNode;
        Node<T> preNode;
        Node<T> upLevelNode;
        Node<T> downLevelNode;
        int level;
        T value;

        public Node(T value, int level) {
            this.value = value;
            this.level = level;
        }

        public Node(T value) {
            this.value = value;
            this.level = 0;
        }

    }

    public int size() {
        Node<T> tempNode = head;
        int counter = 0;
        while (tempNode.downLevelNode != null) {
            tempNode = tempNode.downLevelNode;
        }
        while (tempNode.nextNode != null) {
            ++counter;
            tempNode = tempNode.nextNode;
        }
        return counter;
    }

    //TODO deleteElement(T value)
    public boolean deleteElement(T value) {
        Node<T> nodeToDelete = searchNode(value);
        if (nodeToDelete != null) {
//Delete till Node from its MAX level to 0 level
        }
        return false;
    }

    private Node<T> searchNode(T value) {
        Node<T> tempNode = head;
        while (tempNode.nextNode != null) {
            if ((Integer) tempNode.nextNode.value < (Integer) value) {
                tempNode = tempNode.nextNode;
            } else if ((Integer) tempNode.nextNode.value > (Integer) value) {
                if (tempNode.downLevelNode != null) {
                    tempNode = tempNode.downLevelNode;
                } else {
                    return null;
                }
            } else {
                return tempNode;
            }
        }
        return null;
    }
}
