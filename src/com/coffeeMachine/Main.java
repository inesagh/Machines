package com.coffeeMachine;


import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while(true){
            System.out.println("Drink type: number of spoon");
            String choice = scanner.nextLine();
            try{
                if(validation(choice)) break;
            }catch (Exception a){
                System.out.println("Enter a valid value.");
            }
        }

    }

    public static Command converter(String choice) {
        String[] arr = choice.split(":");
        DrinkTypes drink = null;
        int sugar = Integer.parseInt(arr[1]);
        if (arr[0].equals("T")) {
            drink = DrinkTypes.TEA;
        } else {
            drink = DrinkTypes.COFFEE;
        }

        Command command = new Command(drink, sugar);
        return command;
    }
    public static boolean validation(String choice){
        String[] array = choice.split(":");
        if((array[0].equals("T") || array[0].equals("C")) && choice.contains(":")){
            Command command = converter(choice);
            CoffeeMaker coffeeMaker = new CoffeeMaker();
            coffeeMaker.makeDrink(command);
            return true;
        }
            return false;
    }
}
