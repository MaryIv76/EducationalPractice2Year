package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {

        int k = 0;
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                if (array[i] <= array[i + 1]) {
                    newArray[k] = array[i];
                    k++;
                }
            } else if (i == array.length - 1) {
                if (array[i] <= array[i - 1]) {
                    newArray[k] = array[i];
                    k++;
                }
            } else {
                if (array[i] <= array[i - 1] || array[i] <= array[i + 1]) {
                    newArray[k] = array[i];
                    k++;
                }
            }
        }

        int[] resultArray = Arrays.copyOf(newArray, k);
        return resultArray;
    }
}
