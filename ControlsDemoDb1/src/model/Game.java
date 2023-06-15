/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import javafx.beans.property.BooleanProperty;
import static javafx.beans.property.BooleanProperty.booleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *
 * @author Bernd Debelak
 */
public class Game {
    private IntegerProperty idProperty;
    private StringProperty vornameProperty;
    private StringProperty nachnameProperty;
    private StringProperty spielnameProperty;
    private IntegerProperty gewinnProperty;
    private IntegerProperty verlustProperty;
    
    
    public Game(int id, String vorname, String nachname, String spielname, int gewinn, int verlust){
        this.idProperty = new SimpleIntegerProperty(id);
        this.vornameProperty = new SimpleStringProperty(vorname);
        this.nachnameProperty = new SimpleStringProperty(nachname);
        this.spielnameProperty = new SimpleStringProperty(spielname);
        this.gewinnProperty = new SimpleIntegerProperty(gewinn);
        this.verlustProperty = new SimpleIntegerProperty(verlust);
    }
    

    public int getId() {
        return idProperty.get();
    }

    public StringProperty getVornameProperty() {
        return vornameProperty;
    }
    public String getVorname(){
        return vornameProperty.get();
    }

    public StringProperty getNachnameProperty() {
        return nachnameProperty;
    }
    public String getNachname(){
        return nachnameProperty.get();
    }

    public StringProperty getSpielnameProperty() {
        return spielnameProperty;
    }
    public String getSpielname(){
        return spielnameProperty.get();
    }

    public IntegerProperty getGewinnProperty() {
        return gewinnProperty;
    }
    public int getGewinn() {
        return gewinnProperty.get();
    }

    public IntegerProperty getVerlustProperty() {
        return verlustProperty;
    }
    public int getVerlust() {
        return verlustProperty.get();
    }


    public void setVornameProperty(StringProperty vornameProperty) {
        this.vornameProperty = vornameProperty;
    }

    public void setNachnameProperty(StringProperty nachnameProperty) {
        this.nachnameProperty = nachnameProperty;
    }

    public void setSpielnameProperty(StringProperty spielnameProperty) {
        this.spielnameProperty = spielnameProperty;
    }

    public void setGewinnProperty(IntegerProperty gewinnProperty) {
        this.gewinnProperty = gewinnProperty;
    }

    public void setVerlustProperty(IntegerProperty verlustProperty) {
        this.verlustProperty = verlustProperty;
    }
}
