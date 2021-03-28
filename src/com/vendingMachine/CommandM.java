package com.vendingMachine;

public class CommandM extends Object{
    private Types types;
    private Products products;
    private int quantity;

    public CommandM(Types types, Products products, int quantity) {
        this.types = types;
        this.products = products;
        this.quantity = quantity;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
