package io.bugdone.divide.and.conquer;

import java.util.Arrays;

class MaxNumberRecursion {
    public static void main(String[] args) {

        System.out.println(maxNumberRecursion(new Integer[]{1, 2, 3, 4, 8, 1}));
        System.out.println(maxNumberForLoop(new Integer[]{1, 2, 3, 4, 8, 1}));
        System.out.println(maxNumberWhileLoop(new Integer[]{1, 2, 3, 4, 8, 1}));
    }

    private static Integer maxNumberRecursion(Integer[] array) {
        if (array.length == 0) {
            return null;
        }

        if (array.length == 1) {
            return array[0];
        }

        Integer[] copy = Arrays.copyOfRange(array, 1, array.length);
        return Math.max(array[0], maxNumberRecursion(copy));

    }

    static Integer maxNumberForLoop(Integer[] array) {

        Integer max = null;
        for (int i = 0; i < array.length - 1; i++) {
            max = Math.max(array[i], array[i + 1]);
        }

        return max;
    }

    static Integer maxNumberWhileLoop(Integer[] array) {

        Integer max = null;
        int i = 0;
        while (i < array.length - 1) {
            max = Math.max(array[i], array[i + 1]);
            i++;
        }

        return max;
    }
}
