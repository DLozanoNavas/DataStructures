/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassLibrary;

/**
 *
 * @author dlozanonavas
 */
public class InversionTracking {

    double Capital;
    double Interests;
    double Balance;
    int months;

    public void setCapital(double capital) {
        this.Capital = capital;
    }

    public double getCapital() {
        return this.Capital;
    }

    public void setMonths(int month) {
        this.months = month;
    }

    public int getMonths() {
        return this.months;
    }

    public void setInterests() {
        this.Interests =+((this.getCapital() * 0.2) * this.getMonths());
        
    }
    public void calculateInterests(){

        for (int i =0; i<this.getMonths();i++){
                    this.setInterests();
        this.setBalance();
        System.out.println("\nMonth: " + i);
        System.out.println("Capital: " + this.getCapital());
        System.out.println("Interests: " + this.getInterests());
        System.out.println("Balance: " + this.getBalance() + "\n");
        }
    }

    public double getInterests() {
        return this.Interests;
    }

    public void setBalance() {
        this.Balance = this.getCapital() + (this.getMonths()*this.getInterests());
    }

    double getBalance() {
        return this.Balance;
    }

    public void printBalance() {

    }
}
