/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author dlozanonavas
 */
public class Ejecutar {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Lista nodo = new Lista();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        
            while (true) {
try {
                float x;
                String n;
                System.out.println("\n1. Insertar nodos a la Lista:2. Borrar el primer nodo de la lista.\n6. Borrar el segundo nodo de la lista.\n7. Borrar el ultimo nodo de la lista.\n8. Borrar el mayor de la lista.\n9. Imprimir.\n10. Salir.\n  ");
                int option = Integer.parseInt(input.readLine());
                switch (option) {
                    case 1:
                        System.out.println("Inserte la identificación");
                        x = Float.parseFloat(in.nextLine());
                        nodo.insertar(x);
                        nodo.imprimir();
                        break;
                    case 2:
                        System.out.println("Borramos el primer nodo de la lista:");
                        nodo.borrarPrimero();
                        nodo.imprimir();
                        break;
                    case 3:
                        System.out.println("Borramos el segundo nodo de la lista:");
                        nodo.borrarSegundo();
                        nodo.imprimir();
                        break;
                    case 4:
                        System.out.println("Borramos el ultimo nodo de la lista:");
                        nodo.borrarUltimo();
                        nodo.imprimir();
                        break;
                    case 5:
                        System.out.println("Borramos el mayor de la lista:");
                        nodo.borrarMayor();
                        nodo.imprimir();
                        break;
                    case 9:
                        nodo.imprimir();
                        break;
                    case 10:
                        System.exit(0);

                }
                } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
            }
        
    }
}
