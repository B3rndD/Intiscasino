package controlsdemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

import model.Person;
import model.PersonDAO;

/**
 *
 * @author tc
 */
public class FXMLDocumentController implements Initializable {
    private ListProperty<Person> listProperty = new SimpleListProperty();
    private ObservableList<Person> persons;
    
    
    
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
    
    

    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        //cbPersons.setItems(persons);
        persons = PersonDAO.getPersons();
        cbPersons.itemsProperty().bind(listProperty);
        listProperty.setValue(persons);
        
        
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
        String address = tfAdress.getText();
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
    }



   
    
}
