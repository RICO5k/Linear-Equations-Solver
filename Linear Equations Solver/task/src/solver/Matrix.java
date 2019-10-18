package solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix {
    Row[] matrix;
    int n;

    public Matrix(String fileName){
        initFromFile(fileName);
    }

    private void initFromFile(String fileName) {
        try(Scanner scanner = new Scanner(new File(fileName));) {
            n = scanner.nextInt();
            matrix = new Row[n];

            for (int i = 0; i < n; i++) {
                double[] row = new double[n+1];
                for (int j = 0; j < n + 1; j++) {
                    row[j] = scanner.nextDouble();
                }
                matrix[i] = new Row(row);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int getN() {
        return this.n;
    }

    public Row getRow(int rowNumber) {
        return matrix[rowNumber];
    }

    public void setRow(int rowNumber, Row row) {
        matrix[rowNumber] = row;
    }

    public void printMatrix() {
        for(int i=0; i<n; i++) {
            double[] row = matrix[i].getRow();

            for(int j=0; j<row.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }

    public double[] getResults() {
        double[] results = new double[n];

        for(int i=0; i<matrix.length; i++) {
            int lastIndex = matrix[i].getLength() - 1;
            results[i] = matrix[i].getNumber(lastIndex);
        }

        return results;
    }
}
