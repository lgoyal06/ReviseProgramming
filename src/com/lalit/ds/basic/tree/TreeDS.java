package com.lalit.ds.basic.tree;

import com.lalit.ds.basic.circularDoublyLL.CircularDoublyLinkedListDS;
import com.lalit.ds.basic.circularLinkedList.CircularLinkedListDS;

public class TreeDS<T> {
    private Node<T> root;

    public void add(T value) {
        Node<T> tempNode = root;
        Node<T> newNode = new Node<>();
        newNode.value = value;
        if (root == null) {
            root = newNode;
        } else {
            while (tempNode != null) {
                if ((Integer) value < (Integer) tempNode.value) {
                    if (tempNode.left == null) {
                        tempNode.left = newNode;
                        return;
                    }
                    tempNode = tempNode.left;
                } else if ((Integer) value > (Integer) tempNode.value) {
                    if (tempNode.right == null) {
                        tempNode.right = newNode;
                        return;
                    }
                    tempNode = tempNode.right;
                } else {
                    throw new RuntimeException("Binary Tree should contains unique values");
                }
            }
        }
    }
//TODO Complete Left-Root-Right Traverse


    public void inorderTraveral(CircularLinkedListDS<T> circularLinkedListDS
    ) {
        Node<T> tempNode = root;
        inorderTraveral(tempNode, circularLinkedListDS);
    }

    private void inorderTraveral(Node<T> tempNode, CircularDoublyLinkedListDS<T> circularDoublyLinkedListDS) {
        //Very imp step
        if (tempNode == null)
            return;
        inorderTraveral(tempNode.left, circularDoublyLinkedListDS);
        T value = tempNode.value;
        //System.out.println(value);
        circularDoublyLinkedListDS.add(value);
        inorderTraveral(tempNode.right, circularDoublyLinkedListDS);
    }

    public void inorderTraveral(CircularDoublyLinkedListDS<T> circularDoublyLinkedListDS
    ) {
        Node<T> tempNode = root;
        inorderTraveral(tempNode, circularDoublyLinkedListDS);
    }

    private void inorderTraveral(Node<T> tempNode, CircularLinkedListDS<T> circularLinkedListDS) {
        //Very imp step
        if (tempNode == null)
            return;
        inorderTraveral(tempNode.left, circularLinkedListDS);
        T value = tempNode.value;
        //System.out.println(value);
        circularLinkedListDS.add(value);
        inorderTraveral(tempNode.right, circularLinkedListDS);
    }


    public void inorderTraveral() {
        Node<T> tempNode = root;
        inorderTraveral(tempNode);
    }

    private void inorderTraveral(Node<T> tempNode) {
        //Very imp step
        if (tempNode == null)
            return;
        inorderTraveral(tempNode.left);
        T value = tempNode.value;
        System.out.println(value);
        inorderTraveral(tempNode.right);
    }


    public void preorderTraveral() {
        Node<T> tempNode = root;
        preorderTraveral(tempNode);
    }

    private void preorderTraveral(Node<T> tempNode) {
        if (tempNode == null)
            return;
        System.out.println(tempNode.value);
        preorderTraveral(tempNode.left);
        preorderTraveral(tempNode.right);
    }

    public void postorderTraveral() {
        Node<T> tempNode = root;
        postorderTraveral(tempNode);
    }

    private void postorderTraveral(Node<T> tempNode) {
        if (tempNode == null)
            return;
        postorderTraveral(tempNode.left);
        postorderTraveral(tempNode.right);
        System.out.println(tempNode.value);
    }

    private class Node<T> {
        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        Node<T> left;
        Node<T> right;
        T value;
    }
}
