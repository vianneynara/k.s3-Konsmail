package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	 * @throws SQLException thrown when there is an error connecting to the database.
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
}