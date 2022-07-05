package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket implements Cloneable{

    private int id;
    private String name;
    private int estimate;
    private boolean isCompleted;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.isCompleted = false;
    }

    public Ticket clone() throws CloneNotSupportedException {
        Ticket newTicket = (Ticket) super.clone();
        return newTicket;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void complete() {
        isCompleted = true;
    }

    public int getEstimate() {
        return this.estimate;
    }
}
