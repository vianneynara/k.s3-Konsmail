package utils;

import java.sql.*;
import java.util.ArrayList;

import models.objects.Account;
import models.objects.Email;

public class DatabaseUtil {
    public static ArrayList<Email> getMailbox() {
        ArrayList<Email> mailbox = new ArrayList<Email>();
        String query = "SELECT * FROM MAILBOX";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

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

    public static ArrayList<Account> getAccounts() {
        ArrayList<Account> accounts = new ArrayList<Account>();
        String query = "SELECT * FROM ACCOUNTS";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String eAddr = rs.getString("email_address");
                String pass = rs.getString("password");
                String uuid = rs.getString("uuid");

                accounts.add(new Account(fName, lName, eAddr, pass, uuid));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accounts;
    }

    public static void insertEmail(Email mail) {
        String query = "INSERT INTO MAILBOX" +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, mail.getSender());
            ps.setString(2, mail.getRecipient());
            ps.setString(3, mail.getSubject());
            ps.setString(4, mail.getContent());
            ps.setString(5, mail.getDateTime().toString());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertAccount(Account acct) {
        String query = "INSERT INTO ACCOUNTS " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, acct.getUuid());
            ps.setString(2, acct.getEmailAddress());
            ps.setString(3, acct.getPassword());
            ps.setString(4, acct.getFirstName());
            ps.setString(5, acct.getLastName());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean accountExists(String address) {
        String query = "SELECT email_address FROM ACCOUNTS WHERE email_address = ?";

        try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, address);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Account exists");
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
