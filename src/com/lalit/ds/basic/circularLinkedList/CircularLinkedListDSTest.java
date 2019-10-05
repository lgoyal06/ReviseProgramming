package com.lalit.ds.basic.circularLinkedList;

import com.lalit.ds.basic.linkedlist.LinkedListDS;

import java.util.List;

public class CircularLinkedListDSTest {

    public void addDeleteElementToLinkedListTest() {
        CircularLinkedListDS<Integer> integerCircularLinkedListDS = new CircularLinkedListDS<>();
        integerCircularLinkedListDS.add(3);
        integerCircularLinkedListDS.add(4);
        CircularLinkedListDS.IteratorCircularLinkedList iterator = integerCircularLinkedListDS.getIterator();
       // while (iterator != null) {
         //   System.out.println(iterator.next());
        //}

        //integerCircularLinkedListDS.toList().stream().forEach(e -> System.out.println(e));
        List<CircularLinkedListDS<Integer>> list = integerCircularLinkedListDS.splitIntoHalf();
        //System.out.println(list);
        CircularLinkedListDS<Integer> integerCircularLinkedListDS1 = new CircularLinkedListDS<>();
        integerCircularLinkedListDS1.add(1);
        integerCircularLinkedListDS1.add(2);
        integerCircularLinkedListDS1.remove(1);
        CircularLinkedListDS<Integer> integerCircularLinkedListDS2 = new CircularLinkedListDS<>();
        integerCircularLinkedListDS2.add(1);
        integerCircularLinkedListDS2.remove(1);
        CircularLinkedListDS<Integer> integerCircularLinkedListDS3 = new CircularLinkedListDS<>();
        integerCircularLinkedListDS3.add(1);
        integerCircularLinkedListDS3.add(2);
        integerCircularLinkedListDS3.add(3);
        integerCircularLinkedListDS3.remove(3);
        CircularLinkedListDS<Integer> integerCircularLinkedListDS4 = new CircularLinkedListDS<>();
        integerCircularLinkedListDS4.add(1);
        integerCircularLinkedListDS4.add(2);
        integerCircularLinkedListDS4.add(3);
        integerCircularLinkedListDS4.remove(2);
        CircularLinkedListDS<Integer> integerCircularLinkedListDS5 = new CircularLinkedListDS<>();
        integerCircularLinkedListDS5.add(1);
        integerCircularLinkedListDS5.add(2);
        integerCircularLinkedListDS5.add(3);
        integerCircularLinkedListDS5.add(4);
        integerCircularLinkedListDS5.remove(3);
        CircularLinkedListDS<Integer> integerCircularLinkedListDS6 = new CircularLinkedListDS<>();
        integerCircularLinkedListDS6.add(11);
        integerCircularLinkedListDS6.remove(34);
        CircularLinkedListDS<Integer> integerCircularLinkedListDS7 = new CircularLinkedListDS<>();
        integerCircularLinkedListDS7.add(1);
        integerCircularLinkedListDS7.add(2);
        integerCircularLinkedListDS7.add(3);
        integerCircularLinkedListDS7.add(4);
        integerCircularLinkedListDS7.remove(1);
        //   System.out.println(integerCircularLinkedListDS1);
        CircularLinkedListDS<Integer> integerCircularLinkedListDS127 = new CircularLinkedListDS<>();
        integerCircularLinkedListDS127.sortedInsert(10);
        integerCircularLinkedListDS127.sortedInsert(16);
        integerCircularLinkedListDS127.sortedInsert(9);
        integerCircularLinkedListDS127.sortedInsert(12);
        integerCircularLinkedListDS127.sortedInsert(121);
        // System.out.println(integerCircularLinkedListDS127);
        LinkedListDS<Integer> ls = new LinkedListDS<>();
        ls.add(12);
        ls.add(121);
        ls.add(123);
        //System.out.println(ls.isLoopExists());

        CircularLinkedListDS<Integer> integerCircularLinkedListDS1271 = new CircularLinkedListDS<>();
        integerCircularLinkedListDS1271.sortedInsert(10);
        integerCircularLinkedListDS1271.sortedInsert(16);
        /**        integerCircularLinkedListDS1271.sortedInsert(9);
         integerCircularLinkedListDS1271.sortedInsert(12);
         integerCircularLinkedListDS1271.sortedInsert(121);**/
        //integerCircularLinkedListDS1271.toList().stream().forEach(e->System.out.print(e+"--->"));
        integerCircularLinkedListDS1271.swapFirstAndLastNodes();
        //System.out.println();
        //integerCircularLinkedListDS1271.toList().stream().forEach(e->System.out.print(e+"--->"));

        CircularLinkedListDS<Integer> a = new CircularLinkedListDS<>();
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
        CircularLinkedListDS<Integer> circularQueue = new CircularLinkedListDS<>();
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
        circularQueue.toList().stream().forEach(e -> System.out.print(e + "--->"));
        CircularLinkedListDS<Integer> circularQueue1 = new CircularLinkedListDS<>();
        circularQueue1.josephusCircleLastRemainder(5,3);

    }

    public static void main(String... s) {
        new CircularLinkedListDSTest().addDeleteElementToLinkedListTest();
    }
}
