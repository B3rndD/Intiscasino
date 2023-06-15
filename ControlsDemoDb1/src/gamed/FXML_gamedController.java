/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamed;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Toggle;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Game;
import model.GameDAO;
import model.Person;
import model.PersonDAO;

/**
 * FXML Controller class
 *
 * @author Bernd Debelak
 */
public class FXML_gamedController implements Initializable {

    private ObservableList<Game> myGameList;
    private ListProperty<Game> listProperty = new SimpleListProperty();
    
    private Game actGame;
    
    @FXML
    private TableColumn<Game, String> tvVorname;
    @FXML
    private TableColumn<Game, String> tvNachname;
    @FXML
    private TableColumn<Game, String> tvSpiel;
    @FXML
    private TableColumn<Game, Integer> tvGewinn;
    @FXML
    private TableColumn<Game, Integer> tvVerlust;
    @FXML
    private TableView<Game> tvGames;
    
    
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        //cbPersons.setItems(PersonDAO.getPersons()); 
        myGameList = GameDAO.getGames();
        //ComboBox an die Liste binden
        //cbPersons.itemsProperty().bind(listProperty);
        //listProperty.setValue(myGameList);

        
        //Spalten der TableView an die Member binden
        tvVorname.setCellValueFactory(new PropertyValueFactory("Vorname"));
        tvNachname.setCellValueFactory(new PropertyValueFactory("Nachname"));
        tvSpiel.setCellValueFactory(new PropertyValueFactory("Spielname"));
        tvGewinn.setCellValueFactory(new PropertyValueFactory("Gewinn"));
        tvVerlust.setCellValueFactory(new PropertyValueFactory("Verlust"));
        tvGames.setItems(myGameList);
    }    
    public void setGame (Game actGame) {
        this.actGame = actGame;
        tvNachname.setText(actGame.getNachname());
        tvVorname.setText(actGame.getVorname());
        tvSpiel.setText(actGame.getSpielname());
        tvGewinn.setText(String.valueOf(actGame.getGewinn()));
        tvVerlust.setText(String.valueOf(actGame.getVerlust()));
        
    }
}
