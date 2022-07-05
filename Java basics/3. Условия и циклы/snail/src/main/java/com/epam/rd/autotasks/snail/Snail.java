package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int h = in.nextInt();

        if (a >= h) {
            System.out.println("1");
            in.close();
            return;
        }

        int difference = a - b;
        if (difference <= 0) {
            System.out.println("Impossible");
        } else {
            int currentHeight = 0;
            int days = 0;
            while (currentHeight < h) {
                currentHeight += a;
                days++;
                if (currentHeight >= h) {
                    break;
                }
                currentHeight -= b;
            }
            System.out.println(days);
        }

        in.close();
    }
}
