package solver;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix {
    double[][] matrix;
    int n;

    public Matrix(String fileName){
        initFromFile(fileName);
    }

    private void initFromFile(String fileName) {
        try(Scanner scanner = new Scanner(fileName);) {
            n = scanner.nextInt();
            matrix = new double[n][n + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n + 1; j++) {
                    matrix[i][j] = scanner.nextDouble();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }



}
