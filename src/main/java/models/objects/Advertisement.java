package models.objects;

import java.time.LocalDateTime;

/**
 * This class will be used to store Ads, this class extends Email class.
 * 
 * @author <a href="https://github.com/Trustacean">Edward</a>
 */

public class Advertisement extends Email {

    public Advertisement(String uuid, String sender, String recipient, String subject, String content,
            LocalDateTime date, boolean isRead) {
        super(uuid, sender, recipient, subject, content, date, isRead);
    }

    @Override
    public String toString() {
        return super.toString() + " -> [Advertisement]";
    }
}
