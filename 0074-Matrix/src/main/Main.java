package main;

import model.Matrix;
import calculator.MatrixCalculator;
import util.Validate;

public class Main {

    public static void main(String[] args) {
        Matrix secondMatrix = new Matrix();
        Matrix firstMatrix = new Matrix();
        while (true) {
            System.out.println("=======Calculator program=======");
            System.out.println("1.Additon Matrix");
            System.out.println("2.Subtracition Matrix");
            System.out.println("3.Multiplication Matrix");
            System.out.println("4.Quit");
            int choiceInput = getChoiceInput();
            switch (choiceInput) {
                case 1:
                    inputAddMatrixAndSubMatrix(firstMatrix, secondMatrix);
                    System.out.println("-------- Result --------");
                    firstMatrix.display();
                    System.out.println("+");
                    secondMatrix.display();
                    int[][] sum = MatrixCalculator.add(
                            firstMatrix.getMatrix(),
                            secondMatrix.getMatrix()
                    );
                    System.out.println("=");
                    MatrixCalculator.displayMatrix(sum);
                    break;
                case 2:
                    inputAddMatrixAndSubMatrix(firstMatrix, secondMatrix);
                    System.out.println("-------- Result --------");
                    firstMatrix.display();

                    System.out.println("-");
                    secondMatrix.display();
                    int[][] subtract = MatrixCalculator.subtract(
                            firstMatrix.getMatrix(),
                            secondMatrix.getMatrix()
                    );
                    System.out.println("=");
                    MatrixCalculator.displayMatrix(subtract);
                    break;

                case 3:
                    inputMultiply(firstMatrix, secondMatrix);
                    System.out.println("-------- Result --------");
                    firstMatrix.display();
                    System.out.println("*");
                    secondMatrix.display();
                    int[][] multiply = MatrixCalculator.multiply(
                            firstMatrix.getMatrix(),
                            secondMatrix.getMatrix()
                    );
                    System.out.println("=");
                    MatrixCalculator.displayMatrix(multiply);
                    break;
                case 4:
                    break;
            }
        }

    }

    /**
     * Choice integer number scanned from the input.
     *
     * @return the valid choice input integer scanned from the input
     */
    private static int getChoiceInput() {
        int choiceInput = Validate.getInt(
                "Choose input: ",
                "Choice out of range 1 - 4",
                "Choice must be positive integer number",
                1, 4);
        if (choiceInput == 4) {
            System.exit(0);
        }
        return choiceInput;
    }

    /**
     * Inputs matrix values for addition and subtraction operations with
     * condition row1 = row2 and col1 = col2
     *
     * @param firstMatrix The first matrix for the operation.
     * @param secondMatrix The second matrix for the operation.
     */
    private static void inputAddMatrixAndSubMatrix(Matrix firstMatrix, Matrix secondMatrix) {
        firstMatrix.create(
                1,
                Integer.MAX_VALUE,
                1,
                Integer.MAX_VALUE,
                1
        );
        firstMatrix.inputValue(1);

        secondMatrix.create(
                firstMatrix.getRow(),
                firstMatrix.getRow(),
                firstMatrix.getCol(),
                firstMatrix.getCol(),
                2
        );
        secondMatrix.inputValue(2);
    }

    /**
     * Inputs matrix values for multiplication operation with condition row2 =
     * col1
     *
     * @param firstMatrix The first matrix for the operation.
     * @param secondMatrix The second matrix for the operation.
     */
    private static void inputMultiply(Matrix firstMatrix, Matrix secondMatrix) {
        firstMatrix.create(
                1,
                Integer.MAX_VALUE,
                1,
                Integer.MAX_VALUE,
                1);
        firstMatrix.inputValue(1);

        secondMatrix.create(
                firstMatrix.getCol(),
                firstMatrix.getCol(),
                1,
                Integer.MAX_VALUE,
                2
        );
        secondMatrix.inputValue(2);
    }

}
