package models.objects;

import java.time.LocalDateTime;

/**
 * This class will be used to store emails.
 * The attributes of this class as follows:
 * <ul>
 *     <li>{@link #sender}: Account</li>
 *     <li>{@link #recipient}: Account</li>
 *     <li>{@link #subject}: String</li>
 *     <li>{@link #content}: String</li>
 *     <li>{@link #date}: LocalDate</li>
 * </ul>
 *
 * @author <a href="https://github.com/Trustacean">Edward</a>
 * */

public class Email {
    //Attribute declarations
    private String sender;
    private String recipient;
    private String subject;
    private String content;
    private LocalDateTime date;

    public Email(String sender, String recipient, String subject, String content, LocalDateTime date) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.content = content;
        this.date = date;
    }

    public void setSender(String source) {
        this.sender = source;
    }

    public void setRecipient(String destination) {
        this.recipient = destination;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String email) {
        this.content = email;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateTime() {
        return date;
    }
}
