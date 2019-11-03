package com.lalit.algorithm;

public class FindMaxElement {

    public static int findMaxElement(int[] array) {
        int maxElement = array[0];
        for (int val : array) {
            if (val > maxElement) {
                maxElement = val;
            }
        }
        return maxElement;
    }

    public static int findSecondMaxElement(int[] array) {
        int maxElement = array[0];
        int secondMaxElement = array[0];

        for (int val : array) {
            if (val > maxElement) {
                secondMaxElement = maxElement;
                maxElement = val;
            } else if (val > secondMaxElement) {
                secondMaxElement = val;
            }
        }
        return secondMaxElement;
    }

    public static void main(String... s) {
        int[] array = new int[]{3, 23, 2, 111, 45, 5, 6};
        System.out.println(FindMaxElement.findMaxElement(array));
        System.out.println(FindMaxElement.findSecondMaxElement(array));
    }

}
