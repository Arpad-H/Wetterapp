package org.oaad.Entities;

public class Ort {
    double latitude, longitude;
    int temperature_2m_current; // Temperatur
    int apparent_temperature_current; // gefühlte Temperatur
    int rain_current; // Regen
    int cloud_cover_current; // Wolken
    public Ort(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
