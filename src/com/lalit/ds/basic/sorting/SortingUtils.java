package com.lalit.ds.basic.sorting;

import java.util.List;
import java.util.stream.Collectors;

public class SortingUtils {

    //Find min index each iteration and swap that value with i-th index
    public static List<Integer> selectionSort(List<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            int min_index = i;
            for (int j = i + 1; j < list.size(); ++j) {
                if (list.get(i) > list.get(j)) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                int b = list.get(min_index);
                list.set(min_index, list.get(i));
                list.set(i, b);
            }
            list.stream().collect(Collectors.toList()).forEach(e -> System.out.print(e + "->"));
            System.out.println();
        }
        return list;
    }

    //Adjacent element comparison and swap if required and at end of each iteration we have max element at end
    public static List<Integer> bubbleSort(List<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.println("Starting Element::" + list.get(i) + " ");
            boolean anySwap = false;
            for (int j = 0; j < list.size() - i - 1; ++j) {
                int a = list.get(j);
                int b = list.get(j + 1);
                if (a > b) {
                    anySwap = true;
                    int c = a;
                    list.set(j, b);
                    list.set(j + 1, a);
                }
            }
            list.stream().collect(Collectors.toList()).forEach(e -> System.out.print(e + "->"));
            System.out.println();
            if (!anySwap) {
                break;
            }

        }
        return list;
    }

    //TODO
    public static List<Integer> insertionSort(List<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            for (int j = i; j > 0; --j) {
                if (list.get(j) < list.get(j - 1)) {
                    int c = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, c);
                }
            }
        }
        return list;
    }

    //Find pivot and in each partition move pivot to its correct location in array and perform partition
    public static List<Integer> quickSort(List<Integer> list, int lo, int high) {
        if (lo < high) {
            int p = partition(list, lo, high);
            quickSort(list, lo, p - 1);
            quickSort(list, p + 1, high);
        }
        return list;
    }

    private static int partition(List<Integer> list, int lo, int high) {
        int pivot = list.get(high);
        int i = lo;
        for (int j = lo; j < high; ++j) {
            if (list.get(j) < pivot) {
                int c = list.get(i);
                list.set(i, list.get(j));
                list.set(j, c);
                ++i;
            }
        }
        int c = list.get(i);
        list.set(i, pivot);
        list.set(high, c);
        return i;
    }
}
