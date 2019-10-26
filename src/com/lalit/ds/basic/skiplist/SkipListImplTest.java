package com.lalit.ds.basic.skiplist;


import org.junit.Test;

public class SkipListImplTest {

    @Test
    public void addFirstElementExpectAddedCorrectlyToSkipList() {
        SkipListImpl<Integer> skipList = new SkipListImpl<>();
        skipList.insert(3);
        System.out.println(skipList);
    }

    @Test
    public void addElementThatAlreadyExistsExpectNoNewElementAddedToSkipList() {
        SkipListImpl<Integer> skipList = new SkipListImpl<>();
        skipList.insert(3);
        skipList.insert(3);
        System.out.println(skipList);
    }

    @Test
    public void addSecondElementExpectNewElementAddedToSkipList() {
        SkipListImpl<Integer> skipList = new SkipListImpl<>();
        skipList.insert(3);
        skipList.insert(32);
        skipList.insert(45);
        skipList.insert(1);
        System.out.println(skipList.size());
    }
}
