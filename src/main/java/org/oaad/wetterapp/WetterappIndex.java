package org.oaad.wetterapp;
import org.oaad.Entities.Benutzer;
import org.oaad.Entities.MockDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Controller
public class WetterappIndex {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/hello")
    @ResponseBody
    public String Hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    @GetMapping("/index")
    public String ThymeTest(Model model) {
        model.addAttribute("message", "Thymeleaf");
        return "thymetest";
    }
    @GetMapping("/user")
    public String User(@RequestParam(value = "user", defaultValue = "World") String user,Model model) {
        MockDB mockDB = new MockDB();
        HashMap<String, Benutzer> mockMap = new HashMap<String, Benutzer>();
        mockMap.put("Jan", mockDB.getUser("Jan"));
        mockMap.put("Alex", mockDB.getUser("Alex"));
        mockMap.put("Arpad", mockDB.getUser("Arpad"));

        model.addAttribute("user", mockMap.get(user).getName());

        ApiCaller api = new ApiCaller(restTemplate);
        model.addAttribute("weatherData", api.getJson(mockMap.get(user)));

        return "user";
    }

}