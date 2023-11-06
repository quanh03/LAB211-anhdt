package util;

import java.util.Random;

public class Helper {

    /**
     * Prints the menu
     */
    public static void menu() {
        System.out.println("\n-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }

    /**
     * Returns generate captcha.
     *
     * @param length length of captcha
     * @return the string value is captcha
     */
    public static String generateCaptcha(int length) {
        StringBuilder alpha = new StringBuilder();
        for (char c = 'A'; c <= 'Z'; c++) {
            alpha.append(c);
        }
        String digits = "0123456789";
        String alphaNumeric = alpha + digits;

        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < length; i++) {
            captcha.append(alphaNumeric.charAt(new Random().nextInt(alphaNumeric.length())));
        }
        return captcha.toString();
    }
}
