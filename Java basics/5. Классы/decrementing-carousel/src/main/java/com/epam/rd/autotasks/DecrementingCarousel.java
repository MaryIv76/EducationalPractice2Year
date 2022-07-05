package com.epam.rd.autotasks;

public class DecrementingCarousel {

    int capacity;
    int[] elements;
    int counter;
    boolean isRun;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
        this.counter = 0;
        this.isRun = false;
    }

    public boolean addElement(int element) {
        if (element <= 0 || counter == capacity || isRun) {
            return false;
        }

        elements[counter] = element;
        counter++;
        return true;
    }

    public CarouselRun run() {
        if (isRun) {
            return null;
        }
        isRun = true;
        return new CarouselRun(elements, counter);
    }
}
