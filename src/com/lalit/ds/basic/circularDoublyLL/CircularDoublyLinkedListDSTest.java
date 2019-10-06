package com.lalit.ds.basic.circularDoublyLL;

import com.lalit.ds.basic.linkedlist.LinkedListDS;
import com.lalit.ds.basic.tree.TreeDS;

import java.util.List;

public class CircularDoublyLinkedListDSTest {

    public void addDeleteElementToLinkedListTest() {
        CircularDoublyLinkedListDS<Integer> integerCircularDoublyLinkedListDS = new CircularDoublyLinkedListDS<>();
        integerCircularDoublyLinkedListDS.add(3);
        integerCircularDoublyLinkedListDS.add(4);
        CircularDoublyLinkedListDS.IteratorCircularLinkedList iterator = integerCircularDoublyLinkedListDS.getIterator();
        // while (iterator != null) {
        //   System.out.println(iterator.next());
        //}

        //integerCircularLinkedListDS.toList().stream().forEach(e -> System.out.println(e));
        List<CircularDoublyLinkedListDS<Integer>> list = integerCircularDoublyLinkedListDS.splitIntoHalf();
        //System.out.println(list);
        CircularDoublyLinkedListDS<Integer> integerCircularDoublyLinkedListDS1 = new CircularDoublyLinkedListDS<>();
        integerCircularDoublyLinkedListDS1.add(1);
        integerCircularDoublyLinkedListDS1.add(2);
        integerCircularDoublyLinkedListDS1.remove(1);
        CircularDoublyLinkedListDS<Integer> integerCircularDoublyLinkedListDS2 = new CircularDoublyLinkedListDS<>();
        integerCircularDoublyLinkedListDS2.add(1);
        integerCircularDoublyLinkedListDS2.remove(1);
        CircularDoublyLinkedListDS<Integer> integerCircularDoublyLinkedListDS3 = new CircularDoublyLinkedListDS<>();
        integerCircularDoublyLinkedListDS3.add(1);
        integerCircularDoublyLinkedListDS3.add(2);
        integerCircularDoublyLinkedListDS3.add(3);
        integerCircularDoublyLinkedListDS3.remove(3);
        CircularDoublyLinkedListDS<Integer> integerCircularDoublyLinkedListDS4 = new CircularDoublyLinkedListDS<>();
        integerCircularDoublyLinkedListDS4.add(1);
        integerCircularDoublyLinkedListDS4.add(2);
        integerCircularDoublyLinkedListDS4.add(3);
        integerCircularDoublyLinkedListDS4.remove(2);
        CircularDoublyLinkedListDS<Integer> integerCircularDoublyLinkedListDS5 = new CircularDoublyLinkedListDS<>();
        integerCircularDoublyLinkedListDS5.add(1);
        integerCircularDoublyLinkedListDS5.add(2);
        integerCircularDoublyLinkedListDS5.add(3);
        integerCircularDoublyLinkedListDS5.add(4);
        integerCircularDoublyLinkedListDS5.remove(3);
        CircularDoublyLinkedListDS<Integer> integerCircularDoublyLinkedListDS6 = new CircularDoublyLinkedListDS<>();
        integerCircularDoublyLinkedListDS6.add(11);
        integerCircularDoublyLinkedListDS6.remove(34);
        CircularDoublyLinkedListDS<Integer> integerCircularDoublyLinkedListDS7 = new CircularDoublyLinkedListDS<>();
        integerCircularDoublyLinkedListDS7.add(1);
        integerCircularDoublyLinkedListDS7.add(2);
        integerCircularDoublyLinkedListDS7.add(3);
        integerCircularDoublyLinkedListDS7.add(4);
        integerCircularDoublyLinkedListDS7.remove(1);
        //   System.out.println(integerCircularLinkedListDS1);
        CircularDoublyLinkedListDS<Integer> integerCircularDoublyLinkedListDS127 = new CircularDoublyLinkedListDS<>();
        integerCircularDoublyLinkedListDS127.sortedInsert(10);
        integerCircularDoublyLinkedListDS127.sortedInsert(16);
        integerCircularDoublyLinkedListDS127.sortedInsert(9);
        integerCircularDoublyLinkedListDS127.sortedInsert(12);
        integerCircularDoublyLinkedListDS127.sortedInsert(121);
        // System.out.println(integerCircularLinkedListDS127);
        LinkedListDS<Integer> ls = new LinkedListDS<>();
        ls.add(12);
        ls.add(121);
        ls.add(123);
        //System.out.println(ls.isLoopExists());

        CircularDoublyLinkedListDS<Integer> integerCircularDoublyLinkedListDS1271 = new CircularDoublyLinkedListDS<>();
        integerCircularDoublyLinkedListDS1271.sortedInsert(10);
        integerCircularDoublyLinkedListDS1271.sortedInsert(16);
        /**        integerCircularLinkedListDS1271.sortedInsert(9);
         integerCircularLinkedListDS1271.sortedInsert(12);
         integerCircularLinkedListDS1271.sortedInsert(121);**/
        //integerCircularLinkedListDS1271.toList().stream().forEach(e->System.out.print(e+"--->"));
        integerCircularDoublyLinkedListDS1271.swapFirstAndLastNodes();
        //System.out.println();
        //integerCircularLinkedListDS1271.toList().stream().forEach(e->System.out.print(e+"--->"));

        CircularDoublyLinkedListDS<Integer> a = new CircularDoublyLinkedListDS<>();
        a.insertFront(12);
        a.deleteFront();
        a.insertFront(10);
        a.insertFront(22);
        a.deleteFront();
        a.insertFront(221);
        a.deleteFront();
        a.deleteFront();
        a.toList().stream().forEach(e -> System.out.print(e + "--->"));
        a.insertFront(35);
        a.insertRear(34);
        a.insertRear(341);
        a.insertFront(23);
        a.insertRear(231);
        //a.toList().stream().forEach(e -> System.out.print(e + "--->"));
        a.deleteRear();
        a.deleteRear();
        a.deleteRear();
        a.deleteFront();
        a.deleteRear();
        System.out.println();
        //     a.toList().stream().forEach(e -> System.out.print(e + "--->"));
        System.out.println();
        CircularDoublyLinkedListDS<Integer> circularQueue = new CircularDoublyLinkedListDS<>();
        circularQueue.enQueue(14);
        circularQueue.enQueue(22);
        circularQueue.enQueue(-6);
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.enQueue(9);
        circularQueue.enQueue(20);
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.enQueue(14);
        circularQueue.enQueue(22);
        circularQueue.enQueue(-6);
        //circularQueue.toList().stream().forEach(e -> System.out.print(e + "--->"));
        CircularDoublyLinkedListDS<Integer> circularQueue1 = new CircularDoublyLinkedListDS<>();
//        System.out.println(circularQueue1.josephusCircleLastRemainder(4,2));
        TreeDS<Integer> treeList = new TreeDS<Integer>();
        treeList.add(4);
        treeList.add(2);
        treeList.add(7);
        treeList.add(3);
        treeList.add(1);
        treeList.add(89);
        treeList.add(21);
        CircularDoublyLinkedListDS<Integer> circularDoublyLinkedListDS = new CircularDoublyLinkedListDS<>();
        circularDoublyLinkedListDS.treeToCircularLL(treeList);
        circularDoublyLinkedListDS.toList().stream().forEach(e -> System.out.println(e));
    }

    public static void main(String... s) {
        new CircularDoublyLinkedListDSTest().addDeleteElementToLinkedListTest();
    }
}
