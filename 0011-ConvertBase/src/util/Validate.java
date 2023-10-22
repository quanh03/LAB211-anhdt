
package util;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Validate {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Validate() {
    }

    /**
     * Returns the valid integer value scanned from the input.
     *
     * @param messageInfo               the message to be printed instructing 
     *                                  the user to input
     * @param messageErrorOutOfRange    the message will be printed if the 
     *                                  String parse value is out of range
     * @param messageErrorInvalidNumber the message will be printed if the
     *                                  String does not contain a parsable 
     *                                  integer
     * @param min                       minimum limit value
     * @param max                       maximum limit value
     * @return the valid integer value scanned from the input
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max
    ) throws NumberFormatException {
        while (true) {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (min <= number && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        }
    }

    /**
     * Return the valid string scanned from the input.
     *
     * @param messageInfo  the message to be printed instructing the user to
     *                     input
     * @param messageError the message will be printed if the input does not
     *                     match the regular expression
     * @param REGEX        the pattern to test String is valid or not
     * @return the valid string value
     */
    public static String getString(
            String messageInfo,
            String messageError,
            final String REGEX) {
        do {
            System.out.print(messageInfo);
            String str = SCANNER.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }
}
