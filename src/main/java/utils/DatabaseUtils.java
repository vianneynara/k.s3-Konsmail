package utils;

import java.sql.*;
import java.util.ArrayList;

import models.interfaces.Emailable;
import models.objects.Account;
import models.objects.Advertisement;
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

    public static ArrayList<Emailable> getMailbox(String userUuid) {
        ArrayList<Emailable> mailbox = new ArrayList<>();
        String query = "SELECT * FROM MAILBOX WHERE RECIPIENT_UUID = ? ORDER BY TIMESTAMP DESC";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            // Set the userUuid in the PreparedStatement
            ps.setString(1, userUuid);

            try (ResultSet rs = ps.executeQuery()) {
                // iterates through the result set and adds the emails to the mailbox
                while (rs.next()) {
                    String uuid = rs.getString("uuid");
                    String sender = rs.getString("sender_uuid");
                    String recipient = rs.getString("recipient_uuid");
                    String subj = rs.getString("subject");
                    String content = rs.getString("content");
                    Timestamp date = rs.getTimestamp("timestamp");
                    boolean isRead = rs.getBoolean("is_read");
                    boolean isAd = rs.getBoolean("is_ad");
                    if (isAd) {
                        mailbox.add(new Advertisement(uuid, sender, recipient, subj, content, date.toLocalDateTime(), isRead));
                    } else {
                        mailbox.add(new Email(uuid, sender, recipient, subj, content, date.toLocalDateTime(), isRead));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
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

    public static String getUuid(String emailAddress) {
        String query = "SELECT uuid FROM ACCOUNTS WHERE email_address = ?";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, emailAddress);

            ResultSet rs = ps.executeQuery();

            // Check if the ResultSet has any rows
            if (rs.next()) {
                // Retrieve the "uuid" column value
                return rs.getString("uuid");
            }
        } catch (SQLException e) {
            ULogger.logError(e, "Failed to check if account exists.");
        }
        return null;
    }

    public static String getEmailAddress(String emailUuid) {
        String query = "SELECT email_address FROM ACCOUNTS WHERE uuid = ?";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, emailUuid);

            ResultSet rs = ps.executeQuery();

            // Check if the ResultSet has any rows
            if (rs.next()) {
                // Retrieve the "email_address" column value
                return rs.getString("email_address");
            }
        } catch (SQLException e) {
            ULogger.logError(e, "Failed to check if account exists.");
        }
        return null;
    }

    public static String getFirstLastName(String accountUuid) {
        String query = "SELECT first_name, last_name FROM ACCOUNTS WHERE uuid = ?";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, accountUuid);

            ResultSet rs = ps.executeQuery();

            // Check if the ResultSet has any rows
            if (rs.next()) {
                // Retrieve the "last_name" then check if it's empty, then add it after the
                // "first_name".
                String lName = rs.getString("last_name").equals("") ? "" : " " + rs.getString("last_name");
                return rs.getString("first_name") + lName;
            }
        } catch (SQLException e) {
            ULogger.logError(e, "Failed to check if account exists.");
        }
        return null;
    }

    /**
     * Inserts an email into the database.
     *
     * @param email The email to be inserted.
     */
    public static void insertMail(Emailable email) {
        String query = "INSERT INTO MAILBOX " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Tries to connect to the database and execute the query using
        // try-with-resources
        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            // Sets the question marks to the email's corresponding attributes
            ps.setString(1, email.getUuid());
            ps.setString(2, email.getSenderUuid());
            ps.setString(3, email.getRecipientUuid());
            ps.setString(4, email.getSubject());
            ps.setString(5, email.getContent());
            ps.setTimestamp(6, Timestamp.valueOf(email.getDateTime()));
            ps.setInt(7, email.getRead() ? 1 : 0);
            if (email instanceof Advertisement) {
                ps.setInt(8, 1);
            } else {
                ps.setInt(8,0);
            }

            ps.executeUpdate();
            conn.commit();
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
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks whether an account exists in the database.
     *
     * @param address The email address to be checked.
     */
    public static boolean emailAddressExists(String address) {
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
    public static boolean emailAddressAndPasswordMatches(String address, String password) {
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

    public static boolean updateAccount(String fname, String lname, String emailAddress, String password) {
        String query = "UPDATE ACCOUNTS " +
                "SET FIRST_NAME = ?, LAST_NAME = ?, PASSWORD = ? " +
                "WHERE EMAIL_ADDRESS = ?";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            // Sets the question marks to the corresponding attributes
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, password);
            ps.setString(4, emailAddress);

            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void commitChanges() {
        try (Connection conn = DatabaseConnector.getConnection()) {
            conn.commit();
        } catch (SQLException e) {
            System.out.println("Error committing transaction: " + e.getMessage());
            // You might want to log the exception using a logging framework like log4j or
            // java.util.logging
        }
    }

}
