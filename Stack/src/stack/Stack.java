/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.Scanner;

/**
 *
 * @author dlozanonavas
 */
public class Stack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        LinkedListBasedStack Stack = new LinkedListBasedStack();

        while (true) {
            System.out.println("1. Agregar estudiante.\n2. Expulsar estudiante.\n3. Imrimir estado del stack.\n4. Imprimir stack.\n0. Salir.");
            int option = scan.nextInt();
            switch (option) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    //TODO Push
                    Student student = new Student();
                    System.out.println("Digite el nombre del estudiante.");
                    String name = scan.next();
                    System.out.println("Digite el codigo del estudiante.");
                    int Code = scan.nextInt();
                    student.setCode(Code);
                    student.setName(name);
                    Stack.push(student);
                    
                    break;
                case 2:
                    //TODO Pop
                    Student popped = Stack.pop();
                    System.out.println("Estudiante sacado del Stack: "+popped.getName());
                    break;
                case 3:
                    //TODO Print
                    System.out.println("Tamaño del Stack: "+ Stack.size());
                    break;
                case 4:
                    Stack.Print();

            }
        }
    }

}
