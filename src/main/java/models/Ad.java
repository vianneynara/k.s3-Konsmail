package models;

import java.time.LocalDate;

/**
 * This class will be used to store Ads, this class extends Email class.
 * @author <a href="https://github.com/Trustacean">Edward</a>
 * */

public class Ad extends Email {

    public Ad(Account source, Account destination, String subject, String email, LocalDate date) {
        // Parent constructor
        super(source, destination, subject, email, date);
        // TODO
    }

    
}
