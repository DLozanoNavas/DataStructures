/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author dlozanonavas
 */
public class Employee {

    String Name;
    String LastName;
    long Id;
    int WorkedHours;
    int basicHour = 1000;
    int fullPayment;

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setID(long id) {
        this.Id = id;
    }

    public double getID() {
        return this.Id;
    }

    public void setWorkedHours(int h) {
        this.WorkedHours = h;
    }

    public int getWorkedHours() {
        return this.WorkedHours;
    }

    public void calculateBasicPayment() {
        this.fullPayment = (basicHour * 40);

    }

    public void calculateExtraPayment() {
        this.fullPayment += ((this.getWorkedHours() - 40) * (basicHour * 2));
    }

    public void calculateSecondLayerExtraPayment() {
        this.fullPayment += ((this.getWorkedHours() - 47) * (this.basicHour * 3));
    }

    public int getFullPayment() {
        return this.fullPayment;
    }

    public void DisplayEmployee(Employee val) {
        System.out.println("Nombre: " + this.getName() + " " + this.getLastName());
        System.out.println("Horas trabajadas: " + this.getWorkedHours());
        System.out.println("Identificación: " + this.getID());
        System.out.println("Pago Total: " + this.getFullPayment() + "\n");
    }

    public void WriteEmployeeList(ArrayList<Employee> EmployeeList) throws FileNotFoundException, UnsupportedEncodingException {
            try (PrintWriter writer = new PrintWriter("EmployeeList.txt", "UTF-8")) {
                EmployeeList.stream().map((employee) -> {
                    writer.println("Nombre: " + employee.getName() + "" + employee.getLastName());
                    return employee;
                }).map((employee) -> {
                    writer.println("Horas trabajadas: " + employee.getWorkedHours());
                    return employee;
                }).map((employee) -> {
                    writer.println("Identificación: " + employee.getID());
                    return employee;
                }).map((employee) -> {
                    writer.println("Pago Total: " + employee.getFullPayment());
                    return employee;
                }).forEachOrdered((_item) -> {
                    writer.println("");
                });
            }
    }
}
