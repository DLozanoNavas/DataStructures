/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Logic.MatrixOps;

/**
 *
 * @author dlozanonavas
 */
public class Matrices {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        do {
            try {
                MatrixOps Obj = new MatrixOps();
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Digite el número de filas de la matriz A: ");
                int aRows = Integer.parseInt(input.readLine());

                System.out.println("Digite el número de filas de la matriz A: ");
                int aColumns = Integer.parseInt(input.readLine());

                System.out.println("Digite el número de filas de la matriz B: ");
                int bRows = Integer.parseInt(input.readLine());

                System.out.println("Digite el número de filas de la matriz B: ");
                int bColumns = Integer.parseInt(input.readLine());

                Obj.setARows(aRows);
                Obj.setAColumns(aColumns);
                Obj.setBRows(bRows);
                Obj.setBColumns(bColumns);
                Obj.initMatrices();

                for (int f = 0; f < aRows; f++) {
                    for (int c = 0; c < aColumns; c++) {
                        System.out.println("Digite el número para la posición [" + f + "][" + c + "] en la matriz A");
                        int val = Integer.parseInt(input.readLine());
                        Obj.setMatrixA(f, c, val);
                    }
                }
                for (int f = 0; f < bRows; f++) {
                    for (int c = 0; c < bColumns; c++) {
                        System.out.println("Digite el número para la posición [" + f + "][" + c + "] en la matriz B");
                        int val = Integer.parseInt(input.readLine());
                        Obj.setMatrixB(f, c, val);
                    }
                }
                Obj.addMatrices();
                Obj.substractMatrices();
                Obj.multiplyMatrices();
                Obj.printResultMatrices();
            } catch (IOException | NumberFormatException error) {
                System.out.println(error.getMessage());
            }
        } while (true);
    }
}
