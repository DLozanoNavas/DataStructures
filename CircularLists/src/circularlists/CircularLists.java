/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlists;

import java.util.Scanner;

/**
 *
 * @author dlozanonavas
 */
public class CircularLists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int option;

        CircularList List = new CircularList();
        CircularList c = new CircularList();
        while (true) {
            System.out.print("1. Agregar nodo al inicio.\n2. Borrar nodo al inicio.\n3. Agregar nodo al final.\n4. Obtener total de nodos.\n5. Consultar nodo.\n0. Cerrar.\nYour option: ");
            Scanner input = new Scanner(System.in);
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Ingresa un numero entero positivo para agregar al inicio: ");
                    int Data = input.nextInt();
                    c.addNodeAtStart(Data);
                    c.print();
                    break;
                case 2:
                    c.deleteNodeFromStart();
                    System.out.println("Nodo eliminado del final. ");
                    c.print();
                    break;
                case 3:
                    System.out.print("Ingresa un numero entero positivo para agregar al final: ");
                    int Data3 = input.nextInt();
                    c.addNodeAtEnd(Data3);
                    c.print();
                    break;
                case 4:
                    System.out.println("Tamaño de la lista: " + c.getSize());
                    break;
                case 5:
                    System.out.print("Digite la posición del elemento que desea consultar en la lista: ");
                    int position = input.nextInt();
                    System.out.println("Elemento en la posición " + position + " es igual a: " + c.elementAt(position));
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

}
