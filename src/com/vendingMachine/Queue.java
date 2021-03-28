package com.vendingMachine;

import java.util.Objects;
import java.util.Stack;

public class Queue {
    private Stack<ProductProperties> products = new Stack();
    private ProductProperties productProperties = null;
    private int count = 0;

    public Queue(String name) {
        productProperties = new ProductProperties(name);
        sizeOfQueue();
    }

    public void pushProduct(){
        for (int i = 0; i < 10; i++) {
            products.push(productProperties);
        }
        count++;
    }

    public void popProducts(int n){
        for (int i = 0; i < n; i++) {
            products.pop();
        }
    }

    public int sizeOfQueue(){
        if(count == 0) pushProduct();
        return products.size();
    }

    public Stack<ProductProperties> getProducts() {
        return products;
    }

    public void setProducts(Stack<ProductProperties> products) {
        this.products = products;
    }

    public ProductProperties getProductProperties() {
        return productProperties;
    }

    public void setProductProperties(ProductProperties productProperties) {
        this.productProperties = productProperties;
    }

    @Override
    public String toString() {
        return ("" + sizeOfQueue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue queue = (Queue) o;
        return count == queue.count && Objects.equals(products, queue.products) && Objects.equals(productProperties, queue.productProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, productProperties, count);
    }
}
