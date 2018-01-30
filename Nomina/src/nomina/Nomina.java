/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package nomina;

import Logic.Employee;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dlozanonavas
 */
public class Nomina {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */


    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Employee> EmployeeList = new ArrayList<>();
        int LegalMinSalary = 781242;
        int TransportAux = 81211;
        int EmployeeInitialCount = 0;
        float HealthDiscount = (float) 0.04;
        float PensionDiscount = (float) 0.04;

        while (true) {
            System.out.println("1. Inscribir un empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Buscar empleado");
            System.out.println("4. Modificar empleado");
            System.out.println("5. Obtener totales");
            System.out.println("6. Salir");

            int option = Integer.parseInt(input.readLine());
            switch (option) {

                case 1:
                    Employee Employee = new Employee();
                    System.out.println("Digite el nombre del empleado");
                    String EmployeeName = input.readLine();
                    Employee.setName(EmployeeName);

                    System.out.println("Digite el Apellido del empleado");
                    String EmployeeLastName = input.readLine();
                    Employee.setLastName(EmployeeLastName);

                    System.out.println("Digite el cargo del empleado");
                    String EmployeeJobPosition = input.readLine();
                    Employee.setJobPosition(EmployeeJobPosition);

                    System.out.println("Digite el salario básico del empleado");
                    int EmployeeBasicSalary = Integer.parseInt(input.readLine());
                    Employee.setBasicSalary(EmployeeBasicSalary);

                    System.out.println("Digite el número de horas extras trabajadas por el empleado");
                    int EmployeeExtraHours = Integer.parseInt(input.readLine());
                    int EmployeeExtraHoursPayment = EmployeeExtraHours * ((EmployeeBasicSalary / 30) / 4);
                    Employee.setExtraHoursPayment(EmployeeExtraHoursPayment);

                    System.out.println("Digite el valor de las comisiones del empleado");
                    int EmployeeCommissions = Integer.parseInt(input.readLine());
                    Employee.setCommissions(EmployeeCommissions);

                    if (Employee.hasTransportAux(Employee, LegalMinSalary)) {
                        Employee.setTansportAux(TransportAux);
                        int totalAcquired = EmployeeBasicSalary + EmployeeExtraHoursPayment + EmployeeCommissions + TransportAux;
                        Employee.setTotalAcquired(totalAcquired);
                    } else {
                        Employee.setTansportAux(0);
                        int totalAcquired = EmployeeBasicSalary + EmployeeExtraHoursPayment + EmployeeCommissions;
                        Employee.setTotalAcquired(totalAcquired);
                    }

                    int HealthWithdraw = (int) (EmployeeBasicSalary * HealthDiscount);
                    Employee.setHealthWithdraw(HealthWithdraw);

                    int PensionWithdraw = (int) (EmployeeBasicSalary * PensionDiscount);
                    Employee.setPensionWithdraw(PensionWithdraw);

                    EmployeeList.add(Employee);
                    EmployeeInitialCount++;
                    break;

                case 2:
                    /**
                     * Lists All Employees with their respective keys.
                     */
                    Employee ListEmployee = new Employee();
                    for (Employee employee : EmployeeList) {
                        ListEmployee.DisplayEmployee(employee);
                    }
                    break;
                case 3:
                    /**
                     * Search for a query inside every Employee Object
                     * attribute.
                     */
                    Employee SearchEmployee = new Employee();
                    System.out.print("Digite su búsqueda: ");
                    String Query = input.readLine();
                    int Index = SearchEmployee.FindEmployee(EmployeeList, Query);
                    Employee SelectedEmployee = EmployeeList.get(Index);
                    if (Index == -1) {
                        System.out.println("El empleado no existe");
                    } else {
                        SearchEmployee.DisplayEmployee(SelectedEmployee);
                    }
                    break;
                case 4:
                    /**
                     * Modify an Employee
                     */
                    System.out.println("Digite su búsqueda: ");
                    String ModifyQuery = input.readLine();
                    Employee employee = new Employee();
                    int ModifyIndex = employee.FindEmployee(EmployeeList, ModifyQuery);
                    Employee ModifyEmployee = EmployeeList.get(ModifyIndex);
                    
                    if (ModifyIndex == -1) {
                        System.out.println("El empleado no existe");
                    } else {
                        employee.DisplayEmployee(ModifyEmployee);
                        System.out.println("DESEA MODIFICAR ESTE EMPLEADO? \n 1. Sí \n 2. No");
                        int choice = Integer.parseInt(input.readLine());
                        if (choice == 1){
                            ModifyEmployee.ModifyEmployee(ModifyEmployee,ModifyIndex,choice);
                        }else{
                            break;
                        }
                    }

                    break;
                case 5:
                    /**
                     * Get Totals.
                     */
                    Employee TotalsEmployee = new Employee();
                    TotalsEmployee.getTotals(EmployeeList);
                    break;
                case 6:
                    System.exit(0);
                    System.out.println("Bye!");
                    break;
            }
        }
    }

}
