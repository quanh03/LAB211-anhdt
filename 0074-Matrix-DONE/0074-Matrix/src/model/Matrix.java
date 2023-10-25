package model;

import util.Validate;

public class Matrix {

    private int col;
    private int row;
    private int[][] matrix;

    public Matrix() {
    }

    public Matrix(int col, int row, int[][] matrix) {
        this.col = col;
        this.row = row;
        this.matrix = matrix;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Creates a new matrix with the specified number of rows and columns.
     *
     * @param minRow       The minimum number of rows for the matrix.
     * @param maxRow       The maximum number of rows for the matrix.
     * @param minCol       The minimum number of columns for the matrix.
     * @param maxCol       The maximum number of columns for the matrix.
     * @param matrixNumber The identifier for the matrix (e.g., 1 for the first
     * matrix).
     */
    public void create(int minRow, int maxRow, int minCol, int maxCol, int matrixNumber) {
        this.row = Validate.getInt(
                "Enter Row Matrix " + matrixNumber + ":",
                "Numberic value out of range. ",
                "Value of matrix is digit",
                minRow, maxRow
        );
        this.col = Validate.getInt(
                "Enter Column Matrix " + matrixNumber + ":",
                "Numberic value out of range.",
                "Value of matrix is digit",
                minCol, maxCol
        );
        this.matrix = new int[this.row][this.col];
    }

    /**
     * Inputs values for the matrix elements.
     *
     * @param matrixNumber The identifier for the matrix (e.g., 1 for the first
     *                     matrix).
     */
    public void inputValue(int matrixNumber) {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                this.matrix[i][j] = Validate.getInt(
                        "Enter Matrix" + matrixNumber + "[" + (i + 1) + "][" + (j + 1) + "]:",
                        "Numeric value out of range ",
                        "Value of matrix is digit",
                        Integer.MIN_VALUE,
                        Integer.MAX_VALUE
                );
            }
        }
    }

    /**
     * Displays the matrix in the console.
     */
    public void display() {
        for (int[] row : this.matrix) {
            for (int column : row) {
                System.out.print("[" + column + "]");
            }
            System.out.println();
        }

    }

}
