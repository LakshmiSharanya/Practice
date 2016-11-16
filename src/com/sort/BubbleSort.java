package com.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String args[]) {
        int arr[] = {-1, 3, 2, 7, 1};
        sortFor(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortWhile(int elements[]) {
        // Initial State
        int i = 0;
        int j = elements.length - 1;

        while (terminatingCondition(i, j)) {
            // do work.
            // Pick highest element and place in a[js]
            moveHighestElemntToEnd(i, j, elements);

            // do state transition
            i = 0;
            j = j - 1;
        }
    }

    private static void sortFor(int elements[]) {
        for (int i = 0, j = elements.length - 1; !((i == 0) && (j == 0)); i = 0, j = j - 1) {
            moveHighestElemntToEnd(i, j, elements);
        }
    }

    private static void moveHighestElemntToEnd(int i, int j, int elements[]) {
        if (i == j)
            return;

        int highestElementIndex = i;
        int highestElement = elements[i];
        for (int k = i + 1; k <= j; k++) {
            if (highestElement < elements[k]) {
                highestElement = elements[k];
                highestElementIndex = k;
            }
        }

        // Swap the highest element
        int temp = elements[highestElementIndex];
        elements[highestElementIndex] = elements[j];
        elements[j] = temp;

    }

    private static boolean terminatingCondition(int i, int j) {
        return !((i == 0) && (j == 0));
    }
}
