package com.lalit.ds.basic.circularDoublyLL;

import com.lalit.ds.basic.tree.TreeDS;

public class CircularDoublyLinkedListDSTest {

    public void addDeleteElementToLinkedListTest() throws Exception {
        CircularDoublyLinkedListDS<Integer> integerCircularDoublyLinkedListDS = new CircularDoublyLinkedListDS<>();
        integerCircularDoublyLinkedListDS.add(3);
        integerCircularDoublyLinkedListDS.add(4);
        integerCircularDoublyLinkedListDS.add(41);
        //integerCircularDoublyLinkedListDS.toList().stream().forEach(e->System.out.println(e));
        integerCircularDoublyLinkedListDS.remove((CircularDoublyLinkedListDS.Node) integerCircularDoublyLinkedListDS.head.nextNode);
        integerCircularDoublyLinkedListDS.remove((CircularDoublyLinkedListDS.Node) integerCircularDoublyLinkedListDS.head);
        integerCircularDoublyLinkedListDS.remove((CircularDoublyLinkedListDS.Node) integerCircularDoublyLinkedListDS.head.nextNode);
        //integerCircularDoublyLinkedListDS.toList().stream().forEach(e -> System.out.println(e));
        integerCircularDoublyLinkedListDS.add(4);
        integerCircularDoublyLinkedListDS.add(41);
        integerCircularDoublyLinkedListDS.add(43);
        integerCircularDoublyLinkedListDS.add(44);
        integerCircularDoublyLinkedListDS.reverse();
      //  integerCircularDoublyLinkedListDS.toList().stream().forEach(e -> System.out.println(e));

        TreeDS<Integer> treeList = new TreeDS<Integer>();
        treeList.add(4);
        treeList.add(2);
        treeList.add(7);
        treeList.add(3);
        treeList.add(1);
        treeList.add(89);
        treeList.add(21);
        treeList.add(0);
        CircularDoublyLinkedListDS<Integer> circularDoublyLinkedListDS = new CircularDoublyLinkedListDS<>();
        circularDoublyLinkedListDS.treeToCircularDLL(treeList);
        //circularDoublyLinkedListDS.toList().stream().forEach(e -> System.out.println(e));
        CircularDoublyLinkedListDS<Integer> integerCircularDoublyLinkedListDSSwap = new CircularDoublyLinkedListDS<>();
        integerCircularDoublyLinkedListDSSwap.add(34);
        integerCircularDoublyLinkedListDSSwap.add(24);
        integerCircularDoublyLinkedListDSSwap.add(4);
        integerCircularDoublyLinkedListDSSwap.add(74);
        integerCircularDoublyLinkedListDSSwap.add(341);
        integerCircularDoublyLinkedListDSSwap.toList().stream().forEach(e->System.out.println(e));
        System.out.println("-----------------------------------");
        integerCircularDoublyLinkedListDSSwap.swapNodes(2);
        integerCircularDoublyLinkedListDSSwap.toList().stream().forEach(e->System.out.println(e));
        System.out.println("-----------------------------------");
        integerCircularDoublyLinkedListDSSwap.swapNodes(4);
        integerCircularDoublyLinkedListDSSwap.toList().stream().forEach(e->System.out.println(e));
        System.out.println("-----------------------------------");
        integerCircularDoublyLinkedListDSSwap.swapNodes(3);
        integerCircularDoublyLinkedListDSSwap.toList().stream().forEach(e->System.out.println(e));
        //Scenario when swapping nodes are adjecent to each other
        integerCircularDoublyLinkedListDSSwap.add(3411);
        System.out.println("-----------------------------------");
        integerCircularDoublyLinkedListDSSwap.toList().stream().forEach(e->System.out.println(e));
        System.out.println("-----------------------------------");
        integerCircularDoublyLinkedListDSSwap.swapNodes(3);
        integerCircularDoublyLinkedListDSSwap.toList().stream().forEach(e->System.out.println(e));
        System.out.println("-----------------------------------");
        integerCircularDoublyLinkedListDSSwap.swapNodes(4);
        integerCircularDoublyLinkedListDSSwap.toList().stream().forEach(e->System.out.println(e));
        System.out.println("-----------------------------------");
        integerCircularDoublyLinkedListDSSwap.swapNodes(1);
        integerCircularDoublyLinkedListDSSwap.toList().stream().forEach(e->System.out.println(e));
    }

    public static void main(String... s) throws Exception {
        new CircularDoublyLinkedListDSTest().addDeleteElementToLinkedListTest();
    }
}
