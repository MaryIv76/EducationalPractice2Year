package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {

        int[][] array = new int[rows][columns];

        int iterations = rows / 2;
        if (rows % 2 == 1) {
            iterations++;
        }

        int k = 1;
        for (int i = 0; i < iterations; i++) {
            for (int j = i; j < columns - i; j++) {
                array[i][j] = k;
                k++;
            }
            for (int j = i + 1; j < rows - i; j++) {
                array[j][columns - i - 1] = k;
                k++;
            }
            for (int j = columns - 2 - i; j >= i; j--) {
                if (i == iterations - 1 && rows % 2 == 1) {
                    break;
                }
                array[rows - 1 - i][j] = k;
                k++;
            }
            for (int j = array.length - 2 - i; j > i; j--) {
                array[j][i] = k;
                k++;
            }
        }

        return array;
    }
}
