/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dllparcial;

/**
 *
 * @author dlozanonavas
 */
public class Car {

    double Cost;
    String Brand;
    String Plate;
    int Year;
    
    public Car(){
        
    }

    public Car(double Cost, String Brand, String Plate, int Year) {
        this.Cost = Cost;
        this.Brand = Brand;
        this.Plate = Plate;
        this.Year = Year;
    }

    public double getCost() {
        return Cost;
    }

    public String getBrand() {
        return Brand;
    }

    public String getPlate() {
        return Plate;
    }

    public int getYear() {
        return Year;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public void setPlate(String Plate) {
        this.Plate = Plate;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public void printCadr(Car Print) {
        System.out.println("Costo: " + Print.getCost());
        System.out.println("Modelo: " + Print.getYear());
        System.out.println("Placa: " + Print.getPlate());
        System.out.println("Marca: " + Print.getBrand());

    }

}
