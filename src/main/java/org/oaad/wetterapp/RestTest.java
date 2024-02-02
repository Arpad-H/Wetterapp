package org.oaad.wetterapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestTest {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/restTest")
    @ResponseBody
    public ResponseEntity<String> getJsonFromApi() {
        String apiUrl = "https://api.open-meteo.com/v1/dwd-icon?latitude=52.2726&longitude=8.0498&hourly=temperature_2m"; // Replace with your API URL

        return restTemplate.getForEntity(apiUrl, String.class);
    }
}
