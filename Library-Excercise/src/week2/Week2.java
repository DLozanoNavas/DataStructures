/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

import java.io.*;
import java.util.*;
import ClassLibrary.*;


/**
 *
 * @author dlozanonavas
 */
public class Week2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.print("Digite la opcion: \n1. Calcular temperaturas desde Fahrenheit.\n2. Ejercicio de calificaciones.\n3. Ejercicio de Iteración o Ciclos Repetitivos\n Your option: ");
        int option = Integer.parseInt(input.nextLine());
        switch (option) {
            case 1:
                System.out.print("Digite la temperatura en grados Fahrenheit: ");
                double Fahrenheit = Double.parseDouble(input.nextLine());
                TemperatureConversion Input = new TemperatureConversion();
                Input.CalculateTemperatures(Fahrenheit);
                // TODO: Implement sequence exercise
                break;
            case 2:
                //TODO: Califications exercise
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
                        System.out.println("Exception catched, finishing");
                    }
                }
                break;
            case 3:
                InversionTracking Obj = new InversionTracking();
                System.out.print("Capital: ");
                double capital = Double.parseDouble(input.nextLine());
                Obj.setCapital(capital);
                System.out.print("Months: ");
                int months = Integer.parseInt(input.nextLine());
                Obj.setMonths(months);
                Obj.calculateInterests();
                

                break;
            case 4:
                System.exit(0);
        }
    }
}
