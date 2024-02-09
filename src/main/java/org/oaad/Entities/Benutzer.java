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
     * @param name String value of the name
     */
    public Benutzer(String name) {
        this.name = name;
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
    public void setName(String name) {
        this.name = name;
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
}
