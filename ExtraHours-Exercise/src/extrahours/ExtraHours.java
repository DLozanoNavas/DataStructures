/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extrahours;

import java.util.*;
import Logic.Employee;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author dlozanonavas
 */
public class ExtraHours {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ArrayList<Employee> EmployeeList = new ArrayList();
        while (true) {
            Employee employee = new Employee();
            String Name;
            String LastName;
            long Id;
            int WorkedHours;
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("Digite el nombre del empleado: ");
                Name = input.nextLine();
                System.out.println("Digite el apellido del empleado: ");
                LastName = input.nextLine();
                System.out.println("Digite el numero de horas trabajadas: ");
                WorkedHours = Integer.parseInt(input.nextLine());
                System.out.println("Digite el numero de identificación del empleado: ");
                Id = Integer.parseInt(input.nextLine());
                employee.setName(Name);
                employee.setLastName(LastName);
                employee.setWorkedHours(WorkedHours);
                employee.setID(Id);
                employee.calculateBasicPayment();
                employee.calculateExtraPayment();
                if (WorkedHours >= 48) {
                    employee.calculateSecondLayerExtraPayment();
                }
                employee.DisplayEmployee(employee);
                EmployeeList.add(employee);
                employee.WriteEmployeeList(EmployeeList);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
