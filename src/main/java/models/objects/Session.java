package models.objects;

/**
 * Session class is used to store the account information upon the login to run the {@link gui.MailboxPage}
 * application. The information stored is filled using {@link Account} or can be directly built using corresponding
 * attributes. This will be used to display the account information and for sending emails using this session uuid.
 * */

public class Session {

	private String accountUuid;
	private String accountEmailAddress;
	private String accountFirstName;
	private String accountLastName;

	/**
	 * Constructor to build the session using the {@link Account} information.
	 *
	 * @param account {@link Account} to build the session.
	 * */
	public Session(Account account) {
		this.accountUuid = account.getUuid();
		this.accountEmailAddress = account.getEmailAddress();
		this.accountFirstName = account.getFirstName();
		this.accountLastName = account.getLastName();
	}

	/**
	 * Constructor to build the session using direct values of corresponding session attributes.
	 * */
	public Session(String accountUuid, String accountEmailAddress, String accountFirstName, String accountLastName) {
		this.accountUuid = accountUuid;
		this.accountEmailAddress = accountEmailAddress;
		this.accountFirstName = accountFirstName;
		this.accountLastName = accountLastName;
	}

	public void setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
	}

	public void setAccountEmailAddress(String accountEmailAddress) {
		this.accountEmailAddress = accountEmailAddress;
	}

	public void setAccountFirstName(String accountFirstName) {
		this.accountFirstName = accountFirstName;
	}

	public void setAccountLastName(String accountLastName) {
		this.accountLastName = accountLastName;
	}

	public String getAccountUuid() {
		return accountUuid;
	}

	public String getAccountEmailAddress() {
		return accountEmailAddress;
	}

	public String getAccountFirstName() {
		return accountFirstName;
	}

	public String getAccountLastName() {
		return accountLastName;
	}
}
