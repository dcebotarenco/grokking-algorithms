package io.bugdone.divide.and.conquer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class SumArrayRecursion {
    public static void main(String[] args) {
        LinkedList<Integer> array = new LinkedList<>(List.of(1, 2, 3, 4));
        System.out.println(arraySum(array.toArray(new Integer[0])));
        System.out.println(sum(array));
    }

    /**
     * O(n)
     *
     * @param array
     * @return
     */
    private static int sum(LinkedList<Integer> array) {
        if (array.isEmpty()) {
            return 0;
        }
        return array.removeFirst() + sum(array);
    }

    /**
     * O(n^2)
     *
     * @param array
     * @return
     */
    private static int arraySum(Integer[] array) {
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }
        Integer[] copy = Arrays.copyOfRange(array, 1, array.length);
        return array[0] + arraySum(copy);
    }
}
