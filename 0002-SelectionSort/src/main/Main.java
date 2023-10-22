package main;

import logic.SelectionSort;
import util.Validate;

public class Main {

    public static void main(String[] args) {
        int number = Validate.getInt(
                "Enter number of array:",
                "Please enter number in range",
                "The number of elements in the array must be a positive integer",
                1, Integer.MAX_VALUE);
        SelectionSort selectionSort = new SelectionSort(number);
        System.out.print("Unsorted array:");
        selectionSort.printArray();
        selectionSort.selectionSort();
        System.out.print("Sorted array:");
        selectionSort.printArray();
    }

}
