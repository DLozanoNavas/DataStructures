/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlcircularlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author dlozanonavas
 */
public class DLCircularList {

    /**
     * @param args the command line arguments
     */
    public static void main(String a[]) throws IOException {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        DoublyLinkedCircularList List = new DoublyLinkedCircularList();
        while (true) {
            System.out.println("Menú de operaciones con lístas circulare doblemente enlazadas:");
            System.out.println("1. Insertar\n2. Remover\n3. buscar\n4. Imprimir\n0. Cerrar\n");

            int choice; 
            choice = scan.nextInt(); 
            switch (choice) {
                case 1:

                    System.out.print("Ingresa el dato: ");
                    int dataNode = scan.nextInt();

                    Node ND = new Node(dataNode);

                    List.add(ND);				
                    System.out.println();
                    break;
                case 2:

                    if (!List.isEmpty()) 
                    {
                        System.out.println("ingresa el dato a remover");
                        int inp = scan.nextInt();

                        if (List.search(inp) != null) 
                        {
                            System.out.println();
                            System.out.println(List.setCursor(List.remove()) + " ha sido eliminado\n");  
                        } else {
                            System.out.println("\nEl dato: " + input + " no está en la lista\n");  
                        }
                    } else {
                        System.out.println("La lista está vacía\n");  
                    }
                    break;
                case 3:

                    if (!List.isEmpty()) 
                    {
                        System.out.println("Ingresa el dato a buscar");
                        int inpu = scan.nextInt();

                        if (List.search(inpu) != null) 
                        {
                            System.out.println();
                            System.out.println(List.search(inpu) + " ha sido encontrado\n");  
                        } else {
                            System.out.println("\nID: " + input + " is not in the list\n");   
                        }

                    } else {
                        System.out.println("La lista está vacía\n");   
                    }
                    break;
                case 4:

                    if (!List.isEmpty()) 
                    {
                        System.out.println("Elementos de la lista: \n" + List.toString()); 
                    } else {
                        System.out.println("La lista est[a vacía\n"); 
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

        }

    }

}
