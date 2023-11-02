package bo;

import entity.Account;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import mock.Data;

public class AccountBo {

    private static final Scanner sc = new Scanner(System.in);

    public AccountBo() {
    }

    /**
     * Retrieve words in a specific language from a language resource.
     *
     * @param language The language for translation.
     * @param key The key to retrieve a word from the language resource.
     * @return The translated word corresponding to the key and language.
     */
    public static String getWordLanguage(Locale language, String key) {
        ResourceBundle words
                = ResourceBundle.getBundle("language/messages", language);
        String value = words.getString(key);
        return value;
    }

//    static String getUsername(Locale language) {
//        while (true) {
//            String result = getString(
//                    getWordLanguage(language, "enterAcc"),
//                    getWordLanguage(language, "errCheckInputAcc"),
//                    REGEX_USERNAME);
//            if (checkUsername(result)) {
//                return result;
//            } else {
//                System.out.println(getWordLanguage(language, "errUsernameNotFound"));
//            }
//        }
//    }
    /**
     * Check the validity of a username.
     *
     * @param username The username to check.
     * @return True if the username exists, False if it doesn't.
     */
    public static boolean checkUsername(String username) {
        ArrayList<Account> accountList = Data.accountList();
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

//    static String getPassword(Locale language) {
//        return getString(
//                getWordLanguage(language, "enterPass"),
//                getWordLanguage(language, "errCheckPass"),
//                REGEX_PASSWORD);
//    }
    /**
     * Check the validity of a password.
     *
     * @param usernameToCheck The username to check.
     * @param passwordToCheck The password to check.
     * @return True if the password is valid, False if it's not valid.
     */
    static boolean checkPassword(String usernameToCheck, String passwordToCheck) {
        ArrayList<Account> accountList = Data.accountList();
        for (Account account : accountList) {
            if (account.getUsername().equals(usernameToCheck) && account.getPassword().equals(passwordToCheck)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generate a random captcha code.
     *
     * @return The captcha code.
     */
    static String generateCaptcha() {
        String chrs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        String captcha = "";
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(chrs.length());
            captcha += chrs.charAt(index);
        }
        return captcha;
    }

    /**
     * Check the validity of a captcha code entered by the user.
     *
     * @param captcha The generated captcha code.
     * @param language The selected language for messages.
     * @return True if the captcha is correct, False if it's incorrect.
     */
    static boolean checkCaptcha(String captcha, Locale language) {
        System.out.println("Captcha: " + captcha);
        System.out.print(getWordLanguage(language, "enterCaptcha"));
        String captchaInput = sc.nextLine().trim();
        String[] captchaChars = captcha.split("");
        for (String charInput : captchaChars) {
            if (captchaInput.contains(charInput)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Perform the login process.
     *
     * @param language The selected language for messages.
     */
    public static void login(Locale language) {
//        Account account = getUserAccount(language);
        Account account = new Account();
        account.input(language);
        if (isValidLogin(account, language)) {
            System.out.println(getWordLanguage(language, "loginSuccess"));
        } else {
            System.out.println(getWordLanguage(language, "loginFail"));
        }
    }

//    private static Account getUserAccount(Locale language) {
//        String username = getUsername(language);
//        String password = getPassword(language);
//        return new Account(username, password);
//    }
    /**
     * Check if the entered captcha code is valid, and also verify the username
     * and password.
     *
     * @param account The user account to be verified.
     * @param language The selected language for messages.
     * @return True if the login is successful, False if it fails.
     */
    private static boolean isValidLogin(Account account, Locale language) {
        boolean isValid = false;
        do {
            String captcha = generateCaptcha();
            isValid = checkCaptcha(captcha, language);
            if (!isValid) {
                System.out.println(getWordLanguage(language, "errCaptchaIncorrect"));
            }
        } while (!isValid);

        return checkUsername(account.getUsername()) && checkPassword(account.getUsername(), account.getPassword());
    }
}
