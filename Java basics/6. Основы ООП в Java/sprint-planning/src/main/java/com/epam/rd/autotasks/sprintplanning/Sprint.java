package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;

public class Sprint {

    private int capacity;
    private int ticketsLimit;
    private Ticket[] tickets;
    private int counter;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.tickets = new Ticket[ticketsLimit];
    }

    private boolean checkAbilityToAddTicket(Ticket ticket) {
        if (ticket == null || ticket.isCompleted()) {
            return false;
        }
        if (counter == ticketsLimit) {
            return false;
        }
        if (getTotalEstimate() + ticket.getEstimate() > capacity) {
            return false;
        }
        return true;
    }

    public boolean addUserStory(UserStory userStory) {
        if (!checkAbilityToAddTicket(userStory)) {
            return false;
        }
        for (UserStory dependency : userStory.getDependencies()) {
            boolean contains = false;
            for (int i = 0; i < counter; i++) {
                if (tickets[i].equals(dependency)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                return false;
            }
        }
        tickets[counter] = userStory;
        counter++;
        return true;
    }

    public boolean addBug(Bug bugReport) {
        if (!checkAbilityToAddTicket(bugReport)) {
            return false;
        }
        tickets[counter] = bugReport;
        counter++;
        return true;
    }

    public Ticket[] getTickets() {
        Ticket[] tickets = new Ticket[this.counter];
        for (int i = 0; i < this.tickets.length; i++) {
            try {
                if (this.tickets[i] != null) {
                    tickets[i] = this.tickets[i].clone();
                }
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return tickets;
    }

    public int getTotalEstimate() {
        int sum = 0;
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                sum += ticket.getEstimate();
            }
        }
        return sum;
    }
}
