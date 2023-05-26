/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bernd Debelak
 */
public class Country {
    private int id;
    private String  country;
    private String countryShort;
    private int area;

    public Country(int id, String country, String countryShort, int area) {
        this.id = id;
        this.country = country;
        this.countryShort = countryShort;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryShort() {
        return countryShort;
    }

    public int getArea() {
        return area;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountryShort(String countryShort) {
        this.countryShort = countryShort;
    }

    public void setArea(int area) {
        this.area = area;
    }
    
    @Override
    public String toString() {
        return country;
    }
}
