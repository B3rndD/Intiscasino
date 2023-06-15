package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBConnector;

public class PersonDAO {
    public static ObservableList<Person> getPersons() {
        ObservableList<Person> persons = FXCollections.observableArrayList();
        Connection con = null;

        try {
            con = DBConnector.connect();    // Verbindung zur DB
            String sql = "SELECT Mitarbeiter_ID, Vorname, Nachname, Gehalt, Addresse, HausNR, PLZ "
                    + "FROM mitarbeiter";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                Person p = new Person(
                        rs.getInt("Mitarbeiter_ID"),
                        rs.getString("Vorname"),
                        rs.getString("Nachname"),
                        rs.getDouble("Gehalt"),
                        rs.getString("Addresse"),
                        rs.getString("HausNR"),
                        rs.getString("PLZ")
                );
                persons.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                DBConnector.closeConnection();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return persons;
    }

    public static void update(Person person) {
        Connection con = null;
        try {
            con = DBConnector.connect();    // Verbindung zur DB
            String sql = "UPDATE mitarbeiter SET "
                    + " Vorname = '" + person.getVorname() + "', "
                    + " Nachname = '" + person.getNachname() + "', "
                    + " Gehalt = " + person.getGehalt() + ", "
                    + " Addresse = '" + person.getAdresse() + "', "
                    + " HausNR = '" + person.getHausNR() + "', "
                    + " PLZ = '" + person.getPLZ() + "' "
                    + " WHERE Mitarbeiter_ID = " + person.getMitarbeiter_ID();
            con.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                DBConnector.closeConnection();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    public static void insert(Person person) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DBConnector.connect();    // Verbindung zur DB
            String sql = "INSERT INTO mitarbeiter (Vorname, Nachname, Gehalt, Addresse, HausNR, PLZ) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, person.getVorname());
            pstmt.setString(2, person.getNachname());
            pstmt.setDouble(3, person.getGehalt());
            pstmt.setString(4, person.getAdresse());
            pstmt.setString(5, person.getHausNR());
            pstmt.setString(6, person.getPLZ());
            pstmt.executeUpdate();

            // Abrufen der generierten Mitarbeiter-ID
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int generatedID = rs.getInt(1);
                person.setMitarbeiter_ID(generatedID);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBConnector.closeConnection();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }}
}
    