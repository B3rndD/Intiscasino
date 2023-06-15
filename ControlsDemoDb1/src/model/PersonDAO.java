package model;

import java.sql.Connection;
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
}
