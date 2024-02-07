package org.oaad.Entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Benutzer {
    String name;
    HashMap<String, Boolean> settings;
    ArrayList<Ort> orte;

    public Benutzer(String name, HashMap<String, Boolean> settings) {
        this.name = name;
        this.settings = settings;
    }

    public Benutzer(String name, HashMap<String, Boolean> settings, ArrayList<Ort> orte) {
        this.name = name;
        this.settings = settings;
        this.orte = orte;
    }

    public ArrayList<Ort> getOrte() {
        return orte;
    }

    public void setOrte(ArrayList<Ort> orte) {
        this.orte = orte;
    }

    public Benutzer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Boolean> getSettings() {
        return settings;
    }

    public void setSettings(HashMap<String, Boolean> settings) {
        this.settings = settings;
    }
}
