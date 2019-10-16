package solver;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {

        String fileIn = getParameterFromArgs(args, "-in");
        if(fileIn == null)
            fileIn = "input.txt";

        String fileOut = getParameterFromArgs(args, "-out");
        if(fileOut == null)
            fileOut = "output.txt";

        Matrix matrix = new Matrix(fileIn);
        LinearEquation lEquation = new LinearEquation(matrix);

        double[] unknowns = lEquation.solve();

        printSolution(unknowns);
        writeSolutionToFile(fileOut, unknowns);
    }

    public static void printSolution(double[] solution) {
        System.out.print("The solution is: (");

        for(int i=0; i<solution.length; i++) {
            System.out.print(solution[i]);
            if(i == solution.length-1) {
                System.out.println(")");
            } else {
                System.out.print(", ");
            }
        }
    }

    public static void writeSolutionToFile(String fileName, double[] solution) {
        try(PrintWriter writer = new PrintWriter(fileName)) {
            for (double num: solution) {
                writer.println(num);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("Saved to " + fileName);
    }

    public static String getParameterFromArgs(String[] args, String searched) {
        for(int i=0; i<args.length; i++) {
            if(args[i].equals(searched)) {
                return args[i+1];
            }
        }

        return null;
    }
}
