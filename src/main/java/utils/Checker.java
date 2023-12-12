package utils;

import models.Advertisement;
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

    public static boolean containsNonAlphanumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isLetterOrDigit(c))
                return true;
        }
        return false;
    }

    public static boolean isAdvertisement(Email mail) {
        return mail instanceof Advertisement;
    }
    
    // possibly for password
    public static boolean areEqual(String x, String y) {
        if (x == y){
            return true;
        }
        return false;
    }
}
