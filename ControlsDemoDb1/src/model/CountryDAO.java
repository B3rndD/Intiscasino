package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBConnector;
import util.DML_DAO;

public class CountryDAO {
    public static ObservableList<Country> getCountries () {
        ObservableList<Country> countries = FXCollections.observableArrayList();
        Connection con;
        
        try {
            con = DBConnector.connect();    //Verbindung zur DB
            String sql = "SELECT * FROM counries";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                Country c = new Country (
                    rs.getInt("id"),
                    rs.getString("country"),
                    rs.getString("country_short"),
                    rs.getInt("area")                       
                );
                countries.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return countries;
    }
}
