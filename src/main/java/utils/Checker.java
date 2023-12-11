package utils;

import models.Ad;
import models.Email;

/**
 * This class will be used to validate inputs.
 * 
 * @author <a href="https://github.com/Trustacean">Edward</a>
 */

public class Checker {

    public static boolean passwordLengthValidation(String password) {
        if (password.length() == 8) {
            return true;
        }
        return false;
    }

    public static boolean containsSymbol(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isLetterOrDigit(c))
                return true;
        }
        return false;
    }

    public static boolean isAd(Email mail) {
        return mail instanceof Ad;
    }

}
