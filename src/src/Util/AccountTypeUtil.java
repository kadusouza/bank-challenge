package Util;

import Exceptions.InvalidBalanceException;

public class AccountTypeUtil {
    public static final String SAVINGS = "Savings";
    public static final String CHECKING = "Checking";

    public static String returnOtherAccountType(String accountType) throws InvalidBalanceException {
        if (accountType.equals(SAVINGS)) {
            return CHECKING;
        } else if (accountType.equals(CHECKING)) {
            return SAVINGS;
        } else {
            throw new InvalidBalanceException("Invalid account type");
        }
    }
}
