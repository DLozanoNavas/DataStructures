/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author dlozanonavas
 */
public class MatrixOps {

    int aRows;
    int aColumns;
    int bRows;
    int bColumns;
    int[][] MatrixA;
    int[][] MatrixB;
    int[][] MatrixAddR;
    int[][] MatrixSubstractR;
    int[][] MatrixMultiplicationR;

    public int getARows() {
        return this.aRows;
    }

    public int getAColumns() {
        return this.aColumns;
    }

    public int getBRows() {
        return this.bRows;
    }

    public int getBColumns() {
        return this.bColumns;
    }

    public void setARows(int val) {
        this.aRows = val;
    }

    public void setAColumns(int val) {
        this.aColumns = val;
    }

    public void setBRows(int val) {
        this.bRows = val;
    }

    public void setBColumns(int val) {
        this.bColumns = val;
    }

    public void initMatrixA() {
        MatrixA = new int[this.aRows][this.aColumns];
    }

    public void setMatrixA(int rows, int columns, int val) {
        MatrixA[rows][columns] = val;
    }

    public void initMatrixB() {
        MatrixB = new int[this.bRows][this.bColumns];
    }

    public void setMatrixB(int rows, int columns, int val) {
        this.MatrixB[rows][columns] = val;
    }

    public void initMatrixAddR() {
        this.MatrixAddR = new int[this.aRows][this.aColumns];
    }

    public void initMatrixSubstractR() {
        this.MatrixSubstractR = new int[this.aRows][this.aColumns];
    }

    public void initMatrixMultiplicationR() {
        this.MatrixMultiplicationR = new int[this.aRows][this.aColumns];
    }

    public void initMatrices() {
        this.initMatrixA();
        this.initMatrixB();
        this.initMatrixAddR();
        this.initMatrixSubstractR();
        this.initMatrixMultiplicationR();
    }

    public void addMatrices() {
        for (int f = 0; f < this.getARows(); f++) {
            for (int c = 0; c < this.getAColumns(); c++) {
                this.MatrixAddR[f][c] = ((this.MatrixA[f][c]) + (this.MatrixB[f][c]));
            }
        }
    }

    public void substractMatrices() {
        for (int f = 0; f < this.getARows(); f++) {
            for (int c = 0; c < this.aColumns; c++) {
                this.MatrixSubstractR[f][c] = this.MatrixA[f][c] - this.MatrixB[f][c];
            }
        }
    }

    public void multiplyMatrices() {
        //TODO Multiplicate and print the Matrices
        if (this.aRows == this.aColumns) {
            for (int i = 0; i < this.aRows; i++) {
                for (int j = 0; j < this.aColumns; j++) {
                    for (int k = 0; k < 1; k++) {
                        this.MatrixMultiplicationR[i][j] += this.MatrixA[i][k] * this.MatrixB[k][j];
                    }
                }
            }
        } else {
            System.out.println("La matriz no puede ser multiplicada.");
        }
    }

    public void printAddedMatrix() {
        //TODO Print addition resulting Matrix
        System.out.println("Resultado de la suma de matrices: ");
        for (int r = 0; r < this.aRows; r++) {
            for (int c = 0; c < this.aColumns; c++) {
                System.out.print(this.MatrixAddR[r][c]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void printSubstractedMatrix() {
        //TODO Print substraction resulting Matrix
        System.out.println("Resultado de la resta de matrices: ");
        for (int rb = 0; rb < this.aRows; rb++) {
            for (int cb = 0; cb < this.aColumns; cb++) {
                System.out.print(this.MatrixSubstractR[rb][cb]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void printMultipliedMatrix() {
        System.out.println("Resultado de la multiplicacion de matrices: ");
        if(this.getAColumns() == this.getBRows()){
        for (int r = 0; r < this.aRows; r++) {
            for (int c = 0; c < this.aColumns; c++) {
                System.out.print(this.MatrixMultiplicationR[r][c]);
                System.out.print(" ");
            }
            System.out.println();
        }
        }else{
            System.out.println("La matriz no puede ser multiplicada. ");
        }
    }

    public void printResultMatrices() {
        this.printAddedMatrix();
        this.printSubstractedMatrix();
        this.printMultipliedMatrix();
    }

}
