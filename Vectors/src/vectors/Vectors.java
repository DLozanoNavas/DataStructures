/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Logic.VectorOps;

/**
 *
 * @author dlozanonavas
 */
public class Vectors {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            VectorOps Obj = new VectorOps();
            Integer[] Array1 = new Integer[10];
            Integer[] Array2 = new Integer[10];
            Integer[] callback = new Integer[10];
            try {
                int option;
                System.out.println("1. Sumatoria de un vector. \n2. Multiplicación de dos vectores.\n3. Ordenar vectores\n4. Salir");
                option = Integer.parseInt(input.readLine());
                switch (option) {
                    case 1:
                        Obj.fillArray(Array1);
                        int sum = Obj.sumArray(Array1);
                        Obj.printArray(Array1);
                        System.out.println("Sumatoria: " + sum);
                        break;
                    case 2:
                        System.out.println("Digite 10 números enteros para el vector A");
                        Obj.fillArray(Array1);
                        System.out.println("Digite 10 números enteros para el vector B");
                        Obj.fillArray(Array2);
                        Obj.multiplyArrays(Array1, Array2, callback);
                        System.out.println("El resultado de la multiplicación de ambos vectores es: ");
                        Obj.printArray(callback);
                        break;
                    case 3:
                        Obj.fillArray(Array1);
                        Obj.sortArrayAscendent(Array1);
                        System.out.print("Vector Ascendente: ");
                        Obj.printArray(Array1);
                        Obj.sortArrayDescendent(Array1);
                        System.out.print("Vector descendente: ");
                        Obj.printArray(Array1);
                        break;
                    case 4:
                        System.exit(0);
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
