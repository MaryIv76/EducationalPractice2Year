package com.epam.rd.autotasks;

public class CarouselRun {

    int[] elements;
    int index = 0;
    boolean isFinished = false;
    int quantity;
    boolean isDecrementingCarousel = false;
    boolean isDecrementingCarouselWithLimitedRun = false;
    int actionLimit;

    public CarouselRun(int[] elements, int quantity, Object obj) {
        this.elements = elements;
        this.quantity = quantity;
        if (quantity == 0) {
            this.isFinished = true;
        }
        if (obj instanceof DecrementingCarouselWithLimitedRun) {
            isDecrementingCarouselWithLimitedRun = true;
        } else if (obj instanceof DecrementingCarousel) {
            isDecrementingCarousel = true;
        }
    }

    public CarouselRun(int[] elements, int quantity, Object obj, int actionLimit) {
        this.elements = elements;
        this.quantity = quantity;
        if (quantity == 0) {
            this.isFinished = true;
        }
        if (obj instanceof DecrementingCarouselWithLimitedRun) {
            isDecrementingCarouselWithLimitedRun = true;
        } else if (obj instanceof DecrementingCarousel) {
            isDecrementingCarousel = true;
        }
        this.actionLimit = actionLimit;
    }

    public int next() {
        if (isFinished) {
            return -1;
        }

        int retValue = elements[index];

        if (isDecrementingCarousel) {
            elements[index]--;
        } else if (isDecrementingCarouselWithLimitedRun) {
            elements[index]--;
            actionLimit--;
            if (actionLimit == 0) {
                isFinished = true;
                return retValue;
            }
        }
        int currentIndex = index;

        do {
            if (index == elements.length - 1) {
                index = 0;
            } else {
                index++;
            }
        } while (elements[index] <= 0 && index != currentIndex);

        if (index == currentIndex && elements[index] <= 0) {
            isFinished = true;
        }

        return retValue;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
