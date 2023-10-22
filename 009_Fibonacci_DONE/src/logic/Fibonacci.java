package logic;

public class Fibonacci {

    /**
     * Calculate Fibonacci sequence by using Recursive Algorithm
     *
     * @param number acts as the number of elements remaining after each
     * recursion
     * @param lower the previous number in the sequence
     * @param higher the following number in sequence return
     * @return the recursion of method until size less than
     */
    public static long calculateSequence(int number, long lower, long higher) {
        if (number < 1) {
            return lower;
        }
        return calculateSequence(number - 1, higher, lower + higher);
    }

    /**
     * Print out the sequence of 45 Fibonacci numbers
     *
     * @param number The number of Fibonacci sequence numbers to print
     */
    public static void print(int number) {
        for (int i = 0; i < number; i++) {
            long fib = calculateSequence(i, 0, 1);

            if (i < number - 1) {
                System.out.print(fib + ", ");
            } else {
                System.out.print(fib + " ");
            }

        }
    }
}
