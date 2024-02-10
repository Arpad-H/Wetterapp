package org.oaad.Entities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Benutzer class
 * Represents a user of the application
 * Contains the name, settings and orte of the user
 */
public class Benutzer {

    String name;
    HashMap<String, Boolean> settings;
    ArrayList<Ort> orte;

    public Benutzer() {
          this.orte = new ArrayList<>();
          this.settings = new HashMap<>();
    }
    /**
     * Constructor of the Benutzer class
     * @param name Name of the user
     * @param settings HashMap of the settings of the user
     */
    public Benutzer(String name, HashMap<String, Boolean> settings) {
        this.name = name;
        this.settings = settings;
    }

    /**
     * Constructor of the Benutzer class
     * @param name Name of the user
     * @param settings HashMap of the settings of the user
     * @param orte ArrayList of the orte of the user
     */
    public Benutzer(String name, HashMap<String, Boolean> settings, ArrayList<Ort> orte) {
        this.name = name;
        this.settings = settings;
        this.orte = orte;
    }
public boolean userHasOrt(Ort ort){
        for (Ort o : orte){
            if (o.getPlace_name().equals(ort.getPlace_name())){
                return true;
            }
        }
        return false;
}
    /**
     * Getter for the orte
     * @return ArrayList of the orte
     */
    public ArrayList<Ort> getOrte() {
        return orte;
    }

    /**
     * Setter for the orte
     * @param orte ArrayList of the orte
     */
    public void setOrte(ArrayList<Ort> orte) {
        this.orte = orte;
    }

    /**
     * Getter for the name
     * @return String value of the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name
     * @param name String value of the name
     */
    public Benutzer setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for the settings
     * @return HashMap of the settings
     */
    public HashMap<String, Boolean> getSettings() {
        return settings;
    }

    /**
     * Setter for the settings
     * @param settings HashMap of the settings
     */
    public void setSettings(HashMap<String, Boolean> settings) {
        this.settings = settings;
    }

    public Benutzer addOrt(Ort ort){
        this.orte.add(ort);
        return this;
    }
    public Benutzer addSetting(String setting, Boolean value){
        this.settings.put(setting, value);
        return this;
    }

}
