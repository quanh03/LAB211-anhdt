
package entity;

public class Hexadecimal {

    public Hexadecimal() {
    }

    /**
     * Convert from Hexa to Decimal.
     *
     * @param number number before convert
     * @return number after convert
     */
    public static String toDecimal(String number) {
        int decimal = 0;
        int power = 0;
        number = number.toUpperCase();
        for (int i = number.length() - 1; i >= 0; i--) {
            char hexChar = number.charAt(i);
            int digit = hexCharToDecimal(hexChar);
            decimal += digit * Math.pow(16, power);
            power++;
        }
        return Integer.toString(decimal);
    }
    
    /**
     * support method to convert index of hex char to decimal
     * 
     * @param hexChar char before convert to decimal
     * @return index after convert
     */
    private static int hexCharToDecimal(char hexChar) {
        if (hexChar >= '0' && hexChar <= '9') {
            return hexChar - '0';
        } else {
            return hexChar - 'A' + 10;
        }
    }

    /**
     * Convert from Hexadecimal to Binary.
     *
     * @param number number before convert
     * @return number after convert
     */
    public static String toBinary(String number) {
        return Decimal.toBinary(toDecimal(number));
    }
}
