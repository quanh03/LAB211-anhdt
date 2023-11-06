package services;

import constant.IConstant;
import entity.Account;
import java.util.ResourceBundle;
import java.util.Scanner;
import mock.Data;
import util.Helper;
import util.Validate;

public class LoginServices {

    /**
     * This method use to performs the login process
     * 
     * @param resourceBundle containing text resources for the login process
     */
    public void loginProcess(ResourceBundle resourceBundle) {
        String account = Validate.getString(
                resourceBundle.getString(IConstant.ACCOUNT_TEXT),
                resourceBundle.getString(IConstant.ACCOUNT_INVALID_TEXT),
                IConstant.REGEX_ACCOUTN_NUMBER);

        String password = Validate.getString(
                resourceBundle.getString(IConstant.PASSWORD_TEXT),
                resourceBundle.getString(IConstant.PASSWORD_INVALID_TEXT),
                IConstant.REGEX_PASSWORD);

        String captchaGenerate = Helper.generateCaptcha(IConstant.CAPTCHA_LENGTH);
        System.out.print(resourceBundle.getString(IConstant.CAPTCHA_TEXT) + captchaGenerate + "\n");

        boolean isPass = vertifyCaptcha(
                resourceBundle.getString(IConstant.INPUT_CAPTCHA_TEXT),
                resourceBundle.getString(IConstant.CAPTCHA_INVALID_TEXT),
                resourceBundle.getString(IConstant.CAPTCHA_INCORRECT_TEXT),
                captchaGenerate);

        if (isPass && authentication(account, password)) {
            System.out.println(resourceBundle.getString(IConstant.LOGIN_SUCCESS_TEXT));
        } else {
            System.out.println(resourceBundle.getString(IConstant.LOGIN_FAILED_TEXT));
        }
    }

    /**
     * Return result verify captcha
     *
     * @param messageInfo                the message to be printed instructing 
     *                                   the user to input
     * @param messageErrorInvalidCaptcha the error message for invalid captcha input
     * @param messageErrorWrongCaptcha   the error message for incorrect captcha input
     * @param captchaGenerate            the captcha to compare
     * @return true if the user input matches the captcha, false otherwise.
     */
    private boolean vertifyCaptcha(
            String messageInfo,
            String messageErrorInvalidCaptcha,
            String messageErrorWrongCaptcha,
            String captchaGenerate
    ) {
        String captchaInput;
        do {
//            captchaInput = Validate.getString(messageInfo, messageErrorInvalidCaptcha, captchaGenerate);
            // Nhap match full ky tu captcha
//            if (captchaGenerate.contains(captchaInput)) {
//                return true;
//            }

            // Nhap match 1 ky tu dau tien
            captchaInput = Validate.getString(messageInfo, messageErrorInvalidCaptcha, captchaGenerate.substring(0, 1));
            if (captchaGenerate.charAt(0) == captchaInput.charAt(0)) {
                return true;
            }
            System.out.println(messageErrorWrongCaptcha);
        } while (true);
    }

    /**
     * Returns the to authentication result
     * 
     * @param account  to authentication
     * @param password to authentication
     * @return 
     */
    private boolean authentication(String account, String password) {
        for (Account a : Data.ListAccount) {
            if (account.equals(a.getAccount()) && password.equals(a.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
