package org.oaad.Entities;

/**
 * Ort class
 * Represents a location and the weather at that location
 */
public class Ort {
    double latitude, longitude;
    int temperature_2m_current; // Temperatur
    int apparent_temperature_current; // gefühlte Temperatur
    int rain_current; // Regen
    int cloud_cover_current; // Wolken

    /**
     * Constructor for the Ort class
     * @param latitude latitude of the location
     * @param longitude longitude of the location
     */
    public Ort(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Getter for the latitude
     * @return double value of the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Setter for the latitude
     * @param latitude double value of the latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Getter for the longitude
     * @return double value of the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Setter for the longitude
     * @param longitude double value of the longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
