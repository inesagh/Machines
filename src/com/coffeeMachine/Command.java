package com.coffeeMachine;

public class Command {
    private DrinkTypes choice;
    private int spoon;

    public DrinkTypes getChoice() {
        return choice;
    }

    public void setChoice(DrinkTypes choice) {
        this.choice = choice;
    }

    public int getSpoon() {
        return spoon;
    }

    public void setSpoon(int spoon) {
        this.spoon = spoon;
    }

    public Command(DrinkTypes choice, int spoon) {
        this.choice = choice;
        this.spoon = spoon;
    }
}
