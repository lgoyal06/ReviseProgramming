package com.lalit.ds.basic.skiplist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Assumptions
 * 1.Only unique elements are allowed
 **/
public class SkipListImpl<T> {

    Node<T> head;

    public boolean insert(T value) {
        try {
            Node<T> tempNode = head;
            Node<T> newNode = new Node(value);
            if (tempNode == null) {
                Node<T> minusInfinityNode = new Node(-1000000000);
                newNode.preNode = minusInfinityNode;
                minusInfinityNode.nextNode = newNode;
                head = minusInfinityNode;
                return true;
            } else {
                Node<T> searchedNode = searchNodeByVal(value);
                if (!(compare(searchedNode.value, value) == 0)) {
                    insertNode(newNode, searchedNode);
                    while (coinFlip() == 1) {
                        newNode = promoteToNextLevel(newNode);
                    }
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

    private void insertNode(Node<T> newNode, Node<T> searchedNode) {
        Node<T> preNode = searchedNode;
        if (preNode.nextNode != null) {
            newNode.nextNode = preNode.nextNode;
            preNode.nextNode.preNode = newNode;
        }
        preNode.nextNode = newNode;
        newNode.preNode = preNode;
    }

    private int coinFlip() {
        Random random = new Random();
        return random.nextInt(16) % 2;
    }

    private Node<T> promoteToNextLevel(Node<T> nodeToPromote) {
        Node<T> newNode = new Node(nodeToPromote.value, nodeToPromote.level + 1);
        nodeToPromote.upLevelNode = newNode;
        newNode.downLevelNode = nodeToPromote;
        if (doesPromoteToLevelExists(nodeToPromote.level)) {
            Node<T> preNodeAtPromotedLevel = preNodeToAttachAtPromotedLevel(nodeToPromote.level + 1, nodeToPromote.value);
            insertNode(newNode, preNodeAtPromotedLevel);
        } else {
            Node<T> newHeadNodeAtPromotedLevel = new Node(-1000000000, head.level + 1);
            head.upLevelNode = newHeadNodeAtPromotedLevel;
            newHeadNodeAtPromotedLevel.downLevelNode = head;
            head = newHeadNodeAtPromotedLevel;
            head.nextNode = newNode;
            newNode.preNode = head;
        }
        return nodeToPromote.upLevelNode;
    }

    private boolean doesPromoteToLevelExists(int nodeCurrentLevel) {
        return head.level > nodeCurrentLevel;
    }

    private Node<T> preNodeToAttachAtPromotedLevel(int level, T nodeValue) {
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

    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Node<T> tempNode = head;
        while (tempNode.downLevelNode != null) {
            tempNode = tempNode.downLevelNode;
        }
        list.add(tempNode.value);
        while (tempNode.nextNode != null) {
            list.add(tempNode.nextNode.value);
            tempNode = tempNode.nextNode;
        }
        return list;
    }

    public boolean deleteElement(T value) {
        Node<T> nodeToDelete = searchNodeByVal(value);
        if (nodeToDelete != null && nodeToDelete.value == value) {
            do {
                nodeToDelete.preNode.nextNode = nodeToDelete.nextNode;
                if (nodeToDelete.nextNode != null)
                    nodeToDelete.nextNode.preNode = nodeToDelete.preNode;
                nodeToDelete = nodeToDelete.downLevelNode;
            } while (nodeToDelete != null);
            return true;
        }
        return false;
    }

    private Node<T> searchNodeByVal(T value) {
        try {
            Node<T> tempNode = head;
            while (tempNode.nextNode != null || tempNode.downLevelNode != null) {
                if (tempNode.nextNode == null || compare(tempNode.nextNode.value, value) > 0) {
                    if (tempNode.downLevelNode == null) {
                        return tempNode;
                    }
                    tempNode = tempNode.downLevelNode;
                } else if (compare(tempNode.nextNode.value, value) < 0) {
                    tempNode = tempNode.nextNode;
                } else if (compare(tempNode.nextNode.value, value) == 0) {
                    return tempNode.nextNode;
                }
            }
            return tempNode;
        } catch (Exception e) {
            return null;
        }
    }

    private int compare(T val1, T val2) throws Exception {
        String getClassSimpleName = val1.getClass().getSimpleName();
        switch (getClassSimpleName) {
            case "Integer":
                return ((Integer) val1).compareTo((Integer) val2);
            default:
                throw new Exception();
        }
    }
}
