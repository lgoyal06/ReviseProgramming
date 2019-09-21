package com.lalit.ds.basic.linkedlist;

public class LinkedListDSTest {

    public void addDeleteElementToLinkedListTest() {
        LinkedListDS<Integer> integerLinkedListDS = new LinkedListDS<>();
        integerLinkedListDS.add(3);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.add(4);
        integerLinkedListDS.reverseNew();
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.add(5);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.add(6);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.reverseNew();
        integerLinkedListDS.remove(3);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.remove(5);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.remove(6);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.reverseNew();
        integerLinkedListDS.remove(4);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.add(5);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.remove(4);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.remove(5);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.remove(4);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.add(3);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.add(4);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.add(5);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.add(6);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.removeAtIndex(3);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.removeAtIndex(0);
        ////System.out.println(integerLinkedListDS.size());
        ////System.out.println(integerLinkedListDS.size());
        //integerLinkedListDS.remove(5);
        //integerLinkedListDS.add(3);
        // integerLinkedListDS.node.nextNode.nextNode.nextNode.nextNode = integerLinkedListDS.node;
        integerLinkedListDS.removeLoop();
        integerLinkedListDS.add(6);
        integerLinkedListDS.add(7);
        integerLinkedListDS.add(8);
        integerLinkedListDS.add(4);

        integerLinkedListDS.segragateEvenOddValueNodes();
        LinkedListDS<Integer> integerLinkedListDS1 = new LinkedListDS<>();
        integerLinkedListDS1.add(45);
        integerLinkedListDS1.add(56);
        integerLinkedListDS1.node.nextNode = integerLinkedListDS.node.nextNode;
        //System.out.println(integerLinkedListDS.findMiddleNode().value);
        System.out.println(LinkedListDS.findIntersectionPointImplementation1(integerLinkedListDS, integerLinkedListDS1));
        System.out.println(LinkedListDS.findIntersectionPointImplementation2(integerLinkedListDS, integerLinkedListDS1));
        System.out.println(integerLinkedListDS.getFromEndIndex(4).value);

        LinkedListDS<Integer> integerLinkedListDS21 = new LinkedListDS<>();
        integerLinkedListDS21.add(1);
        integerLinkedListDS21.add(2);
        integerLinkedListDS21.add(3);
        integerLinkedListDS21.add(4);
        integerLinkedListDS21.add(5);
        integerLinkedListDS21.add(6);

        LinkedListDS<Integer> integerLinkedListDS22 = new LinkedListDS<>();
        integerLinkedListDS22.add(2);
        integerLinkedListDS22.add(4);
        integerLinkedListDS22.add(6);

        LinkedListDS.intersectNode(integerLinkedListDS21, integerLinkedListDS22);

        LinkedListDS<Integer> integerLinkedList100 = new LinkedListDS<>();
        integerLinkedList100.add(1);
        integerLinkedList100.add(2);
        integerLinkedList100.add(2);
        integerLinkedList100.add(4);
        integerLinkedList100.add(6);
        integerLinkedList100.add(6);
        integerLinkedList100.add(8);
        integerLinkedList100.removeDuplicateFromSortedList();
        System.out.println(integerLinkedList100.size());
        LinkedListDS<Integer> integerLinkedUnSortedList = new LinkedListDS<>();
        integerLinkedUnSortedList.add(1);
        integerLinkedUnSortedList.add(2);
        integerLinkedUnSortedList.add(6);
        integerLinkedUnSortedList.add(4);
        integerLinkedUnSortedList.add(6);
        integerLinkedUnSortedList.add(2);
        integerLinkedUnSortedList.add(8);
        integerLinkedUnSortedList.removeDuplicateFromUnSortedList();
        integerLinkedUnSortedList.moveLastNodeToFront();
        LinkedListDS<Integer> integerLinkedUnSortedList1 = new LinkedListDS<>();
        integerLinkedUnSortedList1.add(1);
        integerLinkedUnSortedList1.add(2);
        integerLinkedUnSortedList1.moveLastNodeToFront();
        LinkedListDS<Integer> swapElementsList = new LinkedListDS<>();
        swapElementsList.add(1);

        swapElementsList.swapElements();
        System.out.println("Test");

        LinkedListDS<Integer> integerLinkedUnSortedListSwapNodes = new LinkedListDS<>();
        //Adjecent a head node
        integerLinkedUnSortedListSwapNodes.add(1);
        integerLinkedUnSortedListSwapNodes.add(2);
        integerLinkedUnSortedListSwapNodes.add(3);

        integerLinkedUnSortedListSwapNodes.nodeSwap(2,1);

        LinkedListDS<Integer> integerLinkedUnSortedListSwapNodes1 = new LinkedListDS<>();

        //Adjecent a not head node and b not tail
        integerLinkedUnSortedListSwapNodes1.add(1);
        integerLinkedUnSortedListSwapNodes1.add(2);
        integerLinkedUnSortedListSwapNodes1.add(3);
        integerLinkedUnSortedListSwapNodes1.add(4);
        integerLinkedUnSortedListSwapNodes1.nodeSwap(2,3);

        LinkedListDS<Integer> integerLinkedUnSortedListSwapNodes11 = new LinkedListDS<>();
        //Adjecent a not head node and b not tail previous of A not tail
        integerLinkedUnSortedListSwapNodes11.add(1);
        integerLinkedUnSortedListSwapNodes11.add(7);
        integerLinkedUnSortedListSwapNodes11.add(2);
        integerLinkedUnSortedListSwapNodes11.add(3);
        integerLinkedUnSortedListSwapNodes11.add(4);
        integerLinkedUnSortedListSwapNodes11.nodeSwap(2,3);

        LinkedListDS<Integer> integerLinkedUnSortedListSwapNodes2 = new LinkedListDS<>();
        //Adjecent b tail node
        integerLinkedUnSortedListSwapNodes2.add(1);
        integerLinkedUnSortedListSwapNodes2.add(2);
        integerLinkedUnSortedListSwapNodes2.add(3);
        integerLinkedUnSortedListSwapNodes2.nodeSwap(2,3);

        LinkedListDS<Integer> integerLinkedUnSortedListSwapNodesNon = new LinkedListDS<>();
        //Not Adjecent a head node and b as tail
        integerLinkedUnSortedListSwapNodesNon.add(1);
        integerLinkedUnSortedListSwapNodesNon.add(2);
        integerLinkedUnSortedListSwapNodesNon.add(4);
        integerLinkedUnSortedListSwapNodesNon.add(3);

        integerLinkedUnSortedListSwapNodesNon.nodeSwap(1,3);

        LinkedListDS<Integer> integerLinkedUnSortedListSwapNodesNon1 = new LinkedListDS<>();
        //Not Adjecent a not head node and b not tail
        integerLinkedUnSortedListSwapNodesNon1.add(1);
        integerLinkedUnSortedListSwapNodesNon1.add(2);
        integerLinkedUnSortedListSwapNodesNon1.add(3);
        integerLinkedUnSortedListSwapNodesNon1.add(4);
        integerLinkedUnSortedListSwapNodesNon1.add(5);
        integerLinkedUnSortedListSwapNodesNon1.add(51);
        integerLinkedUnSortedListSwapNodesNon1.add(53);
        integerLinkedUnSortedListSwapNodesNon1.add(55);
        integerLinkedUnSortedListSwapNodesNon1.nodeSwap(3,51);

        LinkedListDS<Integer> integerLinkedUnSortedListSwapNodesNon2 = new LinkedListDS<>();
        //non Adjecent b tail node and a non root
        integerLinkedUnSortedListSwapNodesNon2.add(11);
        integerLinkedUnSortedListSwapNodesNon2.add(10);
        integerLinkedUnSortedListSwapNodesNon2.add(1);
        integerLinkedUnSortedListSwapNodesNon2.add(13);
        integerLinkedUnSortedListSwapNodesNon2.add(2);
        integerLinkedUnSortedListSwapNodesNon2.add(3);
        integerLinkedUnSortedListSwapNodesNon2.nodeSwap(1,3);

        LinkedListDS<Integer> integerLinkedUnSortedListSwapNodesNon11 = new LinkedListDS<>();
        //Not Adjecent a not head node and b not tail prevA is root
        integerLinkedUnSortedListSwapNodesNon11.add(1);
        integerLinkedUnSortedListSwapNodesNon11.add(2);
        integerLinkedUnSortedListSwapNodesNon11.add(3);
        integerLinkedUnSortedListSwapNodesNon11.add(4);
        integerLinkedUnSortedListSwapNodesNon11.add(5);
        integerLinkedUnSortedListSwapNodesNon11.add(51);
        integerLinkedUnSortedListSwapNodesNon11.add(53);
        integerLinkedUnSortedListSwapNodesNon11.add(55);
        integerLinkedUnSortedListSwapNodesNon11.nodeSwap(2,51);


        LinkedListDS<Integer> integerLinkedUnSortedListSwapNodesBNot = new LinkedListDS<>();
        //Node b not present
        integerLinkedUnSortedListSwapNodesBNot.add(1);
        integerLinkedUnSortedListSwapNodesNon11.nodeSwap(1,51);
        System.out.println("Hello");
    }

    public static void main(String... s) {
        new LinkedListDSTest().addDeleteElementToLinkedListTest();
    }
}
