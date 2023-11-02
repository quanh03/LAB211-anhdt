package entity;

import static bo.AccountBo.checkUsername;
import static bo.AccountBo.getWordLanguage;
import static constant.IConstant.REGEX_PASSWORD;
import static constant.IConstant.REGEX_USERNAME;
import java.util.Locale;
import util.Validate;

public class Account {

    private String username;
    private String password;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Perform the input process for the account, including entering the username and password.
     * 
     * @param language The selected language for messages.
     */
    public void input(Locale language) {
        while (true) {
            this.username = Validate.getString(
                    getWordLanguage(language, "enterAcc"),
                    getWordLanguage(language, "errCheckInputAcc"),
                    REGEX_USERNAME);
            this.password = Validate.getString(
                    getWordLanguage(language, "enterPass"),
                    getWordLanguage(language, "errCheckPass"),
                    REGEX_PASSWORD);
            if (checkUsername(this.username)) {
                break;
            } else {
                System.out.println(getWordLanguage(language, "errUsernameNotFound"));
            }
        }
    }
}
