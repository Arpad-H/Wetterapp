package org.oaad.wetterapp;

import org.oaad.Entities.Benutzer;
import org.oaad.Entities.Ort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class ApiCaller{

    @Autowired
    private RestTemplate restTemplate;
    public String buildUrl(Benutzer user){
        StringBuilder apiUrl = new StringBuilder();
        apiUrl.append("https://api.open-meteo.com/v1/forecast?");

        apiUrl.append("latitude=");
        for(Ort ort : user.getOrte()){
            apiUrl.append(ort.getLatitude()).append(",");
        }
        apiUrl.deleteCharAt(apiUrl.lastIndexOf(apiUrl.toString()));

        apiUrl.append("&longitude=");
        for(Ort ort : user.getOrte()){
            apiUrl.append(ort.getLongitude()).append(",");
        }
        apiUrl.deleteCharAt(apiUrl.lastIndexOf(apiUrl.toString()));

        apiUrl.append("&current=");
        for(Map.Entry<String, Boolean> entry : user.getSettings().entrySet()) {
            String setting = entry.getKey();
            Boolean activated = entry.getValue();

            if(activated){
                apiUrl.append(setting).append(",");
            }
        }
        apiUrl.deleteCharAt(apiUrl.lastIndexOf(apiUrl.toString()));

        return apiUrl.toString();
    }

    public ResponseEntity<String> getJson(String url){
        return restTemplate.getForEntity(url, String.class);
    }
    public ResponseEntity<String> getJson(Benutzer user){
        return restTemplate.getForEntity(buildUrl(user), String.class);
    }
}
