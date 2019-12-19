package com.lalit.sopra.steria.coding.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDirectOrIndirectReportees {

    private Node rootNode;

    class Node {
        private int value;
        private List<Node> children;

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(Node child) {
            if (children != null)
                children.add(child);
            else {
                children = new ArrayList<>();
                children.add(child);
            }
        }


        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }


    }

    public void buildTree(HashMap<Integer, Integer[]> map) throws Exception {
        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
            Node node = search(rootNode, entry.getKey());
            if (node == null && rootNode == null) {
                node = rootNode = new Node(entry.getKey());
            } else if (node == null && rootNode != null) {
                throw new Exception();
            }
            for (Integer child : entry.getValue()) {
                Node childNode = new Node(child);
                node.setChildren(childNode);
            }
        }
    }

    public Node search(Node rootNode, Integer nodeVal) throws Exception {
        if (rootNode == null)
            return null;
        else {
            Node tempNode = rootNode;
            if (tempNode.getValue() == nodeVal) {
                return tempNode;
            } else {
                if (tempNode.getChildren() != null) {
                    for (Node child : tempNode.getChildren()) {
                        Node result = search(child, nodeVal);
                        if (result != null)
                            return result;
                    }
                }
                return null;
            }
        }
    }

    //TODO **Priority-1** Print direct & indirect reportee i.e. all direct children till leaf nodes
    public void printReportee(Integer managerVal) {

    }

    public static void main(String... s) throws Exception {
        HashMap<Integer, Integer[]> map = new HashMap<>();
        map.put(1, new Integer[]{2, 3, 4});
        map.put(2, new Integer[]{5, 6});
        map.put(3, new Integer[]{7});
        map.put(4, new Integer[]{8});
        map.put(5, new Integer[]{9, 10});
        map.put(6, new Integer[]{11, 12});
        map.put(7, new Integer[]{13});
        //map.put(18, new Integer[]{131});

        FindAllDirectOrIndirectReportees obj = new FindAllDirectOrIndirectReportees();
        obj.buildTree(map);
        System.out.println(obj.rootNode);
    }

}
