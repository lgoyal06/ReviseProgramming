package com.lalit.ds.basic.tree;

public class TreeDS<T> {
private Node<T> root;
    public void add(T value) {
        Node<T> tempNode = root;
        Node<T> newNode = new Node<>();
        newNode.value = value;
        if(root == null) {
            root = newNode;
        } else {
            while(tempNode != null) {
                if ((Integer) value < (Integer) tempNode.value) {
                    if (tempNode.left == null) {
                        tempNode.left = newNode;
                        return;
                    }
                    tempNode = tempNode.left;
                } else if ((Integer) value > (Integer) tempNode.value) {
                    if (tempNode.right == null) {
                        tempNode.right=newNode;
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
    public void treeTraverseLRR() {
        Node<T> tempNode = root;
        treeTraverseLRR(tempNode);
    }

    private void treeTraverseLRR(Node<T> tempNode) {
            treeTraverseLRR(tempNode.left);
            System.out.println(tempNode.value);
            treeTraverseLRR(tempNode.right);

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
