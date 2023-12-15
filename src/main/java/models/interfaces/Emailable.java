package models.interfaces;

import java.time.LocalDateTime;

public interface Emailable {
    String uuid = null;
	String senderUuid = null;
	String recipientUuid = null;
	String subject = null;
	String content = null;
	LocalDateTime date = null;
	boolean isRead = false;

	String getUuid();
	String getSenderUuid();
	String getRecipientUuid();
	String getSubject();
	String getContent();
	LocalDateTime getDateTime();
	String getFormattedDate();
	String getFormattedTime();
	boolean getRead();

}
