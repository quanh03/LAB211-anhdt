package logic;

import java.util.ArrayList;
import java.util.Random;

public class LinearSearch {

    private int array[];

    /**
     * This method creates a random array of the specified size.
     *
     * @param arraySize The size of the array to generate.
     */
    public void generate(int arraySize) {
        Random rand = new Random();
        array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = rand.nextInt(arraySize);
        }
    }

    /**
     * This method returns the array in a formatted string.
     *
     * @return The array represented as a formatted string.
     */
    public String displayArray() {
        String str = " [";
        for (int i = 0; i < array.length; i++) {
            str = str + array[i];
            if (i < array.length - 1) {
                str = str + ", ";
            } else {
                str = str + "]";
            }
        }
        return str;
    }

    /**
     * This method displays the indices of the specified key in the array on the
     * screen.
     *
     * @param messInfor       The message used to notify users about the values 
     *                        of the key they are looking for.
     * @param messageNotFound The message used to display when the key is not found.
     * @param list            The list of indices where the key was found.
     */
    public void displayIndex(
            String messInfor,
            String messageNotFound,
            ArrayList<Integer> list
    ) {
        if (list.isEmpty()) {
            System.out.println(messageNotFound);
        } else {
            System.out.println(messInfor);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i < list.size() - 1) {
                    System.out.print(", ");
                }
            }
        }

    }

    /**
     * This method uses a linear search to find and store the indices of the
     * specified key in the array.
     *
     * @param key The value to be searched for.
     * @return An ArrayList containing the indices of the key, or an empty list
     * if the key is not found.
     */
    public ArrayList<Integer> linearSearch(int key) {
        ArrayList<Integer> list = new ArrayList<>();
        int size = array.length;
        for (int i = 0; i < size; i++) {
            if (array[i] == key) {
                list.add(i);
            }
        }
        return list;
    }

}
