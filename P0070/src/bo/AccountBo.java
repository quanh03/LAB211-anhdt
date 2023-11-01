package bo;

import static constant.IConstant.REGEX_PASSWORD;
import static constant.IConstant.REGEX_USERNAME;
import entity.Account;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import mock.Data;
import static util.Validate.getString;

public class AccountBo {

    private static final Scanner sc = new Scanner(System.in);

    public AccountBo() {
    }

    public static String getWordLanguage(Locale language, String key) {
        ResourceBundle words
                = ResourceBundle.getBundle("language/messages", language);
        String value = words.getString(key);
        return value;
    }

    static String getUsername(Locale language) {
        while (true) {
            String result = getString(
                    getWordLanguage(language, "enterAcc"),
                    getWordLanguage(language, "errCheckInputAcc"),
                    REGEX_USERNAME);
            if (checkUsername(result)) {
                return result;
            } else {
                System.out.println(getWordLanguage(language, "errUsernameNotFound"));
            }
        }
    }

    static boolean checkUsername(String username) {
        ArrayList<Account> accountList = Data.accountList();
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    static String getPassword(Locale language) {
        return getString(
                getWordLanguage(language, "enterPass"),
                getWordLanguage(language, "errCheckPass"),
                REGEX_PASSWORD);
    }

    static boolean checkPassword(String usernameToCheck, String passwordToCheck) {
        ArrayList<Account> accountList = Data.accountList();
        for (Account account : accountList) {
            if (account.getUsername().equals(usernameToCheck) && account.getPassword().equals(passwordToCheck)) {
                return true;
            }
        }
        return false;
    }

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

    public static void login(Locale language) {
        String username = getUsername(language);
        String password = getPassword(language);
        boolean isValid = false;
        do {
            String captcha = generateCaptcha();
            isValid = checkCaptcha(captcha, language);
            if (!isValid) {
                System.out.println(getWordLanguage(language, "errCaptchaIncorrect"));
            }
        } while (!isValid);

        if (checkUsername(username) && checkPassword(username, password)) {
            System.out.println(getWordLanguage(language, "loginSuccess"));
        } else {
            System.out.println(getWordLanguage(language, "loginFail"));
        }
    }
}
