package util;

import constant.IConstant;
import exception.PhoneNumberMaxLengthException;

import java.util.Scanner;

public class Validate {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Don't let anyone instantiate this class.
     */
    private Validate() {
    }

    /**
     * Returns the valid string phone number scanned from the input.
     *
     * @param messageInfo           the message to be printed instructing the user to input
     * @param messageErrorInvalid   the message will be printed if the String does not contain a parsable integer
     * @param messageErrorMaxlength the message will be printed if the String does not satisfy the maximum length
     * @param REGEX                 the pattern to test String is valid or not
     * @return the valid string phone number scanned from the input
     * @throws NumberFormatException         if the String does not contain a parsable int
     * @throws PhoneNumberMaxLengthException if the String does not satisfy the maximum length
     */
    public static String getPhoneNumber(
            String messageInfo,
            String messageErrorInvalid,
            String messageErrorMaxlength,
            final String REGEX
    ) throws NumberFormatException, PhoneNumberMaxLengthException {

        System.out.print(messageInfo);
        String str = SCANNER.nextLine();

        if (str.matches(REGEX)) {
            if (str.length() == IConstant.PHONE_NUMBER_LENGTH) {
                return str;
            } else {
                throw new PhoneNumberMaxLengthException(messageErrorMaxlength);
            }
        } else {
            throw new NumberFormatException(messageErrorInvalid);
        }
    }

    /**
     * Returns the valid string scanned from the input.
     *
     * @param messageInfo  the message to be printed instructing the user to input
     * @param messageError the message will be printed if the input does not match the regular expression
     * @param REGEX        the pattern to test String is valid or not
     * @return the valid string value
     */
    public static String getString(String messageInfo, String messageError, final String REGEX) {
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