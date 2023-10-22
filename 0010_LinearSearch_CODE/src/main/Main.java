package main;

import java.util.ArrayList;
import logic.LinearSearch;
import util.Validate;

public class Main {

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        int number = Validate.getInt(
                "Enter number of array:",
                "Error range(number>0)",
                "Must enter digit > 0",
                1, Integer.MAX_VALUE);
        linearSearch.generate(number);

        System.out.print("The array: ");
        System.out.println(linearSearch.displayArray());
        int key = Validate.getInt(
                "Enter search value:",
                "Error range",
                "Invalid",
                Integer.MIN_VALUE,
                Integer.MAX_VALUE);
        ArrayList<Integer> searchResult = linearSearch.linearSearch(key);
        linearSearch.displayIndex(
                "Found " + key + " at index: ",
                "Not found key!", searchResult);

    }
}
