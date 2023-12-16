package models.objects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import models.interfaces.Emailable;

/**
 * This class will be used to store emails.
 * The attributes of this class as follows:
 * <ul>
 * <li>{@link #uuid}: String</li>
 * <li>{@link #senderUuid}: Account</li>
 * <li>{@link #recipientUuid}: Account</li>
 * <li>{@link #subject}: String</li>
 * <li>{@link #content}: String</li>
 * <li>{@link #date}: LocalDate</li>
 * </ul>
 *
 * @author <a href="https://github.com/Trustacean">Edward</a>
 */

public class Email implements Emailable {

	public static final String DATE_FORMATTER = "dd MMM YYYY";
	public static final String TIME_FORMATTER = "hh:mm a";

	// Attribute declarations
	private String uuid;
	private String senderUuid;
	private String recipientUuid;
	private String subject;
	private String content;
	private LocalDateTime date;
	private boolean isRead;

	public Email(String uuid, String senderUuid, String recipientUuid, String subject, String content,
			LocalDateTime date, boolean isRead) {
		this.uuid = uuid;
		this.senderUuid = senderUuid;
		this.recipientUuid = recipientUuid;
		this.subject = subject;
		this.content = content;
		this.date = date;
		this.isRead = isRead;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setSenderUuid(String source) {
		this.senderUuid = source;
	}

	public void setRecipientUuid(String destination) {
		this.recipientUuid = destination;
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

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public String getUuid() {
		return uuid;
	}

	public String getSenderUuid() {
		return senderUuid;
	}

	public String getRecipientUuid() {
		return recipientUuid;
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

	public boolean getRead() {
		return isRead;
	}

	/**
	 * Formats the date to the format specified in {@link #DATE_FORMATTER}.
	 *
	 * @return {@link String} formatted date.
	 */
	public String getFormattedDate() {
		DateTimeFormatter format = new DateTimeFormatterBuilder()
				.parseCaseInsensitive()
				.appendPattern(DATE_FORMATTER)
				.toFormatter(Locale.US);
		return date.format(format);
	}

	/**
	 * Formats the time to the format specified in {@link #TIME_FORMATTER}.
	 *
	 * @return {@link String} formatted time.
	 */
	public String getFormattedTime() {
		DateTimeFormatter format = new DateTimeFormatterBuilder()
				.parseCaseInsensitive()
				.appendPattern(TIME_FORMATTER)
				.toFormatter(Locale.US);
		return date.format(format);
	}

	@Override
	public String toString() {
		// TODO change uuid to names
		return String.format("Email {senderName: %s, recipientName: %s, subject: %s, content: %s, date: %s, isRead: %s}",
				senderUuid, recipientUuid, subject, content, date, isRead);
	}
}
