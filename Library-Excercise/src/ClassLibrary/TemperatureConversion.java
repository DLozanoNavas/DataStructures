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
    double  Farenheit;
    double  Rankin;
    double  Celsius;
    
    
    public void CalculateTemperatures(double Fahrenheit){
        this.Celsius = (Fahrenheit-32)*(5/9);
        this.Rankin = Fahrenheit+460;
        this.Kelvin = this.Celsius+273;
        System.out.println("Temperatura en Fahrenheith: " + Fahrenheit);
        System.out.println("Temperatura en Celsius: " + this.Celsius );
        System.out.println("Temperatura en Rankin: " + this.Rankin );
        System.out.println("Temperatura en Kelvin: " + this.Kelvin ); 
    }
       
}
