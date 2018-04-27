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
public class TemperatureConversion {

    double Kelvin;
    double Fahrenheit;
    double Celsius;

    public void Fahrenheit(double fahrenheit) {
        this.Fahrenheit = fahrenheit;
        this.Kelvin = (fahrenheit + 459.67) * 5 / 9;
        this.Celsius = (fahrenheit - 32) * 5 / 9;
        this.print();
    }

    public void Celcius(double celcius) {
        this.Celsius = celcius;
        this.Fahrenheit = celcius * (9 / 5) + 32;
        this.Kelvin = celcius + 273;
        this.print();
    }

    public void Kelvin(double kelvin) {
        this.Kelvin = kelvin;
        this.Celsius = kelvin - 273.15;
        this.Fahrenheit = kelvin * (9 / 5) - 459.67;
        this.print();
    }

    public void print() {
        System.out.println("Temperatura en Fahrenheit: " + this.Fahrenheit);
        System.out.println("Temperatura en Celsius: " + this.Celsius);
        System.out.println("Temperatura en Kelvin: " + this.Kelvin);
    }

}
