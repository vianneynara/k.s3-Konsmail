package models;

import java.time.LocalDate;

/**
 * This class will be used to store emails.
 * The attributes of this class as follows:
 * <ul>
 *     <li>{@link #source}: Account</li>
 *     <li>{@link #destination}: Account</li>
 *     <li>{@link #subject}: String</li>
 *     <li>{@link #email}: String</li>
 *     <li>{@link #date}: LocalDate</li>
 * </ul>
 *
 * @author <a href="https://github.com/Trustacean">Edward</a>
 * */

public class Email {
    //Attribute declarations
    private String source;
    private String destination;
    private String subject;
    private String email;
    private LocalDate date;

    public Email(String source, String destination, String subject, String email, LocalDate date) {
        this.source = source;
        this.destination = destination;
        this.subject = subject;
        this.email = email;
        this.date = date;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDate() {
        return date;
    }
}
