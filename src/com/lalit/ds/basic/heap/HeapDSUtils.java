package com.lalit.ds.basic.heap;

import java.util.function.Consumer;

//Usage Heap Data Structure
//TODO Do a visit again, try to understand again 21 December 2019
//https://www.youtube.com/watch?v=B7hVxCmfPtM&t=2570s
//Operations
//Delete
//Insert
//Heapify random array
//Heap Sort
public class HeapDSUtils {

    private static int[] heapifiedArray;

    //Time Complexity is O(n) to heapify random array
    public static int[] maxHeapify(int[] arrayToSort) {
        int[] sortedArray = arrayToSort;
        for (int i = ((arrayToSort.length) / 2 - 1); i >= 0; --i) {
            sortedArray = maxHeapify(arrayToSort, i);
        }
        return sortedArray;
    }

    private static int[] maxHeapify(int[] array, int i) {
        while (isNonLeafNode(i, array.length)) {
            int largestValIndex = i;
            int leftChild = (2 * i) + 1;
            int rightChild = (2 * i) + 2;
            if (leftChild < array.length && array[leftChild] > array[largestValIndex]) {
                largestValIndex = leftChild;
            }
            if (rightChild < array.length && array[rightChild] > array[largestValIndex]) {
                largestValIndex = rightChild;
            }
            if (largestValIndex != i) {
                array = swap(array, largestValIndex, i);
                i = largestValIndex;
            } else {
                return array;
            }
        }
        return array;
    }

    private static boolean isNonLeafNode(int i, int i2) {
        return i <= (i2 / 2 - 1);
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

    // Heapify O(n)
    // Deletion O(nlogn)
    //Total - O(n)+O(nlogn)
    public static int[] heapSort(int[] array) {
        int[] sortedArray = new int[array.length];
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; ++i) {
            sortedArray[i] = delete();
        }
        return sortedArray;
    }

    public static void main(String... s) {
        int[] array = new int[]{10, 20, 15, 12, 40, 25, 33, 2322, 18, 34, 6, 56, 3, 2, 56, 222, 3, 1, 343434};
        /**heapifiedArray = new int[0];
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
         System.out.println(delete());**/
        heapifiedArray = maxHeapify(array);
        int heapSize = heapifiedArray.length;
        //for (int i = 0; i < heapSize; ++i)
        //    System.out.println(delete());
        int[] sortedArray = heapSort(heapifiedArray);
        Consumer<Integer> consumer = (val) -> System.out.println(val);
        for (int ele : sortedArray) {
            consumer.accept(ele);
        }
    }


}
