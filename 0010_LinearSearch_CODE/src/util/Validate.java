package util;

import java.util.Scanner;

public class Validate {

    private Validate() {
    }

    /**
     * Displays a prompt to the user, validates the input
     *
     * @param messageInfo               the message to be printed instructing 
     *                                  the user to  input
     * @param messageErrorOutOfRange    the message to be printed if the String
     *                                  parse value is out of range
     * @param messageErrorInvalidNumber the message to be printed if the String
     *                                  does not contain a parable integer
     * @param min                       minimum Limit value
     * @param max                       maximum Limit value
     * @return the valid integer value scanned from the input
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println(messageInfo);
                int number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
}
