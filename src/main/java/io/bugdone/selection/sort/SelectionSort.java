package io.bugdone.selection.sort;

import java.util.ArrayList;
import java.util.List;

class SelectionSort {

    public static void main(String[] args) {
        System.out.println(selectionSort(new ArrayList<>(List.of(3, 4, 1, 2, 5))));
    }

    /**
     * returns the position of the smallest number
     */
    public static int findSmallest(ArrayList<Integer> array) {
        Integer smallest = array.get(0);
        int smallestIndex = 0;
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < smallest) {
                smallest = array.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> array) {
        int arraySize = array.size();
        ArrayList<Integer> newArray = new ArrayList<>(arraySize);
        for (int i = 0; i < arraySize; i++) {
            int smallest = findSmallest(array);
            newArray.add(array.get(smallest));
            array.remove(smallest);
        }
        return newArray;
    }
}
