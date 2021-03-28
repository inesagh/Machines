package com.coffeeMachine;

public class CoffeeMaker {

    public Drink makeDrink(Command command){
        if(command.getChoice().equals(DrinkTypes.TEA)){
            return new Tea("Tea", command.getSpoon());
        }else {
            return new Coffee("Coffee", command.getSpoon());
        }
    }
}
