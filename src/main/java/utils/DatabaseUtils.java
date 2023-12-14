package utils;

import java.sql.*;
import java.util.ArrayList;

import models.objects.Account;
import models.objects.Email;

/**
 * This class will be used to handle all the database operations such as the
 * input and output.
 *
 * @author <a href="https://github.com/trustacean">Edward</a>
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * @author <a href="https://github.com/FatDog98">Patrick</a>
 */

public class DatabaseUtils {
    /**
     * Grabs all the emails from the database.
     *
     * @return An {@link ArrayList} of emails.
     */
    // TODO: make a getSentMailbox method

    public static ArrayList<Email> getMailbox() {
        ArrayList<Email> mailbox = new ArrayList<>();
        String query = "SELECT * FROM MAILBOX";

        // Tries to connect to the database and execute the query using
        // try-with-resources
        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            // iterates through the result set and adds the emails to the mailbox
            while (rs.next()) {
                String src = rs.getString("source");
                String dest = rs.getString("destination");
                String subj = rs.getString("subject");
                String email = rs.getString("email");
                Timestamp date = rs.getTimestamp("date");

                mailbox.add(new Email(src, dest, subj, email, date.toLocalDateTime()));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mailbox;
    }

    /**
     * Grabs all the accounts from the database.
     *
     * @return An {@link ArrayList} of accounts.
     */
    public static Account getAccount(String address) {
        Account account = null;
        String query = "SELECT * FROM ACCOUNTS WHERE email_address = ?";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            // Set the parameter value before executing the query
            ps.setString(1, address);

            try (ResultSet rs = ps.executeQuery()) {
                // Iterates through the result set and adds the account to the variable
                while (rs.next()) {
                    String fName = rs.getString("first_name");
                    String lName = rs.getString("last_name");
                    String eAddr = rs.getString("email_address");
                    String uuid = rs.getString("uuid");

                    account = new Account(fName, lName, eAddr, "", uuid);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return account;
    }

    /**
     * Inserts an email into the database.
     *
     * @param email The email to be inserted.
     */
    public static void insertEmail(Email email) {
        String query = "INSERT INTO MAILBOX " +
                "VALUES (?, ?, ?, ?, ?)";

        // Tries to connect to the database and execute the query using
        // try-with-resources
        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            // Sets the question marks to the email's corresponding attributes
            ps.setString(1, email.getSender());
            ps.setString(2, email.getRecipient());
            ps.setString(3, email.getSubject());
            ps.setString(4, email.getContent());
            ps.setString(5, email.getDateTime().toString());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Inserts an account into the database.
     *
     * @param account The account to be inserted.
     */
    public static void insertAccount(Account account) {
        String query = "INSERT INTO ACCOUNTS " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            // Sets the question marks to the account's corresponding attributes
            ps.setString(1, account.getUuid());
            ps.setString(2, account.getEmailAddress());
            ps.setString(3, account.getPassword());
            ps.setString(4, account.getFirstName());
            ps.setString(5, account.getLastName());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks whether an account exists in the database.
     *
     * @param address The email address to be checked.
     */
    public static boolean emailExists(String address) {
        String query = "SELECT email_address FROM ACCOUNTS WHERE email_address = ?";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            // sets the first question mark to the email address
            ps.setString(1, address);

            // executes the query and returns true if the result set is not empty
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            ULogger.logError(e, "Failed to check if account exists.");
            return false;
        }
    }

    /**
     * Checks if the email address and password matches in the database.
     *
     * @param address  The email address to be checked.
     * @param password The password to be checked.
     */
    public static boolean emailAndPasswordMatches(String address, String password) {
        String query = "SELECT email_address FROM ACCOUNTS WHERE email_address = ? AND password = ?";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            // sets the first question mark to the email address
            ps.setString(1, address);
            ps.setString(2, password);

            // executes the query and returns true if the result set is not empty
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            ULogger.logError(e, "Failed to check if account exists.");
            return false;
        }
    }

    public static boolean updateAccount(String fname, String lname, String address, String password) {
        String query = "UPDATE ACCOUNTS " +
                "SET FIRST_NAME = ?, LAST_NAME = ?, PASSWORD = ? " +
                "WHERE EMAIL_ADDRESS = ?";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            // Sets the question marks to the email's corresponding attributes
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, password);
            ps.setString(4, address);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
