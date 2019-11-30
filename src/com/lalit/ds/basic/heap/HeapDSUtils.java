package com.lalit.ds.basic.heap;

//Usage Heap Data Structure
//https://www.youtube.com/watch?v=B7hVxCmfPtM&t=2570s
//1. Find kth max /min element  - learn about total time complexity to find kth max element
//2.Heap sort
//3.Priority queue to find max/min element at top
public class HeapDSUtils {

    private static int[] heapifiedArray;

    //TODO Fix it Not correct 1st December 2019
    //https://www.youtube.com/watch?v=HqPJF2L5h9U Time 42:50
    public static int[] maxHeapify(int[] arrayToSort) {
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

    // Insert element O(log(n))
    public static boolean insert(int value) {
        int[] newArray = createBiggerArray(heapifiedArray, value);
        int latestValIndex = newArray.length - 1;
        for (int i = ((newArray.length) / 2) - 1; i >= 0; i = (i / 2) - 1) {
            if (value > newArray[i]) {
                swap(newArray, latestValIndex, i);
                latestValIndex = i;
            } else {
                break;
            }
            if (latestValIndex == 0) {
                break;
            }
        }
        heapifiedArray = newArray;
        return true;
    }

    private static int[] createBiggerArray(int[] oldArray, int newVal) {
        int[] newArray = new int[oldArray.length + 1];
        for (int i = 0, k = 0; i < oldArray.length; ++i, ++k) {
            newArray[i] = oldArray[k];
        }
        newArray[newArray.length - 1] = newVal;
        return newArray;
    }

    // Delete element O(log(n))
    public static int delete() {
        int maxVal = heapifiedArray[0];
        int[] remainingArray = copyArrayWithMaxVal(heapifiedArray);
        if (remainingArray != null) {
            for (int currentIndex = 0; currentIndex < remainingArray.length; ) {
                int leftChildIndex = (2 * (currentIndex + 1)) - 1;
                int rightChildIndex = (2 * (currentIndex + 1) + 1) - 1;
                int maxValChildIndex = leftChildIndex;
                if (rightChildIndex > remainingArray.length - 1 && leftChildIndex > remainingArray.length - 1) {
                    break;
                } else if (rightChildIndex <= remainingArray.length - 1 && (remainingArray[leftChildIndex] < remainingArray[rightChildIndex])) {
                    maxValChildIndex = rightChildIndex;
                }
                if (remainingArray[maxValChildIndex] > remainingArray[currentIndex]) {
                    swap(remainingArray, maxValChildIndex, currentIndex);
                    currentIndex = maxValChildIndex;
                } else {
                    break;
                }
            }
            heapifiedArray = remainingArray;
        }
        return maxVal;
    }

    private static int[] copyArrayWithMaxVal(int[] oldArray) {
        if (oldArray.length > 1) {
            int[] newArray = new int[oldArray.length - 1];
            newArray[0] = oldArray[oldArray.length - 1];
            for (int i = 1, k = 1; i < newArray.length; ++i, ++k) {
                newArray[i] = oldArray[k];
            }
            return newArray;
        } else {
            return null;
        }
    }

    //TODO Heapsort 1st December 2019
    public static int[] heapSort(int[] array) {
        return null;
    }

    public static void main(String... s) {
        //Fetch Max value one by one
        //Priority Queue with Max value at top
        int[] array = new int[]{3, 43, 2, 5343, 111123, 343};
        heapifiedArray = new int[0];
        insert(3);
        insert(43);
        insert(2);
        insert(5343);
        insert(111123);
        insert(343);
        insert(12);
        insert(1221212211);
        insert(34);
        insert(36);
        insert(78);
        insert(1);
        for (int i = 0; i < 12; ++i)
            System.out.println(delete());
    }


}
