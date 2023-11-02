package main;

import bo.AccountBo;
import java.util.Locale;
import util.Validate;

public class Main {

    public static void main(String[] args) {
        Locale vietnamese = new Locale("vi");
        Locale english = new Locale("en");
        int choice = 0;
        do {
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            int choiceInput = Validate.getInt(
                    "Please choose one option:",
                    "Choice out range 1 - 3",
                    "Please input a digit ",
                    1, 3);
            switch (choiceInput) {
                case 1:
                    AccountBo.login(vietnamese);
                    break;
                case 2:
                    AccountBo.login(english);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        } while (choice != 3);
    }
}
