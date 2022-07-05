package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket implements Cloneable {

    private UserStory[] dependsOn;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn = dependsOn;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserStory)) {
            return false;
        }
        UserStory userStory = (UserStory) obj;
        if (this.dependsOn.length != userStory.getDependencies().length) {
            return false;
        }
        for (int i = 0; i < this.dependsOn.length; i++) {
            if (!this.dependsOn[i].equals(userStory.getDependencies()[i])) {
                return false;
            }
        }
        return this.getId() == userStory.getId() && this.getName().equals(userStory.getName()) && this.getEstimate() == userStory.getEstimate();
    }

    public UserStory clone() throws CloneNotSupportedException {
        UserStory newUserStory = (UserStory) super.clone();
        newUserStory.dependsOn = this.getDependencies();
        return newUserStory;
    }

    @Override
    public void complete() {
        boolean notCompleted = false;
        for (UserStory element : dependsOn) {
            if (!element.isCompleted()) {
                notCompleted = true;
                break;
            }
        }
        if (!notCompleted) {
            super.complete();
        }
    }

    public UserStory[] getDependencies() {
        UserStory[] dependsOn = new UserStory[this.dependsOn.length];
        for (int i = 0; i < this.dependsOn.length; i++) {
            try {
                dependsOn[i] = this.dependsOn[i].clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return dependsOn;
    }

    @Override
    public String toString() {
        return "[US " + super.getId() + "] " + super.getName();
    }
}
