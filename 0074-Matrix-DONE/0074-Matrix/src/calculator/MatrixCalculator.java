package calculator;

public class MatrixCalculator {

    /**
     * Adds two matrices element-wise.
     *
     * @param a The first matrix.
     * @param b The second matrix.
     * @return The result of adding the two matrices.
     */
    public static int[][] add(int[][] a, int[][] b) {
        int row = a.length;
        int col = a[0].length;
        int[][] sum = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }

    /**
     * Subtracts one matrix from another element-wise.
     *
     * @param a The matrix from which to subtract.
     * @param b The matrix to subtract.
     * @return The result of subtracting the second matrix from the first
     * matrix.
     */
    public static int[][] subtract(int[][] a, int[][] b) {
        int row = a.length;
        int col = a[0].length;
        int[][] subtract = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                subtract[i][j] = a[i][j] - b[i][j];
            }
        }
        return subtract;
    }

    /**
     * Multiplies two matrices.
     *
     * @param a The first matrix.
     * @param b The second matrix.
     * @return The result of multiplying the two matrices.
     */
    public static int[][] multiply(int[][] a, int[][] b) {
        int rowA = a.length;
        int colA = a[0].length;
        int colB = b[0].length;
        int[][] multiply = new int[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                int sum = 0;
                for (int k = 0; k < colA; k++) {
                    sum += a[i][k] * b[k][j];
                }
                multiply[i][j] = sum;
            }
        }
        return multiply;
    }

    /**
     * Displays a matrix in the console.
     *
     * @param a The matrix to be displayed.
     */
    public static void displayMatrix(int[][] a) {
        for (int[] row : a) {
            for (int j = 0; j < row.length; j++) {
                System.out.print("[" + row[j] + "]");
            }
            System.out.println();
        }
    }

}
