package constant;

public interface IConstant {

    String REGEX_USERNAME = "^[0-9]{10}$";
    String REGEX_PASSWORD = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,31}$";
}
