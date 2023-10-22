package entity;

public class Binary {

    public Binary() {
    }

    /**
     * Convert from Binary to Decimal.
     *
     * @param number number before convert
     * @return number after convert
     */
    public static String toDecimal(String number) {
        int decimal = 0;
        int power = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            char binaryChar = number.charAt(i);
            if (binaryChar == '0' || binaryChar == '1') {
                int digit = binaryChar - '0';
                decimal += digit * Math.pow(2, power);
                power++;
            }
        }
        return Integer.toString(decimal);
    }

    /**
     * Convert from Binary to Hexadecimal.
     *
     * @param number number before convert
     * @return number after convert
     */
    public static String toHexa(String number) {
        return Decimal.toHexa(toDecimal(number));
    }
}
