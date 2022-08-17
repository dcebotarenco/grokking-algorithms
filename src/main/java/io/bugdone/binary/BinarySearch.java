package io.bugdone.binary;

import java.util.List;

class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(binarySearch(list, 3));

    }

    /**
     * Returns the position of the match
     */
    public static Integer binarySearch(List<Integer> list, int item) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int midPosition = (left + right) / 2;
            int guess = list.get(midPosition);
            if (guess == item) {
                return midPosition;
            }
            if (guess < midPosition) {
                left = midPosition + 1;
            } else {
                right = midPosition - 1;
            }
        }
        return null;
    }
}
