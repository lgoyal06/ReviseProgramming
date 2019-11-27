package com.lalit.ds.basic.sorting;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortingTestUtils {

    @Test
    public void testBubbleSort() {
        List<Integer> unsortedList = new ArrayList<>();
        unsortedList.add(1);
        unsortedList.add(2);
        unsortedList.add(3);
        unsortedList.add(84);
        unsortedList.add(7);
        SortingUtils.bubbleSort(unsortedList);
    }

    @Test
    public void testSelectionSort() {
        List<Integer> unsortedList = new ArrayList<>();
        unsortedList.add(1);
        unsortedList.add(2);
        unsortedList.add(3);
        unsortedList.add(84);
        unsortedList.add(7);
        SortingUtils.selectionSort(unsortedList);
    }

    @Test
    public void testInsertionSort() {
        List<Integer> unsortedList = new ArrayList<>();
        unsortedList.add(5);
        unsortedList.add(1);
        unsortedList.add(3);
        unsortedList.add(84);
        unsortedList.add(7);
        unsortedList.add(71);
        unsortedList.add(4);
        unsortedList.add(43);
        SortingUtils.insertionSort(unsortedList).stream().forEach(e -> System.out.println(e));
    }

    @Test
    public void testQuickSort() {
        List<Integer> unsortedList = new ArrayList<>();
        unsortedList.add(11);
        unsortedList.add(10);
        unsortedList.add(9);
        unsortedList.add(8);
        unsortedList.add(7);
        unsortedList.add(6);
        SortingUtils.quickSort(unsortedList, 0, unsortedList.size() - 1).stream().forEach(e -> System.out.println(e));

    }
}
