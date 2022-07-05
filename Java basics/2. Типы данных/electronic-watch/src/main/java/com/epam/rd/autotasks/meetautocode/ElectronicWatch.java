package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();

        int secondsAnswer = seconds % 60;
        seconds -= secondsAnswer;

        int minutes = (seconds / 60) % 60;
        seconds -= minutes * 60;

        int hours = (seconds / 3600) % 24;

        System.out.printf("%d:%02d:%02d", hours, minutes, secondsAnswer);

        scanner.close();
    }
}
