package utils;

import models.objects.Advertisement;
import models.objects.Email;

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
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsNonAlpha(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAdvertisement(Email mail) {
        return mail instanceof Advertisement;
    }
}
