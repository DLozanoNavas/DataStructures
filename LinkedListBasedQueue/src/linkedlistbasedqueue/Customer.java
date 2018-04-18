/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistbasedqueue;

/**
 *
 * @author dlozanonavas
 */
public class Customer {
    String Name;
    double ID;
    double Payment;
    int Service;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getID() {
        return ID;
    }

    public void setID(double ID) {
        this.ID = ID;
    }

    public double getPayment() {
        return Payment;
    }

    public void setPayment(double Payment) {
        this.Payment = Payment;
    }

    public int getService() {
        return Service;
    }

    public void setService(int Service) {
        this.Service = Service;
    }
    public void printCustomer(){
        System.out.println("Nombre del cliente: "+ this.getName());
        System.out.println("Servicio pagado: "+ this.getService());
        System.out.println("Pago total: "+ this.getPayment());
        System.out.println("Identificación del cliente: "+ this.getID());
        
    }   
    public void printCustomer(Customer Yo){
        System.out.println("Nombre del cliente: "+ Yo.getName());
        System.out.println("Servicio pagado: "+ Yo.getService());
        System.out.println("Pago total: "+ Yo.getPayment());
        System.out.println("Identificación del cliente: "+ Yo.getID());
        
    }
    
    
}
