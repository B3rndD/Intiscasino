package model;

import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBConnector;

public class gluecksspielDAO {
    public static ObservableList<gluecksspiel> getgluecksspiel() {
        ObservableList<gluecksspiel> gluecksspiel = FXCollections.observableArrayList();
        Connection con = null;

        try {
            con = DBConnector.connect();    // Verbindung zur DB
            String sql = "SELECT Glueckspieltyp_ID, Spielname, Spieltyp "
                    + "FROM gluecksspiel";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                gluecksspiel s = new gluecksspiel(
                        rs.getInt("Glueckspieltyp_ID"),
                        rs.getString("Spielname"),
                        rs.getString("Spieltyp")
                );
                gluecksspiel.add(s);
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

        return gluecksspiel;
    }

    public static void update(gluecksspiel gluecksspiel) {
        Connection con = null;
        try {
            con = DBConnector.connect();    // Verbindung zur DB
            String sql = "UPDATE gluecksspiel SET "
                    + "Spielname = ?, "
                    + "Spieltyp = ? "
                    + "WHERE Glueckspieltyp_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, gluecksspiel.getSpielname());
            statement.setString(2, gluecksspiel.getSpieltyp());
            statement.setInt(3, gluecksspiel.getGlueckspieltyp_ID());
            statement.executeUpdate();
            statement.close();
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
        public static void delete(gluecksspiel gluecksspiel) {
        Connection con = null;
        try {
            con = DBConnector.connect();    // Verbindung zur DB
            String sql = "DELETE FROM gluecksspiel WHERE Glueckspieltyp_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, gluecksspiel.getGlueckspieltyp_ID());
            statement.executeUpdate();
            statement.close();
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
    public static void insert(gluecksspiel gluecksspiel) {
        Connection con = null;
        try {
            con = DBConnector.connect();    // Verbindung zur DB
            String sql = "INSERT INTO gluecksspiel (Spielname, Spieltyp) "
                    + "VALUES (?, ?)";
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, gluecksspiel.getSpielname());
            statement.setString(2, gluecksspiel.getSpieltyp());
            statement.executeUpdate();

            // Abrufen der generierten ID und Aktualisieren des Glücksspiel-Objekts
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedID = generatedKeys.getInt(1);
                gluecksspiel.setGlueckspieltyp_ID(generatedID);
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
    }

    }