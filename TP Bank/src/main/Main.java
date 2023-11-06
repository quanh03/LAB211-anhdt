package main;

import java.util.Locale;
import java.util.ResourceBundle;
import services.LoginServices;
import util.Helper;
import util.Validate;

public class Main {

    public static void main(String[] args) {
        Helper.menu();
        int choice = Validate.getInt(
                "Please chocie one option: ", 
                "Numeric value out of range",
                "Invalid integer number", 
                1, 3);
            switch (choice) {
                case 1:
                    Locale.setDefault(new Locale("vi", "VN"));
                    break;
                case 2:
                    Locale.setDefault(new Locale("en", "US"));
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/Language");
        new LoginServices().loginProcess(resourceBundle);
    }
}