package main;

import entity.Binary;
import entity.Decimal;
import entity.Hexadecimal;
import constant.IConstant;
import util.Validate;

/**
 *
 * @author user
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("====================");
            System.out.println("1.Binary base");
            System.out.println("2.Decimal base");
            System.out.println("3.Hexadecimal base");
            System.out.println("4.Exit");
            System.out.println("====================");
            int choiceInput = getChoiceInput();
            String number = getNumberBase(choiceInput);
            int choiceOutput;
            while (true) {
                choiceOutput = getChoiceOutput(choiceInput);
                if (choiceInput == choiceOutput) {
                    System.out.println();
                    System.out.println(
                        "Please enter another base with number's original base"
                    );
                    System.out.println("Try again!");
                    System.out.println();
                } else {
                    break;
                }
            }
            String numberConvert = "";
            switch (choiceInput) {
                case 1: {
                    switch (choiceOutput) {
                        case 2:
                            numberConvert = Binary.toDecimal(number);
                            break;
                        case 3:
                            numberConvert = Binary.toHexa(number);
                            break;
                    }
                    break;
                }
                case 2: {
                    switch (choiceOutput) {
                        case 1:
                            numberConvert = Decimal.toBinary(number);
                            break;
                        case 3:
                            numberConvert = Decimal.toHexa(number);
                            break;
                    }
                    break;
                }
                case 3: {
                    switch (choiceOutput) {
                        case 1:
                            numberConvert = Hexadecimal.toBinary(number);
                            break;
                        case 2:
                            numberConvert = Hexadecimal.toDecimal(number);
                            break;
                    }
                    break;
                }
            }
            displayAfterConvert(numberConvert, choiceInput);
        }
    }

    /**
     * Choice integer number scanned from the input.
     *
     * @return the valid choice input integer scanned from the input
     */
    public static int getChoiceInput() {
        int choiceInput = Validate.getInt(
                "Choose input: ",
                "Choice out of range 1 - 4",
                "Choice must be positive integer number",
                1, 4);
        if (choiceInput == 4) {
            System.exit(0);
        }
        return choiceInput;
    }

    /**
     * The valid value scanned from the input.
     *
     * @param choiceInput choice of user
     * @return the valid value scanned from the input
     */
    public static String getNumberBase(int choiceInput) {
        String number = "";
        switch (choiceInput) {
            case 1:
                number = Validate.getString("Please enter number: ",
                        "Must input number 0 and 1",
                        IConstant.REGEX_BINARY);
                break;
            case 2:
                number = Validate.getString("Please enter number: ",
                        "Must input number in the range 0 to 9",
                        IConstant.REGEX_DECIMAL);
                break;
            case 3:
                number = Validate.getString(
                        "Please enter number: ",
                        "Must input number from 0 to 9 and letters from A to F",
                        IConstant.REGEX_HEXADECIMAL);
                break;
        }
        return number;
    }

    /**
     * Choice integer number scanned from the input.
     *
     * @param choiceInput choice of user
     * @return the valid choice output integer scanned from the input
     */
    public static int getChoiceOutput(int choiceInput) {
        int choiceOutput;
        if (choiceInput == 1) {
            System.out.println("2.Decimal base");
            System.out.println("3.Hexadecimal base ");
            System.out.println("4.Exit");
        }
        if (choiceInput == 2) {
            System.out.println("1.Binary base");
            System.out.println("3.Hexadecimal base ");
            System.out.println("4.Exit");
        }
        if (choiceInput == 3) {
            System.out.println("1.Binary base");
            System.out.println("2.Decimal base");
            System.out.println("4.Exit");
        }
        choiceOutput = Validate.getInt(
                "Base number output: ",
                "Choice out of range 1 - 4",
                "Choice must be positive integer number",
                1, 4);
        if (choiceOutput == 4) {
            System.exit(0);
        }
        return choiceOutput;
    }

    /**
     * Display the number after convert.
     *
     * @param numberConvert number after convert
     * @param choiceInput choice of user
     */
    public static void displayAfterConvert(String numberConvert, int choiceInput) {
        switch (choiceInput) {
            case 1:
                System.out.println("After convert: " + numberConvert);
                System.out.println();
                break;
            case 2:
                System.out.println("After convert: " + numberConvert);
                System.out.println();
                break;
            case 3:
                System.out.println("After convert: " + numberConvert);
                System.out.println();
                break;
        }
    }
}
