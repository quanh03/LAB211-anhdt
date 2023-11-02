package mock;

import entity.Account;
import java.util.ArrayList;

public class Data {

    /**
     * This method returns a list of sample account objects.
     *
     * @return an array list of account objects representing sample accounts.
     */
    public static ArrayList accountList() {
        ArrayList<Account> accList = new ArrayList<>();
        accList.add(new Account("1111111111", "1aaaaaaa"));
        accList.add(new Account("2222222222", "2bbbbbbb"));
        accList.add(new Account("3333333333", "3ccccccc"));
        accList.add(new Account("4444444444", "4ddddddd"));
        accList.add(new Account("5555555555", "5eeeeeee"));
        return accList;
    }
}
