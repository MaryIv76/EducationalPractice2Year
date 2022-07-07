package com.epam.rd.autotasks;

import java.util.ArrayList;

public class TaskCarousel {

    private int capacity;
    private ArrayList<Task> tasks;
    private int currentIndex;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new ArrayList<Task>();
        this.currentIndex = 0;
    }

    public boolean addTask(Task task) {
        if (task == null || task.isFinished() || this.isFull()) {
            return false;
        }

        tasks.add(task);
        return true;
    }

    public boolean execute() {
        if (!this.isEmpty()) {
            boolean wasRemoved = false;
            tasks.get(currentIndex).execute();
            if (tasks.get(currentIndex).isFinished()) {
                tasks.remove(currentIndex);
                wasRemoved = true;
            }

            if (wasRemoved) {
                if (currentIndex == tasks.size()) {
                    currentIndex = 0;
                }
            } else {
                if (currentIndex == tasks.size() - 1) {
                    currentIndex = 0;
                } else {
                    currentIndex++;
                }
            }

            return true;
        }
        return false;
    }

    public boolean isFull() {
        return capacity == tasks.size();
    }

    public boolean isEmpty() {
        return tasks.size() == 0;
    }

}
