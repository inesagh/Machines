package com.vendingMachine;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class OuterHashMap {
    private HashMap<Types, HashMap<Products, Queue>> hashMap= new LinkedHashMap<>();
    private String getYourProduct = "";

    public void mapFunction(){
        for(Types types: Types.values()) {
            HashMap<Products, Queue> nested2 = new LinkedHashMap<>();
            if(types.equals(Types.DRINKS)){
                nested2.put(Products.COCA_COLA, new Queue("Coca Cola"));
                nested2.put(Products.FANTA, new Queue("Fanta"));
                nested2.put(Products.SPRITE, new Queue("Sprite"));
            }else if(types.equals(Types.CHIPSES)){
                nested2.put(Products.LAYS, new Queue("Lays"));
                nested2.put(Products.DORITOS, new Queue("Doritos"));
                nested2.put(Products.PRINGLES, new Queue("Pringles"));
            }else{
                nested2.put(Products.SNICKERS, new Queue("Snickers"));
                nested2.put(Products.TWIX, new Queue("Twix"));
                nested2.put(Products.BOUNTY, new Queue("Bounty"));
            }
            hashMap.put(types, nested2);
        }
    }

    public void getProduct(CommandM command){
        for(Types i: Types.values()){
            if(command.getTypes().equals(i)){
                for(Products products: Products.values()) {
                    if(products.equals(command.getProducts())){
                        if(hashMap.get(i).get(products).sizeOfQueue() >= command.getQuantity()){
                            hashMap.get(i).get(products).popProducts(command.getQuantity());
                            getYourProduct += "Your order is " + command.getQuantity() + " " + hashMap.get(i).get(products).getProductProperties().getName() + ".";
                            System.out.println(getYourProduct);
                        }else{
                            System.out.println("We do not have that much " + hashMap.get(i).get(products).getProductProperties().getName() + ".Please choose another. ");
                        }
                    }

                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OuterHashMap that = (OuterHashMap) o;
        return Objects.equals(hashMap, that.hashMap) && Objects.equals(getYourProduct, that.getYourProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashMap, getYourProduct);
    }

    @Override
    public String toString() {
        return "OuterHashMap{" +
                "hashMap=" + hashMap +
                ", getYourProduct='" + getYourProduct + '\'' +
                '}';
    }
}
