package org.oaad.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MockDB {
    ArrayList<String> availableFeatures;
    Random random;
    public MockDB(){
        random = new Random();
        availableFeatures = new ArrayList<>();
        availableFeatures.add("temperature_2m"); // Temperatur
        availableFeatures.add("apparent_temperature"); // gefühlte Temperatur
        availableFeatures.add("rain"); // Regen
        availableFeatures.add("cloud_cover"); // Wolken
    }
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

    public Ort getOrt(int ortId){
        double latitude, longitude;
        switch(ortId){
            case 0 : // Osnabrück
                latitude = 52.2726;
                longitude = 8.0498;
                break;
            case 1: //Münster
                latitude = 51.9624;
                longitude = 7.6257;
                break;
            case 2: //Hamburg
                latitude = 53.5507;
                longitude = 9.993;
                break;
            case 3: //Bayern
                latitude = 47.795;
                longitude = 12.5338;
                break;
            default: //Osnabrück
                latitude = 52.2726;
                longitude = 8.0498;
                break;
        }
        return new Ort(latitude, longitude);
    }
}
