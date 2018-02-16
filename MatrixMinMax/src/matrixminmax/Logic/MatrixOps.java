/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixminmax.Logic;

/**
 *
 * @author dlozanonavas
 */
public class MatrixOps {

    int[][] Matrix;
    int Min = 1000000;
    int Max;
    int Rows;
    int Columns;
    int sum = 0;
    double Average;

    public void setRows(int val) {
        this.Rows = val;
    }

    public void setColumns(int val) {
        this.Columns = val;
    }

    public int getRows() {
        return this.Rows;
    }

    public int getColumns() {
        return this.Columns;
    }

    public int[][] getMatrix() {
        return this.Matrix;
    }

    public void setMatrix(int rows, int columns, int val) {
        Matrix[rows][columns] = val;
    }

    public void initializeMatrix(int rows, int columns) {
        this.Matrix = new int[rows][columns];
    }

    public int getMax() {
        return this.Max;
    }

    public int getMin() {
        return this.Min;
    }

    public void setMax() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (this.Matrix[i][j] > this.getMax()) {
                    this.Max = this.Matrix[i][j];
                }
            }
        }

    }

    public void setMin() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (this.Matrix[i][j] < this.getMin()) {
                    this.Min = this.Matrix[i][j];
                }
            }
        }
    }

    public void printMatrix() {
        System.out.println("Matriz: \n----------------------------------------");
        for (int r = 0; r < this.getRows(); r++) {
            for (int c = 0; c < this.getColumns(); c++) {
                System.out.print(this.Matrix[r][c]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void setAverage() {
        this.Average = this.sum / (this.getRows() * this.getColumns());
    }

    public double getAverage() {
        return this.Average;
    }

    public int sumMatrix() {
        for (int f = 0; f < this.getRows(); f++) {
            for (int c = 0; c < this.getColumns(); c++) {
                this.sum += this.Matrix[f][c];
            }
        }
        return this.sum;
    }
    public void postProcessing(){
                    this.setMax();
            this.setMin();
            this.sumMatrix();
            this.setAverage();
            this.printMatrix();
    }
}
