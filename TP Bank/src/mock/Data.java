package mock;

import entity.Account;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Account> ListAccount = new ArrayList<>();

    static {
        ListAccount.add(new Account("1111111111", "1aaaaaaa"));
        ListAccount.add(new Account("2222222222", "2bbbbbbb"));
        ListAccount.add(new Account("3333333333", "3ccccccc"));
        ListAccount.add(new Account("4444444444", "4ddddddd"));
        ListAccount.add(new Account("5555555555", "5eeeeeee"));
    }
}
