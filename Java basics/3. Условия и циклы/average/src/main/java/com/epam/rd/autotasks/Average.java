package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int number = 0;
        int counter = 0;

        while (true) {
            number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            sum += number;
            counter++;
        }

        int average = sum / counter;
        System.out.println(average);
    }

}