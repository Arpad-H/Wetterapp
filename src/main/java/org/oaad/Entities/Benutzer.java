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

    /**
     * Checks if the user has a specific ort
     * @param ort Ort to check
     * @return true if the user has the ort, false if not
     */
    public boolean userHasOrt(Ort ort){
        for (Ort o : orte){
            if (o.getPlace_name().equals(ort.getPlace_name())){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the user has a specific ort
     * @param name Name of the ort to check
     * @return true if the user has the ort, false if not
     */
    public boolean userHasOrt(String name) {
        for (Ort o : orte) {
            if (o.getPlace_name().equals(name)) {
                return true;
            }
        }
        return false;

    }
    public void removeOrt(String name) {
        orte.removeIf(ort -> ort.getPlace_name().equals(name));
    }

    public ArrayList<Ort> getOrte() {
        return orte;
    }


    public void setOrte(ArrayList<Ort> orte) {
        this.orte = orte;
    }


    public String getName() {
        return name;
    }


    public Benutzer setName(String name) {
        this.name = name;
        return this;
    }


    public HashMap<String, Boolean> getSettings() {
        return settings;
    }


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
