package com.lalit.ds.basic.sorting;

//Usage Heap Data Structure
//https://www.youtube.com/watch?v=B7hVxCmfPtM&t=2570s
//1. Find kth max /min element  - learn about total time complexity to find kth max element
//2.Heap sort
//3.Priority queue to find max/min element at top
public class HeapDSUtils {

    public static int[] resultantArrayWithMaxAtIndex0(int[] arrayToSort) {
        int[] sortedArray = arrayToSort;
        for (int i = ((arrayToSort.length) - 1) / 2; i >= 0; --i) {
            sortedArray = maxHeapify(arrayToSort, i);
        }
        return sortedArray;
    }

    //Time Complexity is O(n) to get highest element on top of array
    private static int[] maxHeapify(int[] array, int i) {
        int leftChild = 2 * i;
        int rightChild = (2 * i) + 1;
        int largestValIndex = i;
        if (leftChild < array.length && array[leftChild] > array[largestValIndex]) {
            largestValIndex = leftChild;
        }
        if (rightChild < array.length && array[rightChild] > array[largestValIndex]) {
            largestValIndex = rightChild;
        }
        if (largestValIndex != i) {
            array = swap(array, largestValIndex, i);
        }
        return array;
    }

    private static int[] swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
        return array;
    }

    public static void main(String... s) {
        //Fetch Max value one by one
        //Priority Queue with Max value at top
        int[] array = new int[]{3, 43, 2, 5343, 23, 343};
        int length = array.length;
        for (int i = 0; i < length - 1; ++i) {
            array = resultantArrayWithMaxAtIndex0(array);
            System.out.println(array[0]);
            array = subArray(array);
        }


    }

    //TODO Heap Sort
    //TODO get Kth Largest Element
    //TODO Insert element
    //TODO Date 24th Nov 2019
    public static int[] insert() {
        return null;
    }

    //TODO Delete element
    public static int[] delete() {
        return null;
    }

    private static int[] subArray(int[] array) {
        int[] newArray = new int[array.length - 1];
        for (int i1 = 1, k = 0; i1 < array.length; ++i1, ++k) {
            newArray[k] = array[i1];
        }
        return newArray;
    }
}
