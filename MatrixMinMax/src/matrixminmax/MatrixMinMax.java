/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixminmax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import matrixminmax.Logic.MatrixOps;

/**
 *
 * @author dlozanonavas
 */
public class MatrixMinMax {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        while (true) {
            MatrixOps Obj = new MatrixOps();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Digite el número de filas de la matriz: ");
            int aRows = Integer.parseInt(input.readLine());
            System.out.println("Digite el número de columnas de la matriz: ");
            int aColumns = Integer.parseInt(input.readLine());
            
            Obj.setColumns(aColumns);
            Obj.setRows(aRows);
            Obj.initializeMatrix(aRows, aColumns);
            for (int f = 0; f < aRows; f++) {
                for (int c = 0; c < aColumns; c++) {
                    System.out.println("Digite el número para la posición [" + f + "][" + c + "] en la matriz");
                    int val = Integer.parseInt(input.readLine());
                    Obj.setMatrix(f, c, val);
                }
            }
            Obj.postProcessing();
            System.out.println("Numero mayor: " + Obj.getMax());
            System.out.println("Numero menor: " + Obj.getMin());
            System.out.println("Promedio: " + Obj.getAverage());
        }

    }

}
