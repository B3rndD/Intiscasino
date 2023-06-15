package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBConnector;

public class GameDAO {
    public static ObservableList<Game> getGames () {
        ObservableList<Game> GamesList = 
                FXCollections.observableArrayList();
        Connection con;
        
        try {
            con = DBConnector.connect();
            //SELECT p.*, c.country FROM persons p, countries c WHERE p.country_id = c.id
            String sql = "SELECT kunde.Kunden_ID, kunde.Vorname, kunde.Nachname, gluecksspiel.Spielname, spielaktivitaet.Gewinn, spielaktivitaet.Verlust FROM kunde INNER JOIN spielaktivitaet ON spielaktivitaet.Kunden_ID = kunde.Kunden_ID INNER JOIN spiel ON spielaktivitaet.Spiel_ID = spiel.Gluecksspiel_ID INNER JOIN gluecksspiel ON spiel.Gluecksspieltyp_ID = gluecksspiel.Glueckspieltyp_ID";
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                GamesList.add(new Game(
                     rs.getInt("Kunden_ID"),
                     rs.getString("Vorname"),
                     rs.getString("Nachname"),
                     rs.getString("Spielname"),
                     rs.getInt("Gewinn"),
                     rs.getInt("Verlust")
                ));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return GamesList;
    }
}






