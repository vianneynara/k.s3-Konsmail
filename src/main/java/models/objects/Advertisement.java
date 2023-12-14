package models.objects;

import java.time.LocalDate;

/**
 * This class will be used to store Ads, this class extends Email class.
 * @author <a href="https://github.com/Trustacean">Edward</a>
 * */

public class Advertisement extends Email {

    public Advertisement(String source, String destination, String subject, String email, LocalDate date) {
        super(source, destination, subject, email, date);
    }

    
}
