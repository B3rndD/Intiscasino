package controlsdemo;

import gamed.FXML_gamedController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Game;
import model.GameDAO;


import model.Person;
import model.PersonDAO;
import model.gluecksspiel;
import model.gluecksspielDAO;

/**
 *
 * @author tc
 */
public class FXMLDocumentController implements Initializable {
    private ListProperty<Person> listProperty = new SimpleListProperty();
    private ObservableList<Person> persons;
    
    private Game actGame;
    private ObservableList<Game> myGameList;
    
    
    
    @FXML
    private ComboBox<Person> cbPersons;
    @FXML
    private MenuItem miEdit;
    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfLastName;
    @FXML
    private Button btnSave;
    
    private ToggleGroup tgCountries;
    
    @FXML
    private TextField tfMoney;
    private TextField tfAdress;
    @FXML
    private TextField tfHouseNR;
    @FXML
    private TextField tfPlz;
    @FXML
    private TextField tfAddress;
    @FXML
    private Button forwardBtn;
    @FXML
    private Button backBtn;
    @FXML
    private MenuItem miShowGame;
    @FXML
    private TextField tfSpielname;
    @FXML
    private TextField tfSpieltyp;
    @FXML
    private ComboBox<gluecksspiel> cbgluecksspiel;
    @FXML
    private TextField tfGlücksspielTyp_ID;
    @FXML
    private MenuItem miEdit1;
    @FXML
    private Button btnSave1;
    @FXML
    private Button forwardBtn1;
    @FXML
    private Button backBtn1;
    @FXML
    private Button newgluecksspiel;
    @FXML
    private Button newMitarbeiter;
    

    @FXML
    private void handleNewMitarbeiter(ActionEvent event) {
        // Leeren der Textfelder und Auswahl der Standardwerte
        tfFirstName.setText("");
        tfLastName.setText("");
        tfMoney.setText("");
        tfAddress.setText("");
        tfHouseNR.setText("");
        tfPlz.setText("");

        // Aktualisieren der ComboBox-Auswahl (keine Auswahl)
        cbPersons.getSelectionModel().clearSelection();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myGameList = GameDAO.getGames();
        //cbPersons.setItems(persons);
        persons = PersonDAO.getPersons();
        cbPersons.itemsProperty().bind(listProperty);
        listProperty.setValue(persons);
        
        ObservableList<gluecksspiel> gluecksspielList = gluecksspielDAO.getgluecksspiel();
        cbgluecksspiel.setItems(gluecksspielList);
        
        
    ;
        
        
    }    

    @FXML
private void handleCbPersonsAction(ActionEvent event) {
    Person selectedPerson = cbPersons.getSelectionModel().getSelectedItem();
    if (selectedPerson != null) {
        // Hier können Sie auf die ausgewählte Person zugreifen und entsprechende Aktionen durchführen
        int mitarbeiterId = selectedPerson.getMitarbeiter_ID();
        String vorname = selectedPerson.getVorname();
        String nachname = selectedPerson.getNachname();
        double gehalt = selectedPerson.getGehalt();
        String adresse = selectedPerson.getAdresse();
        String hausNr = selectedPerson.getHausNR();
        String plz = selectedPerson.getPLZ();

        // Beispielaktion: Die Daten der ausgewählten Person in Textfelder setzen
        tfFirstName.setText(vorname);
        tfLastName.setText(nachname);
        tfMoney.setText(Double.toString(gehalt));
        tfAddress.setText(adresse);
        tfHouseNR.setText(hausNr);
        tfPlz.setText(plz);
    }
}


    
@FXML
private void handleMiEditAction(ActionEvent event) {
    // Hier können Sie den Code für die Bearbeitungsaktion hinzufügen, z. B. das Speichern der Änderungen in der Datenbank
    Person selectedPerson = cbPersons.getSelectionModel().getSelectedItem();
    if (selectedPerson != null) {
        // Beispiel: Änderungen aus den Textfeldern abrufen
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        double money = Double.parseDouble(tfMoney.getText());
        String address = tfAddress.getText();  // Richtiges Textfeld tfAddress verwenden
        String houseNr = tfHouseNR.getText();
        String plz = tfPlz.getText();
        
        // Beispiel: Die Daten der ausgewählten Person aktualisieren
        selectedPerson.setVorname(firstName);
        selectedPerson.setNachname(lastName);
        selectedPerson.setGehalt(money);
        selectedPerson.setAdresse(address);
        selectedPerson.setHausNR(houseNr);
        selectedPerson.setPLZ(plz);
        
        // Beispiel: Die Änderungen in der Datenbank speichern
        PersonDAO.update(selectedPerson);
    }
}


    @FXML
    private void handleBtnSaveAction(ActionEvent event) {
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        double money = Double.parseDouble(tfMoney.getText());
        String address = tfAddress.getText();
        String houseNr = tfHouseNR.getText();
        String plz = tfPlz.getText();

        // Erzeugen eines neuen Person-Objekts mit den eingegebenen Daten
        Person newPerson = new Person(0, firstName, lastName, money, address, houseNr, plz);

        // Hinzufügen der neuen Person zur Datenbank
        PersonDAO.insert(newPerson);

        // Aktualisieren der Personenliste und Auswahl in der ComboBox
        persons.add(newPerson);
        cbPersons.getSelectionModel().select(newPerson);
    }

    private void handleMiEditActiongluecksspiel(ActionEvent event) {
        gluecksspiel selectedgluecksspiel = cbgluecksspiel.getSelectionModel().getSelectedItem();
        if (selectedgluecksspiel != null) {
            String spielname = tfSpielname.getText();
            String spieltyp = tfSpieltyp.getText();

            selectedgluecksspiel.setSpielname(spielname);
            selectedgluecksspiel.setSpieltyp(spieltyp);

            gluecksspielDAO.update(selectedgluecksspiel);
        }
    }

    @FXML
private void handleForwardBtnAction(ActionEvent event) {
    int selectedIndex = cbPersons.getSelectionModel().getSelectedIndex();
    int nextIndex = selectedIndex + 1;

    if (nextIndex < persons.size()) {
        cbPersons.getSelectionModel().select(nextIndex);
    }
}

@FXML
private void handleBackBtnAction(ActionEvent event) {
    int selectedIndex = cbPersons.getSelectionModel().getSelectedIndex();
    int previousIndex = selectedIndex - 1;

    if (previousIndex >= 0) {
        cbPersons.getSelectionModel().select(previousIndex);
    }
}

    @FXML
    private void handleShowGame(ActionEvent event) {
        actGame = myGameList.get(0);
        System.out.println(myGameList);
        
        try {
            FXMLLoader loader = new FXMLLoader();     //Loader Objekt
            loader.setLocation(getClass().getResource("/gamed/FXML_gamed.fxml"));
            Parent root = loader.load();                            //Wurzelcontrol
            //FXML_gamedController ctrl = loader.getController();  //ref. Controlerobj
            //ctrl.setGame(actGame);
            Stage stage = new Stage();                              //neue Bühne
            stage.initModality(Modality.WINDOW_MODAL);              //im Vordergrund
            stage.setScene(new Scene(root));
            stage.showAndWait();                                    //Anzeige
            //System.out.println("after Dialog: " + actPerson);
            //myGameList.set(0, actGame);

            //cbPersons.setItems(PersonDAO.getPersons());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 @FXML
    private void handleBtnSaveActiongluecksspiel(ActionEvent event) {
        String spielname = tfSpielname.getText();
        String spieltyp = tfSpieltyp.getText();

        // Erstellen eines neuen Glücksspiel-Objekts mit den eingegebenen Daten
        gluecksspiel newgluecksspiel = new gluecksspiel(0, spielname, spieltyp);

        // Hinzufügen des neuen Glücksspiel-Objekts zur Datenbank
        gluecksspielDAO.insert(newgluecksspiel);

        // Aktualisieren der ComboBox-Auswahl und Auswahl des neuen Glücksspiel-Objekts
        ObservableList<gluecksspiel> updatedgluecksspielList = gluecksspielDAO.getgluecksspiel();
        cbgluecksspiel.setItems(updatedgluecksspielList);
        cbgluecksspiel.getSelectionModel().select(newgluecksspiel);
    }

  

    @FXML
    private void handleForwardBtnActiongluecksspiel(ActionEvent event) {
        int selectedIndex = cbgluecksspiel.getSelectionModel().getSelectedIndex();
        int nextIndex = selectedIndex + 1;

        if (nextIndex < cbgluecksspiel.getItems().size()) {
            cbgluecksspiel.getSelectionModel().select(nextIndex);
        }
    }

    @FXML
    private void handleCbgluecksspielAction(ActionEvent event) {
        gluecksspiel selectedgluecksspiel = cbgluecksspiel.getSelectionModel().getSelectedItem();
        if (selectedgluecksspiel != null) {
            tfSpielname.setText(selectedgluecksspiel.getSpielname());
            tfSpieltyp.setText(selectedgluecksspiel.getSpieltyp());
            tfGlücksspielTyp_ID.setText(Integer.toString(selectedgluecksspiel.getGlueckspieltyp_ID()));
        }
    }

    @FXML
    private void handleBackBtnActiongluecksspiel(ActionEvent event) {
        int selectedIndex = cbgluecksspiel.getSelectionModel().getSelectedIndex();
        int previousIndex = selectedIndex - 1;

        if (previousIndex >= 0) {
            cbgluecksspiel.getSelectionModel().select(previousIndex);
        }
    }

    @FXML
    private void handleNewgluecksspiel(ActionEvent event) {
        // Leeren der Textfelder
        tfSpielname.setText("");
        tfSpieltyp.setText("");
        tfGlücksspielTyp_ID.setText("");

        // Aktualisieren der ComboBox-Auswahl (keine Auswahl)
        cbgluecksspiel.getSelectionModel().clearSelection();
    }

    @FXML
    private void handleBtnDeleteActionglueksspiele(ActionEvent event) {
        gluecksspiel selectedgluecksspiel = cbgluecksspiel.getSelectionModel().getSelectedItem();
        if (selectedgluecksspiel != null) {
            gluecksspielDAO.delete(selectedgluecksspiel); // Methode zum Löschen des ausgewählten Glücksspiels aufrufen

            // Aktualisieren der ComboBox-Auswahl und Auswahl des vorherigen Glücksspiels
            ObservableList<gluecksspiel> updatedgluecksspielList = gluecksspielDAO.getgluecksspiel();
            cbgluecksspiel.setItems(updatedgluecksspielList);

            int selectedIndex = cbgluecksspiel.getSelectionModel().getSelectedIndex();
            int previousIndex = selectedIndex - 1;
            if (previousIndex >= 0) {
                cbgluecksspiel.getSelectionModel().select(previousIndex);
            } else {
                cbgluecksspiel.getSelectionModel().clearSelection();
                tfSpielname.setText("");
                tfSpieltyp.setText("");
                tfGlücksspielTyp_ID.setText("");
            }
        }


    }
}
