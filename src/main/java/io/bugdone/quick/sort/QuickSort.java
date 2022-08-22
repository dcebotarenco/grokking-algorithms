package io.bugdone.quick.sort;

import java.util.Arrays;
import java.util.List;

class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(List.of(3, 2, 5, 0, 1, 8, 7, 6, 9, 4))));
    }

    private static Integer[] sort(List<Integer> list) {
        Integer[] integers = list.toArray(Integer[]::new);
        sort(integers, 0, list.size() - 1);
        return integers;
    }

    private static void sort(Integer[] array, int start, int end) {
        if (start < end) {

            int pivotIndex = partitionArray(array, start, end);

            sort(array, start, pivotIndex - 1);
            sort(array, pivotIndex + 1, end);
        }
    }

    private static int partitionArray(Integer[] array, int start, int end) {
        int pivotIndex = end;
        int pivotValue = array[pivotIndex];
        int swapMarker = start - 1; //start from -1
        //use start, not 0
        //recursively start, end vary
        for (int i = start; i < pivotIndex; i++) {
            if (array[i] <= pivotValue) {
                swapMarker++;
                swap(array, i, swapMarker);
            }
        }
        swap(array, swapMarker + 1, pivotIndex);
        return swapMarker;
    }

    private static void swap(Integer[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }
}
