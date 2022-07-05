package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {

        if (array.length == 0 || array.length == 1) {
            return;
        }

        int[] tempArray = Arrays.copyOf(array, array.length - 1);
        array[0] = array[array.length - 1];
        System.arraycopy(tempArray, 0, array, 1, tempArray.length);

    }

    static void cycleSwap(int[] array, int shift) {

        if (array.length == 0 || array.length == 1 || shift % array.length == 0) {
            return;
        }

        int[] tempArrayToEnd = Arrays.copyOf(array, array.length - shift);
        int[] tempArrayToStart = Arrays.copyOfRange(array, array.length - shift, array.length);
        System.arraycopy(tempArrayToStart, 0, array, 0, tempArrayToStart.length);
        System.arraycopy(tempArrayToEnd, 0, array, tempArrayToStart.length, tempArrayToEnd.length);
    }
}
