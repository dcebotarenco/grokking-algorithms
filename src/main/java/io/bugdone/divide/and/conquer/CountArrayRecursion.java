package io.bugdone.divide.and.conquer;

import java.util.Arrays;

class CountArrayRecursion {

    public static void main(String[] args) {
        System.out.println(count(new Integer[]{1, 2, 3, 4, 5}));
    }

    private static Integer count(Integer[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }

        Integer[] copy = Arrays.copyOfRange(array, 1, array.length);
        return 1 + count(copy);
    }


}
