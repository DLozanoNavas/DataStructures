/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import java.io.*;
import java.util.*;
import ClassLibrary.*;

/**
 *
 * @author dlozanonavas
 */
public class Utils {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Digite la opcion: \n1. Calcular temperaturas desde Fahrenheit.\n2. Ejercicio de calificaciones de estudianres.\n3. Ejercicio de Iteración o Ciclos Repetitivos\n Su opción: ");
            TemperatureConversion T = new TemperatureConversion();
            int option = input.nextInt();
            switch (option) {
                case 1:
                    boolean inloop = true;
                    while (inloop) {
                        System.out.print("Seleccione el tipo de temperatura que desea convertir:\n1. Fahrenheit\n2. Celcius\n3. Kelvin \n4. Volver ");
                        int TemperatureOption = input.nextInt();
                        switch (TemperatureOption) {
                            case 1:
                                System.out.print("Digite la temperatura en grados Fahrenheit: ");
                                double Fahrenheit = input.nextDouble();
                                T.Fahrenheit(Fahrenheit);
                                break;
                            case 2:
                                System.out.print("Digite la temperatura en grados Celcius: ");
                                double Celsius = input.nextDouble();
                                T.Celcius(Celsius);
                                break;
                            case 3:
                                System.out.print("Digite la temperatura en grados Kelvin: ");
                                double Kelvin = input.nextDouble();
                                T.Kelvin(Kelvin);
                                break;
                            case 4:
                                inloop = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean KeepAdding = true;
                    while (KeepAdding) {
                        try {
                            StudentGrades CurrentStudent = new StudentGrades();
                            System.out.print("First grade ");
                            double grade1 = Double.parseDouble(input.nextLine());
                            System.out.print("Second grade: ");
                            double grade2 = Double.parseDouble(input.nextLine());
                            System.out.print("Third grade: ");
                            double grade3 = Double.parseDouble(input.nextLine());
                            CurrentStudent.setGrades(grade1, grade2, grade3);
                            System.out.println("Student Name:");
                            String Name = input.nextLine();
                            CurrentStudent.setName(Name);
                            System.out.println("Add annotations for this student? (Y/N):");
                            char AnnotationsInput = input.nextLine().charAt(0);
                            if (AnnotationsInput == 'Y' || AnnotationsInput == 'y') {
                                System.out.print("Annotation:");
                                String Annotations = input.nextLine();
                                CurrentStudent.setAnnotations(Annotations);
                            }
                            System.out.println("Print last student? (Y/N):");
                            char PrintInput = input.nextLine().charAt(0);
                            if (PrintInput == 'Y' || PrintInput == 'y') {
                                CurrentStudent.display();
                                System.out.println(CurrentStudent.getAnnotations());
                            }
                            System.out.println("Keep adding students? (Y/N):");
                            char KeepAddingInput = input.nextLine().charAt(0);
                            if (KeepAddingInput == 'Y' || KeepAddingInput == 'y') {
                                KeepAdding = true;
                            } else {
                                KeepAdding = false;
                            }
                            // Print Students
                        } catch (NumberFormatException ex) {
                            System.out.print(ex.getMessage());
                            System.out.println("Exception catched, retry.");
                        }
                    }
                    break;
                case 3:
                    InversionTracking Obj = new InversionTracking();
                    System.out.print("Capital: ");
                    double capital = input.nextDouble();
                    Obj.setCapital(capital);
                    System.out.print("Months: ");
                    int months = input.nextInt();
                    Obj.setMonths(months);
                    Obj.calculateInterests();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
