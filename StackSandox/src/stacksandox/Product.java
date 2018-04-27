/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandox;

/**
 *
 * @author dlozanonavas
 */
public class Product {
    private String name;
    private int cod;
    private int stock;
    public void print(){
        System.out.println("\nNombre del producto: "+name+"\nCodigo del producto "+cod+"\nStock del producto: "+stock);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Product(String name, int cod, int stock) {
        this.name = name;
        this.cod = cod;
        this.stock = stock;
    }
    
}
