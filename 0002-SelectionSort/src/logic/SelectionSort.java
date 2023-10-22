package logic;

import java.util.Random;

public class SelectionSort {

    private int array[];

    /**
     * This construct a random array.
     *
     * @param number -length of array
     */
    public SelectionSort(int number) {
        array = new int[number];
        generateRandomArray();
    }

    private void generateRandomArray() {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(array.length);
        }
    }

    /**
     * This method is used to display Arrays on the screen.
     */
    public void printArray() {
        System.out.print(" [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("]");
            }
        }
        System.out.println("");
    }

    public void selectionSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }
}
