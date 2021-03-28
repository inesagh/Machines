package com.vendingMachine;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static OuterHashMap outerHashMap = new OuterHashMap();

    public static void main(String[] args) {
        outerHashMap.mapFunction();
        boolean quit = false;

        while(!quit){
            while(true){
                System.out.println("Your order: ");
                String choice = scanner.nextLine();
                try{
                    if(validation(choice)) break;
                }catch (ArrayIndexOutOfBoundsException a){
                    System.out.println("Enter a valid value.");
                }catch (NumberFormatException b){
                    System.out.println("Enter a number.");
                }
            }

            while(true){
                System.out.println("Do you want something else? (y/n)");
                String choice2 = scanner.nextLine();

                if(choice2.equals("n")){
                    quit = true;
                    break;
                }
                else if(choice2.equals("y")){
                    quit = false;
                    break;
                }
            }
        }
    }

    public static CommandM converter(String choice) {
        Types types = null;
        Products products = null;
        String[] arr = choice.split(":");
        String type = arr[0];
        int col = Integer.parseInt(arr[1]);
        int quantity = Integer.parseInt(arr[2]);

        if(type.equals("A"))    types = Types.DRINKS;
        else if(type.equals("B")) types = Types.CHIPSES;
        else types = Types.CHOCOLATE;

        if(col == 1){
            if(types.equals(Types.DRINKS)) products = Products.COCA_COLA;
            else if(types.equals(Types.CHIPSES)) products = Products.LAYS;
            else products = Products.SNICKERS;
        }else if(col == 2){
            if(types.equals(Types.DRINKS)) products = Products.FANTA;
            else if(types.equals(Types.CHIPSES)) products = Products.DORITOS;
            else products = Products.TWIX;
        }else{
            if(types.equals(Types.DRINKS)) products = Products.SPRITE;
            else if(types.equals(Types.CHIPSES)) products = Products.PRINGLES;
            else products = Products.BOUNTY;
        }
        return new CommandM(types, products, quantity);

    }

    public static boolean validation(String choice){
        String[] array = choice.split(":");
        if((array[0].equals("A") || array[0].equals("B") || array[0].equals("C")) && choice.contains(":")){
            CommandM commandM = converter(choice);
            outerHashMap.getProduct(commandM);
            return true;
        }
        return false;
    }

}
