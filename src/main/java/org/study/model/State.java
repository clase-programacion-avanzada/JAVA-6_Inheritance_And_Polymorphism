package org.study.model;

public class State {

    private String name;
    private int duration;

    public State(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public void reduceDuration() {
        if (duration > 0) {
            duration--;
        }

        if (duration == 0) {
            name = "Normal";
        }
    }

    public void changeState(String newState, int turns) {
        if (!this.name.equalsIgnoreCase(newState)) {
            this.name = newState;
            this.duration = turns;
        }
    }
    
}
