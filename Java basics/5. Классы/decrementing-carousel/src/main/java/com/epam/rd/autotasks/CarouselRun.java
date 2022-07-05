package com.epam.rd.autotasks;

public class CarouselRun {

    int[] elements;
    int index;
    boolean isFinished;
    int quantity;

    public CarouselRun(int[] elements, int quantity) {
        this.elements = elements;
        this.index = 0;
        this.quantity = quantity;
        this.isFinished = false;
        if (quantity == 0) {
            this.isFinished = true;
        }
    }

    public int next() {
        if (isFinished) {
            return -1;
        }

        int retValue = elements[index];
        elements[index]--;
        int currentIndex = index;

        do {
            if (index == elements.length - 1) {
                index = 0;
            } else {
                index++;
            }
        } while (elements[index] == 0 && index != currentIndex);

        if (index == currentIndex && elements[index] == 0) {
            isFinished = true;
        }

        return retValue;
    }

    public boolean isFinished() {
        return isFinished;
    }

}
