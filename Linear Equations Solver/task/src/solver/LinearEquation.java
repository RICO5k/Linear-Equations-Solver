package solver;

public class LinearEquation {
    Matrix matrix;

    public LinearEquation(Matrix matrix) {
        this.matrix = matrix;
    }

    public double [] solve() {
        System.out.println("Start solving the equation.");

        System.out.println("Rows manipulation:");
        for(int index=0; index<matrix.getN(); index++) {
            int diagonalPos = index;
            changeForOne(diagonalPos);

            for(int rowNumber=0; rowNumber<matrix.getN(); rowNumber++) {
                if(rowNumber == diagonalPos)
                    continue;
                changeForZero(rowNumber, index);
            }
        }

        return matrix.getResults();
    }

    public void changeForOne(int xy) {
        Row rowToModify = matrix.getRow(xy);

        double multiplier = 1 / rowToModify.getNumber(xy);

        Row modifiedRow = Row.multiplyRowBy(rowToModify, multiplier);

        matrix.setRow(xy, modifiedRow);

        System.out.printf("%f * R%d -> R%d\n", multiplier, xy, xy);
    }

    public void changeForZero(int rowNumber, int index) {
        Row diagonalRow = matrix.getRow(index);
        Row rowToModify = matrix.getRow(rowNumber);

        double multiplier = rowToModify.getNumber(index) * -1;
        Row toAdd = Row.multiplyRowBy(diagonalRow, multiplier);
        Row modifiedRow = Row.addRows(rowToModify, toAdd);

        matrix.setRow(rowNumber, modifiedRow);

        System.out.printf("%f * R%d + R%d -> R%d\n", multiplier, index, rowNumber, rowNumber);
    }
}
