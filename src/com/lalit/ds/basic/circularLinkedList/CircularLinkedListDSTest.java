package com.lalit.ds.basic.circularLinkedList;

import com.lalit.ds.basic.linkedlist.LinkedListDS;

import java.util.List;

public class CircularLinkedListDSTest {

    public void addDeleteElementToLinkedListTest() {
        CircularLinkedListDS<Integer> integerCircularLinkedListDS = new CircularLinkedListDS<>();
        integerCircularLinkedListDS.add(3);
        integerCircularLinkedListDS.add(4);


        integerCircularLinkedListDS.toList().stream().forEach(e -> System.out.println(e));
        List<CircularLinkedListDS<Integer>> list = integerCircularLinkedListDS.splitIntoHalf();
        System.out.println(list);
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
        System.out.println(integerCircularLinkedListDS1);
        CircularLinkedListDS<Integer> integerCircularLinkedListDS127 = new CircularLinkedListDS<>();
        integerCircularLinkedListDS127.sortedInsert(10);
        integerCircularLinkedListDS127.sortedInsert(16);
        integerCircularLinkedListDS127.sortedInsert(9);
        integerCircularLinkedListDS127.sortedInsert(12);
        integerCircularLinkedListDS127.sortedInsert(121);
        System.out.println(integerCircularLinkedListDS127);
        LinkedListDS<Integer> ls = new LinkedListDS<>();
        ls.add(12);
        ls.add(121);
        ls.add(123);
        System.out.println(ls.isLoopExists());
/** Iterator**/
 CircularLinkedListDS.IteratorCircularLinkedList iterator = integerCircularLinkedListDS.getIterator();
 while (iterator != null) {
 System.out.println(iterator.next());
 }
    }

    public static void main(String... s) {
        new CircularLinkedListDSTest().addDeleteElementToLinkedListTest();
    }
}
