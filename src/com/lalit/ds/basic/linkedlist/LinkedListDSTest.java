package com.lalit.ds.basic.linkedlist;

public class LinkedListDSTest {

    public void addDeleteElementToLinkedListTest() {
        LinkedListDS<Integer> integerLinkedListDS = new LinkedListDS<>();
        integerLinkedListDS.add(3);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.add(4);
        integerLinkedListDS.reverse();
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.add(5);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.add(6);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.reverse();
        integerLinkedListDS.remove(3);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.remove(5);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.remove(6);
        ////System.out.println(integerLinkedListDS.size());
        integerLinkedListDS.reverse();
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
       integerLinkedListDS.add(45);

        System.out.println(integerLinkedListDS.findMiddleNode().value);
    }

    public static void main(String... s) {
        new LinkedListDSTest().addDeleteElementToLinkedListTest();
    }
}
