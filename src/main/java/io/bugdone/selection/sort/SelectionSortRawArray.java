package io.bugdone.selection.sort;

import java.util.Arrays;

class SelectionSortRawArray {

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 4, 5};
        System.out.println(Arrays.toString(selectionSort(array)));
    }

    private static int[] selectionSort(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int positionOfSmallest = findSmallest(array, i);
            sortedArray[i] = array[positionOfSmallest];
            array[positionOfSmallest] = array[i];
        }
        return sortedArray;
    }

    private static int findSmallest(int[] array, int startPosition) {
        int smallest = array[startPosition];
        int smallestIndex = startPosition;
        for (int i = startPosition + 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

}
