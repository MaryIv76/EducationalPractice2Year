package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder

        Scanner in = new Scanner(System.in);
        int numberPeople = in.nextInt();
        int numberPieces = in.nextInt();

        int a = numberPeople;
        int b = numberPieces;

        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        int nod = a + b;
        int nok = numberPeople * numberPieces / nod;
        int numberPizza = nok / numberPieces;
        System.out.println(numberPizza);
    }
}
