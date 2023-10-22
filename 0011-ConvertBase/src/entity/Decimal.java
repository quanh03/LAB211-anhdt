package entity;

public class Decimal {

    public Decimal() {
    }
    /**
     * Convert from Decimal to Binary.
     *
     * @param number number before convert
     * @return number after convert
     */
    public static String toBinary(String number) {
        String binaryNumber = "";
        int decimal = Integer.parseInt(number);
        while (decimal > 0) {
            int remainder = decimal % 2;
            binaryNumber = remainder + binaryNumber;
            decimal /= 2;
        }
        return binaryNumber;
    }

    /**
     * Convert from Decimal to Hexadecimal.
     *
     * @param number number before convert
     * @return number after convert
     */
    public static String toHexa(String number) {
        String hexNumber = "";
        int decimal = Integer.parseInt(number);
        while (decimal > 0) {
            int remainder = decimal % 16;
            char hexChar = decimalToHexChar(remainder);
            hexNumber = hexChar + hexNumber;
            decimal /= 16;
        }

        return hexNumber;
    }

    /**
     * support method to convert index of decimal to hexa char
     *
     * @param decimal index before convert to hexa char
     * @return index after convert
     */
    private static char decimalToHexChar(int decimal) {
        if (decimal >= 0 && decimal <= 9) {
            return (char) (decimal + '0');
        } else {
            return (char) (decimal - 10 + 'A');
        }
    }
}
