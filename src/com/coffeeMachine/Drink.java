package com.coffeeMachine;

import java.util.Objects;

public class Drink {
    private int spoon;
    private String drinkName;

    public Drink(String drinkName, int spoon) {
        this.spoon = spoon;
        this.drinkName = drinkName;
        yourFinalChoice();
    }

    public void yourFinalChoice(){
        System.out.println("Your final drink: ");
        System.out.println(drinkName + " with " + spoon + " spoon of sugar.");
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return spoon == drink.spoon && Objects.equals(drinkName, drink.drinkName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spoon, drinkName);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "spoon=" + spoon +
                ", drinkName='" + drinkName + '\'' +
                '}';
    }
}
