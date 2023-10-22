package constant;

public interface IConstant {

    public final String REGEX_NAME = "^[a-zA-Z]+((\\s[a-zA-Z]+)){1,100}$";
    public final String REGEX_CODE = "^[Ww][\\d]{1,3}$";
    public final String REGEX_WORK_LOCATION = "^.{1,200}$";
    public final String DATE_FORMAT = "dd/MM/yyyy";

    public final String STATUS_UP = "UP";
    public final String STATUS_DOWN = "DOWN";
    public final String UPDATE = "UPDATE";
    public final String ADD_NEW = "ADD";
}
