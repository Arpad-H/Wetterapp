package org.oaad.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * MockDB class
 * Represents a mock database for the application
 * Used to simulate a database
 * Used for testing purposes for the first increment
 */
public class MockDB {
    ArrayList<String> availableFeatures;
    Random random;

    /**
     * Constructor of the MockDB class
     * Initializes the available features and the random object
     */
    public MockDB(){
        random = new Random();
        availableFeatures = new ArrayList<>();
        availableFeatures.add("temperature_2m"); // Temperatur
        availableFeatures.add("apparent_temperature"); // gefühlte Temperatur
        availableFeatures.add("rain"); // Regen
        availableFeatures.add("cloud_cover"); // Wolken
    }

    /**
     * Returns a user with the given name
     * contains random data for the settings and the orte
     * @param name Name of the user
     * @return Benutzer object
     */
    public Benutzer getUser(String name){
        HashMap<String, Boolean> settings = new HashMap<>();
        for(String avaiableFeature : availableFeatures){
            settings.put(avaiableFeature, random.nextBoolean());
        }
        ArrayList<Ort> orte = new ArrayList<>();
        int randomId = random.nextInt(4);
        orte.add(getOrt(randomId));
        if(random.nextBoolean()){
            int newRandomId;
            do{
                newRandomId = random.nextInt(4);
            }while(newRandomId == randomId);
            orte.add(getOrt(newRandomId));
        }
        return new Benutzer(name, settings, orte);
    }

    /**
     * Returns a Ort object for the given id
     *
     * @param ortId Id of the Ort
     * @return Ort object
     */
    public Ort getOrt(int ortId){
        double latitude, longitude;
        longitude = switch (ortId) {
            case 0 -> {
                latitude = 52.2726;
                yield 8.0498; // Osnabrück
            }
            case 1 -> {
                latitude = 51.9624;
                yield 7.6257; //Münster
            }
            case 2 -> {
                latitude = 53.5507;
                yield 9.993; //Hamburg
            }
            case 3 -> {
                latitude = 47.795;
                yield 12.5338; //Bayern
            }
            default -> {
                latitude = 52.2726;
                yield 8.0498; //Osnabrück
            }
        };
        return new Ort(latitude, longitude);
    }
}
