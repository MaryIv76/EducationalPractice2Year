package com.epam.rd.autotasks;

public class CarouselRun {

    int[] elements;
    int index;
    boolean isFinished;
    int quantity;
    boolean isDecrementingCarousel = false;
    boolean isHalvingCarousel = false;

    public CarouselRun(int[] elements, int quantity, Object obj) {
        this.elements = elements;
        this.index = 0;
        this.quantity = quantity;
        this.isFinished = false;
        if (quantity == 0) {
            this.isFinished = true;
        }
        if (obj instanceof HalvingCarousel) {
            isHalvingCarousel = true;
        } else if (obj instanceof DecrementingCarousel) {
            isDecrementingCarousel = true;
        }
    }

    public int next() {
        if (isFinished) {
            return -1;
        }

        int retValue = elements[index];

        if (isDecrementingCarousel) {
            elements[index]--;
        } else if (isHalvingCarousel) {
            elements[index] = elements[index] / 2;
        }
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
