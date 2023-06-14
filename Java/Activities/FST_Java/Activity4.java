package org.activities;

import java.util.ArrayList;
import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args) {
        int[] unsortedArray = {10, 8, 27, 15, 96, 35, 45};
        ascendingSort(unsortedArray);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(unsortedArray));
    }

    static void ascendingSort(int array[]) {
        int size = array.length, i;

        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
}
