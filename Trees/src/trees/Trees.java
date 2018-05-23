/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.Scanner;

/**
 *
 * @author dlozanonavas
 */
public class Trees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        while (true) {
            Scanner S = new Scanner(System.in);
            System.out.println("1. Agregar\n2. Imprimir");
            // Create a tree, providing the root node
            Node<Integer> root = new Node<Integer>(0);
            Tree<Integer> tree = new Tree<Integer>(root);
            int option = S.nextInt();
            switch (option) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Digita el valor a ingresar");
                    int value = S.nextInt();
                    Node<Integer> node = new Node<Integer>(value);
                    break;
                case 2:
                    System.out.println("Ruta mas larga en el arbol: " + tree.getLongestPathFromRootToAnyLeaf());
                    System.out.println("Tamano del arbol: " + tree.size());
                    System.out.println("Altura del arbol: " + tree.getHeight());

                    break;
                case 3:
                    System.out.println("Digita un valor para comprobar sus descendientes: ");
                    int v = S.nextInt();
                    Node<Integer> nd = new Node<Integer>(v);
                    System.out.println("Numero de descendientes: " + tree.getNumberOfDescendants(nd));
                    break;
                case 4:
                    System.out.println("Digita un valor para comprobar su existencia en el arbol");
                    int val = S.nextInt();
                    System.out.println(tree.exists(val));
                    break;
                case 5:
                 
                    break;

            }
        }
    }
}
