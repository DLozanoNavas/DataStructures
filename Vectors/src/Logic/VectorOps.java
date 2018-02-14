/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author dlozanonavas
 */
public class VectorOps {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public void sortArrayAscendent(Integer[] Array1) {
        Arrays.sort(Array1);

    }

    public void sortArrayDescendent(Integer[] Array1) {
        Arrays.sort(Array1, Collections.reverseOrder());
    }

    public int sumArray(Integer[] Array1) {
        int sum = 0;
        for (int i : Array1) {
            sum += i;
        }
        return sum;
    }

    public void multiplyArrays(Integer[] Array1, Integer[] Array2, Integer[] callback) {
        for (int i = 0; i < Array1.length; i++) {
            callback[i] = Array1[i] * Array2[i];
        }
    }

    public void fillArray(Integer[] val) throws IOException {
        for (int i = 0; i < val.length; i++) {
            System.out.printf("Digite el valor del vector en la posición [%d]", i);
            val[i] = Integer.parseInt(input.readLine());
        }
    }

    public void printArray(Integer[] val) {
        for (int i : val) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
