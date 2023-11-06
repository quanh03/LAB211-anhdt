package constant;

public interface IConstant {

    String REGEX_ACCOUTN_NUMBER = "\\d{10}";

    String REGEX_PASSWORD = "(?=.*\\d*)(?=.*[a-zA-Z].*).{8,31}";

    String CAPTCHA = "^[0-9A-Z]{1}$";

    int CAPTCHA_LENGTH = 5;

    String ACCOUNT_TEXT = "account";

    String PASSWORD_TEXT = "password";

    String CAPTCHA_TEXT = "captcha";

    String INPUT_CAPTCHA_TEXT = "inputCaptcha";

    String ACCOUNT_INVALID_TEXT = "accountInvalid";

    String PASSWORD_INVALID_TEXT = "passwordInvalid";

    String CAPTCHA_INCORRECT_TEXT = "captchaIncorrect";

    String CAPTCHA_INVALID_TEXT = "captchaInvalid";

    String LOGIN_SUCCESS_TEXT = "loginSuccess";

    String LOGIN_FAILED_TEXT = "loginFailed";

}
