package org.oaad.Entities;

import org.oaad.helperClasses.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * MockDB class
 * Represents a mock database for the application
 * Used to simulate a database
 * Used for testing purposes for the first increment
 * later replaced by a real database
 */

public class MockDB {
    HashMap<String, Benutzer> users = new HashMap<>();
    HashMap<Pair<Double, Double>, Ort> places = new HashMap<>();
    HashMap<String, Boolean> settings = new HashMap<>();
    public HashMap<Pair<Double, Double>, Ort> getPlaces() {
        return places;
    }

    /**
     * Constructor of the MockDB class
     * Initializes the mock database with Fake users and their settings
     */
    public MockDB() {

        Ort osnabrueck = new Ort(new Pair<>(52.2726, 8.0498), "Osnabrück");//Osnabrück
        Ort muenster = new Ort(new Pair<>(51.9624, 7.6257), "Münster");//Münster
        Ort hamburg = new Ort(new Pair<>(53.5507, 9.993), "Hamburg");//Hamburg
        Ort berlin = new Ort(new Pair<>(52.5244, 13.4105), "Berlin");//Berlin
        places.put(osnabrueck.getCoordinates(), osnabrueck);
        places.put(muenster.getCoordinates(),muenster);
        places.put(hamburg.getCoordinates(),hamburg);
        places.put(berlin.getCoordinates(), berlin);

        users.put("Jan", new Benutzer()
                .setName("Jan")
                .addOrt(osnabrueck)
                .addOrt(muenster)
                .addOrt(hamburg)
                .addSetting("temperature_2m", true)
                .addSetting("apparent_temperature", true)
                .addSetting("cloud_cover", false)
                .addSetting("rain", false));
        users.put("Alex", new Benutzer()
                .setName("Alex")
                .addOrt(hamburg)
                .addOrt(osnabrueck)
                .addSetting("temperature_2m", false)
                .addSetting("apparent_temperature", true)
                .addSetting("cloud_cover", false)
                .addSetting("rain", false));
        users.put("Arpad", new Benutzer()
                .setName("Arpad")
                .addOrt(osnabrueck)
                .addOrt(muenster)
                .addOrt(hamburg)
                .addOrt(berlin)
                .addSetting("temperature_2m", true)
                .addSetting("apparent_temperature", true)
                .addSetting("cloud_cover", true)
                .addSetting("rain", true));

        settings.put("temperature_2m", true);
        settings.put("apparent_temperature", true);
        settings.put("cloud_cover", true);
        settings.put("rain", true);

    }


    public Benutzer getUser(String name) {
        return users.get(name);
    }


    public ArrayList<Benutzer> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    /**
     * Gets the Place of the given coordinates
     * @param latitude latitude of the place
     * @param longitude longitude of the place
     * @return String name of the place
     */
    public String getPlace(double latitude, double longitude) {
        for (Pair<Double, Double> key : places.keySet()) {
            if (key.getFirst() < latitude + 0.1 && key.getFirst() > latitude - 0.1 && key.getSecond() < longitude + 0.1 && key.getSecond() > longitude - 0.1) {
                return places.get(key).getPlace_name();
            }
        }
        return "Unknown";

    }
    public Ort getPlace(String name) {
        for (Pair<Double, Double> key : places.keySet()) {
            if (places.get(key).getPlace_name().equals(name)) {
                return places.get(key);
            }
        }
        return null;


    }

    public void addPlace(Pair<Double, Double> coordinates, String place_name) {
        places.put(coordinates, new Ort(coordinates, place_name));
    }
    public Ort placeExists(String name){
        for (Pair<Double, Double> key : places.keySet()) {
            if (places.get(key).getPlace_name().equals(name)) {
                return places.get(key);
            }
        }
        return null;
    }
    public HashMap<String, Boolean> getSettings() {
        return settings;
    }
}
