package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int numberFriends = in.nextInt();

        if (sum < 0) {
            System.out.println("Bill total amount cannot be negative");
        } else if (numberFriends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            double totalSum = 1.1 * sum;
            double sumForAPerson = totalSum / numberFriends;
            System.out.println((int)sumForAPerson);
        }

        in.close();
    }
}
