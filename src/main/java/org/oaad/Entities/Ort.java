package org.oaad.Entities;

import org.oaad.helperClasses.Pair;

/**
 * Ort class
 * Represents a location and the weather at that location
 */
public class Ort {
   private Pair<Double, Double> coordinates;

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    private String place_name;
    int temperature_2m_current; // Temperatur
    int apparent_temperature_current; // gefühlte Temperatur
    int rain_current; // Regen
    int cloud_cover_current; // Wolken


    public Ort(Pair<Double, Double> coordinates, String place_name) {
        this.coordinates = coordinates;
        this.place_name = place_name;
    }

    public Pair<Double, Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Pair<Double, Double> coordinates) {
        this.coordinates = coordinates;
    }
}
