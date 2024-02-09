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


/**
 * This class is the main controller of the application. It handles the requests and responses of the application.
 */
@Controller
public class WetterappIndex {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * This method extracts the name from the url and returns a greeting with the name.
     * @param name
     * @return String value of the name variable in the URL
     */
    @GetMapping("/hello")
    @ResponseBody
    public String Hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    /**
     * Handles the index page of the application.
     * injects message Thymeleaf attribute to the model
     * @param model Model of the application
     * @return String value of the index pages name
     */
    @GetMapping("/index")
    public String ThymeTest(Model model) {
        model.addAttribute("message", "Thymeleaf");
        return "thymetest";
    }

    /**
     * Handles the user page of the application.
     * @param user  Name of the user. Gets extracted from the URL
     * @param model Model of the application
     * @return String value of the user pages name
     */
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
        System.out.println(api.getJson(mockMap.get(user)));
        return "user";
    }

}