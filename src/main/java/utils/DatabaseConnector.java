package utils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import models.Account;
import models.Email;

/**
 * Database Connector class that handles the connection to the database.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 */
public class DatabaseConnector {
	/* Database Accessor Credentials */
	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "usip2pbol";
	private static final String PASSWORD = "usip2pbol";

	/**
	 * Connects to the database with the credentials.
	 *
	 * @throws SQLException thrown when there is an error connecting to the
	 *                      database.
	 */
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	}

	/**
	 * Method that returns a boolean status whether it can connect to the database.
	 *
	 * @return boolean status whether it can connect to the database.
	 */
	public static boolean canConnectToDatabase() {
		try {
			getConnection();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static ArrayList<Email> getMailbox() {
		ArrayList<Email> mailbox = new ArrayList<Email>();
		try (Connection conn = getConnection()) {
			String query = "SELECT * FROM MAILBOX";

			try (PreparedStatement ps = conn.prepareStatement(query);
					ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					Account src = null;
					Account dest = null;
					String subj = rs.getString("subject");
					String email = rs.getString("email");
					Date date = rs.getDate("date");

					// TODO figure out on how to save src and dest accounts to databasse.
					mailbox.add(new Email(src, dest, subj, email, date.toLocalDate()));
				}

			} catch (Exception e) { // Stack tracing
				System.out.println("error while trying to execute query.");
				System.out.println(e.getMessage());
			}

		} catch (Exception e) { // Stack tracing
			System.out.println("error while trying to get connection from database.");
			System.out.println(e.getMessage());
		}
		return mailbox;
	}

		public static ArrayList<Account> getAccounts() {
		ArrayList<Account> accounts = new ArrayList<Account>();
		try (Connection conn = getConnection()) {
			String query = "SELECT * FROM ACCOUNTS";

			try (PreparedStatement ps = conn.prepareStatement(query);
					ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					String fName = rs.getString("first_name");
					String lName = rs.getString("last_name");
					String eAddr = rs.getString("email_address");
					String pass = rs.getString("password");
					String uuid = rs.getString("uuid");

					accounts.add(new Account(fName, lName, eAddr, pass, uuid));
				}

			} catch (Exception e) { // Stack tracing
				System.out.println("error while trying to execute query.");
				System.out.println(e.getMessage());
			}

		} catch (Exception e) { // Stack tracing
			System.out.println("error while trying to get connection from database.");
			System.out.println(e.getMessage());
		}
		return accounts;
	}
}