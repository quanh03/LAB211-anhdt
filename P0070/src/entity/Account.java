package entity;

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

//    public void input(Locale language) {
//        this.username = Validate.getString(
//                getWordLanguage(language, "enterAcc"),
//                getWordLanguage(language, "errCheckInputAcc"),
//                REGEX_USERNAME);
//        this.password = Validate.getString(
//                getWordLanguage(language, "enterPass"),
//                getWordLanguage(language, "errCheckPass"),
//                REGEX_PASSWORD);
//    }
}
