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
        if (password.length() >= 8 && password.length()<=128) {
            return true;
        }
        return false;
    }

    public static boolean emailAddressValidation(String email) {
        if (email.length() == 4 && email.length() <=30) {
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

    public static boolean isSimilar(String a, Email mail) {
        String b = mail.getSubject()+mail.getContent();

        if (b.toLowerCase().contains(a.toLowerCase())){
            return true;
        }
        return false;
    }

    public static boolean subjectLengthValidation(String subject) {
        if (subject.length()<=128) {
            return true;
        }
        return false;
    }
}
