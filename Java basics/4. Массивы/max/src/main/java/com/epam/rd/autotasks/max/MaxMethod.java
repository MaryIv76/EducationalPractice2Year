package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {
        int max = values[0];
        for (int element : values) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }
}
