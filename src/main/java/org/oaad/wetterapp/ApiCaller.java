package org.oaad.wetterapp;

import org.oaad.Entities.Benutzer;
import org.oaad.Entities.Ort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * This class is responsible for calling the API and building the URL for the API.
 */
public class ApiCaller{

    private final RestTemplate restTemplate;

    /**
     * Constructor for the ApiCaller class
     * @param restTemplate RestTemplate object
     */
    public ApiCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * This method builds the URL for the API
     * @param user Benutzer object
     * @return String value of the API URL
     */
    public String buildUrl(Benutzer user){
        StringBuilder apiUrl = new StringBuilder();
        apiUrl.append("https://api.open-meteo.com/v1/forecast?");

        apiUrl.append("latitude=");
        for(Ort ort : user.getOrte()){
            apiUrl.append(ort.getCoordinates().getFirst()).append(",");
        }
        apiUrl.deleteCharAt(apiUrl.lastIndexOf(","));

        apiUrl.append("&longitude=");
        for(Ort ort : user.getOrte()){
            apiUrl.append(ort.getCoordinates().getSecond()).append(",");
        }
        apiUrl.deleteCharAt(apiUrl.lastIndexOf(","));

        apiUrl.append("&current=");
        for(Map.Entry<String, Boolean> entry : user.getSettings().entrySet()) {
            String setting = entry.getKey();
            Boolean activated = entry.getValue();

            if(activated){
                apiUrl.append(setting).append(",");
            }
        }
        System.out.println(apiUrl.toString());
        return apiUrl.toString();
    }

    /**
     * This method sends a request to the API
     * @param url String value of the API URL
     * @return ResponseEntity<String> of the API response
     */
    public ResponseEntity<String> getJson(String url){
        return restTemplate.getForEntity(url, String.class);
    }

    /**
     * This method sends a request to the API
     * @param user Benutzer object
     * @return ResponseEntity<String> of the API response
     */
    public ResponseEntity<String> getJson(Benutzer user){
        return restTemplate.getForEntity(buildUrl(user), String.class);
    }
}
