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
    double Interes=0.02;
    double Balance=0f;
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

    public void setInterests(double interest) {
        this.Interes= interest;

    }

    public void calculateInterests() {

        for (int i = 0; i < this.getMonths(); i++) {
            this.setBalance();
            System.out.println("\nMonth: " + i);
            this.printBalance();
        }
    }

    public double getInteres() {
        return this.Interes;
    }

    public void setBalance() {
        this.Balance += (this.getCapital()*this.getInteres()) * (this.getMonths());
    }

    double getBalance() {
        return this.Balance;
    }

    public void printBalance() {
        System.out.println("Capital: " + this.getCapital());
        System.out.println("Interests: " + this.getInteres());
        System.out.println("Balance: " + this.getBalance() + "\n");
    }
}
