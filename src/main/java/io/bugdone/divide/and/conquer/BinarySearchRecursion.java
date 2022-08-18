package io.bugdone.divide.and.conquer;

import java.util.List;

class BinarySearchRecursion {

    /**
     * O (log n)
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] integers = List.of(1, 2, 4, 5, 8, 9).toArray(Integer[]::new);
        System.out.println(search(integers, 0, integers.length - 1, 5));
    }

    private static Integer search(Integer[] array, int left, int right, int item) {
        if (array.length == 0) {
            return null;
        }

        if (array.length == 1) {
            if (array[0] == item) {
                return 0;
            } else {
                return null;
            }
        }

        int mid = left + (right - left) / 2;

        int guess = array[mid];
        if (guess == item) {
            return mid;
        }

        if (item < guess) {
            return search(array, left, mid - 1, item);
        } else {
            return search(array, mid + 1, right, item);
        }

    }
}
