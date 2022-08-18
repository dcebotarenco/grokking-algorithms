package io.bugdone.divide.and.conquer;

class FarmProblemRecursion {
    public static void main(String[] args) {

        int length = 1680;
        int width = 640;

        System.out.println(minSquareLength(length, width));

    }

    private static int minSquareLength(int length, int width) {
        if (length == width) {
            return length;
        }

        int minSide = Math.min(length, width);
        int maxSide = Math.max(length, width);
        int leftOver = maxSide % minSide;

        //side the same
        if (leftOver == 0) {
            return minSquareLength(minSide, minSide);
        }
        return minSquareLength(minSide, leftOver);
    }

}

