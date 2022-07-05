package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".

        Scanner in = new Scanner(System.in);
        int numberPeople = in.nextInt();
        in.nextLine();

        if (numberPeople < 0) {
            System.out.println("Seriously? Why so negative?");
        } else if (numberPeople == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else {

            for (int i = 0; i < numberPeople; i++) {
                String name = in.nextLine();
                System.out.println("Hello, " + name);
            }
        }

        in.close();
    }
}
