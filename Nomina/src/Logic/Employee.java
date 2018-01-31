/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author dlozanonavas
 */
public class Employee {

    private String Name;
    private String LastName;
    private String JobPosition;
    private int BasicSalary;
    private int TansportAux;
    private int ExtraHoursPayment;
    private int Commissions;
    private int TotalAcquired;
    private int HealthWithdraw;
    private int PensionWithdraw;
    private int PaymentTotal;

    public String getName() {
        return Name;
    }

    public void setName(String val) {
        this.Name = val;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String val) {
        this.LastName = val;
    }

    public String getJobPosition() {
        return JobPosition;
    }

    public void setJobPosition(String val) {
        this.JobPosition = val;
    }

    public int getBasicSalary() {
        return BasicSalary;
    }

    public void setBasicSalary(int val) {
        this.BasicSalary = val;
    }

    public int getTransportAux() {
        return TansportAux;
    }

    public void setTansportAux(int val) {
        this.TansportAux = val;
    }

    public int getExtraHoursPayment() {
        return ExtraHoursPayment;
    }

    public void setExtraHoursPayment(int val) {
        this.ExtraHoursPayment = val;
    }

    public int getCommissions() {
        return Commissions;
    }

    public void setCommissions(int val) {
        this.Commissions = val;
    }

    public int getTotalAcquired() {
        return TotalAcquired;
    }

    public void setTotalAcquired(int val) {
        this.TotalAcquired = val;
    }

    public int getHealthWithdraw() {
        return HealthWithdraw;
    }

    public void setHealthWithdraw(int val) {
        this.HealthWithdraw = val;
    }

    public int getPensionWithdraw() {
        return PensionWithdraw;
    }

    public void setPensionWithdraw(int val) {
        this.PensionWithdraw = val;
    }

    public int getPaymentTotal() {
        return PaymentTotal;
    }

    public void setPaymentTotal(int val) {
        this.PaymentTotal = val;
    }

    public boolean hasTransportAux(Employee val, int basicMinColombianSalary) {
        return val.BasicSalary <= basicMinColombianSalary;
    }

    public int FindEmployee(ArrayList<Employee> EmployeeList, String Query) {
        int EmployeeKey = -1;
        for (int i = 0; i < EmployeeList.size(); i++) {
            if (EmployeeList.get(i).getName().equals(Query)) { EmployeeKey = i; }
        }
        return EmployeeKey;
    }

    public void DisplayEmployee(Employee employee) {

            System.out.println("Nombre: " + employee.getName());
            System.out.println("Apellido: " + employee.getLastName());
            System.out.println("Cargo: " + employee.getJobPosition());
            System.out.println("Salario básico: " + employee.getBasicSalary());
            System.out.println("Pago de horas extra: " + employee.getExtraHoursPayment());
            System.out.println("Auxilio de transporte: " + employee.getTransportAux());
            System.out.println("Descuento de pensión:" + employee.getPensionWithdraw());
            System.out.println("Descuento por salud y seguridad social: " + employee.getHealthWithdraw());
            System.out.println("Total devengado: " + employee.getTotalAcquired());
    }
    
    public void getTotals(ArrayList<Employee> EmployeeList){
        int TotalPayment = 0;
        int TotalHealthRetention = 0;
        int TotalExtraHoursPayment = 0;
        int TotalTransportAuxPayment = 0;
        int TotalPensionRetention = 0;
        int TotalBasicSalary = 0;

        for(Employee current:EmployeeList){
            TotalPayment += current.getTotalAcquired();
            TotalHealthRetention += current.getHealthWithdraw();
            TotalExtraHoursPayment+= current.getExtraHoursPayment();
            TotalPensionRetention += current.getPensionWithdraw();
            TotalTransportAuxPayment += current.getTransportAux();
            TotalBasicSalary += current.getBasicSalary();
        }
        System.out.println("Total pagado: " + TotalPayment);
        System.out.println("Total retención por salud: " + TotalHealthRetention);
        System.out.println("Total retención por pensión: " + TotalPensionRetention);
        System.out.println("Total pagado por horas extras: " + TotalExtraHoursPayment);
        System.out.println("Total pagado por auxilio de transporte: " + TotalTransportAuxPayment);
        System.out.println("Total salarios básicos: " + TotalBasicSalary);
    }
    
    public void ModifyEmployee(ArrayList<Employee> employeeList, int IndexKey, int LegalMinSalary, int TransportAux,float HealthDiscount, float PensionDiscount) throws IOException {
                    Employee employee = employeeList.get(IndexKey);
                    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

                    System.out.println("Digite el nombre del empleado");
                    String EmployeeName = input.readLine();
                    employee.setName(EmployeeName);

                    System.out.println("Digite el Apellido del empleado");
                    String EmployeeLastName = input.readLine();
                    employee.setLastName(EmployeeLastName);

                    System.out.println("Digite el cargo del empleado");
                    String EmployeeJobPosition = input.readLine();
                    employee.setJobPosition(EmployeeJobPosition);

                    System.out.println("Digite el salario básico del empleado");
                    int EmployeeBasicSalary = Integer.parseInt(input.readLine());
                    employee.setBasicSalary(EmployeeBasicSalary);

                    System.out.println("Digite el número de horas extras trabajadas por el empleado");
                    int EmployeeExtraHours = Integer.parseInt(input.readLine());
                    int EmployeeExtraHoursPayment = EmployeeExtraHours * ((EmployeeBasicSalary / 30) / 4);
                    employee.setExtraHoursPayment(EmployeeExtraHoursPayment);

                    System.out.println("Digite el valor de las comisiones del empleado");
                    int EmployeeCommissions = Integer.parseInt(input.readLine());
                    employee.setCommissions(EmployeeCommissions);

                    if (employee.hasTransportAux(employee, LegalMinSalary)) {
                        employee.setTansportAux(TransportAux);
                        int totalAcquired = EmployeeBasicSalary + EmployeeExtraHoursPayment + EmployeeCommissions + TransportAux;
                        employee.setTotalAcquired(totalAcquired);
                    } else {
                        employee.setTansportAux(0);
                        int totalAcquired = EmployeeBasicSalary + EmployeeExtraHoursPayment + EmployeeCommissions;
                        employee.setTotalAcquired(totalAcquired);
                    }

                    int HealthWithdraw = (int) (EmployeeBasicSalary * HealthDiscount);
                    employee.setHealthWithdraw(HealthWithdraw);

                    int PensionWithdraw = (int) (EmployeeBasicSalary * PensionDiscount);
                    employee.setPensionWithdraw(PensionWithdraw);
                    employeeList.remove(IndexKey);
                    employeeList.add(IndexKey, employee);
        
        
    }
}
