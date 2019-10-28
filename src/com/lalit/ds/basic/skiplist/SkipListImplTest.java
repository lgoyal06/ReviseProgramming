package com.lalit.ds.basic.skiplist;


import org.junit.Test;

public class SkipListImplTest{

    @Test
    public void addFirstElementExpectAddedCorrectlyToSkipList() {
        SkipListImpl<Integer> skipList = new SkipListImpl<>();
        skipList.insert(3);
        assert skipList.size() == 1;
    }

    @Test
    public void addElementThatAlreadyExistsExpectNoNewElementAddedToSkipList() {
        SkipListImpl<Integer> skipList = new SkipListImpl<>();
        skipList.insert(3);
        skipList.insert(3);
        assert skipList.size() == 1;
    }

    @Test
    public void addMoreThanTwoElementsExpectNewElementAddedToSkipList() {
        SkipListImpl<Integer> skipList = new SkipListImpl<>();
        skipList.insert(3);
        skipList.insert(32);
        skipList.insert(45);
        skipList.insert(1);
        assert skipList.size() == 4;
    }

    @Test
    public void deleteElementExpectNewElementAddedToSkipList() {
        SkipListImpl<Integer> skipList = new SkipListImpl<>();
        skipList.insert(3);
        skipList.insert(32);
        skipList.insert(45);
        skipList.insert(1);
        skipList.deleteElement(45);
        assert skipList.size() == 3;
    }
    @Test
    public void deleteMultipleElementExpectNewElementAddedToSkipList() {
        SkipListImpl<Integer> skipList = new SkipListImpl<>();
        skipList.insert(3);
        skipList.insert(32);
        skipList.insert(45);
        skipList.insert(1);
        skipList.deleteElement(45);
        skipList.insert(45);
        skipList.insert(45);
        skipList.deleteElement(3);
        skipList.insert(4533);
        skipList.insert(4533);
        System.out.println(skipList.size());
        skipList.toList().stream().forEach(e->System.out.println(e));
        assert skipList.size() == 4;

    }
}
