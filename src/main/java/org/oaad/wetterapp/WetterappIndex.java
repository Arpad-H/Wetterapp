package org.oaad.wetterapp;

import org.oaad.Entities.MockDB;
import org.oaad.Entities.Ort;
import org.oaad.Entities.WeatherData;
import org.oaad.helperClasses.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;
import java.util.Objects;

/**
 * This class is the main controller of the application. It handles the requests and responses of the application.
 */
@Controller
public class WetterappIndex {

    private final MockDB mockDB = new MockDB();

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Handles the index page of the application.
     * injects message Thymeleaf attribute to the model
     *
     * @param model Model of the application
     * @return String value of the index pages name
     */
    @GetMapping("/index")
    public String Index(Model model) {
        model.addAttribute("users", mockDB.getAllUsers());
        return "index";
    }

    /**
     * Handles the user page of the application.
     *
     * @param user  Name of the user. Gets extracted from the URL
     * @param model Model of the application
     * @return String value of the user pages name
     */
    @GetMapping("/user")
    public String User(@RequestParam(value = "user", defaultValue = "") String user,
                       @RequestParam(value = "latitude", defaultValue = "0") String latitude,
                       @RequestParam(value = "longitude", defaultValue = "0") String longitude,
                       @RequestParam(value = "place_name", defaultValue = "0") String nameInput,
                       Model model) {
        if (user.isEmpty()) {
            return "index";
        }
        if (!Objects.equals(latitude, "0") && !Objects.equals(longitude, "0") && !Objects.equals(nameInput, "0")) {
            Ort newOrt = new Ort(new Pair<>(Double.parseDouble(latitude), Double.parseDouble(longitude)), nameInput);
            if (mockDB.placeExists(nameInput) == null) {
                mockDB.addPlace(newOrt.getCoordinates(), newOrt.getPlace_name());
            }
            if (!mockDB.getUser(user).userHasOrt(newOrt)) {
                mockDB.getUser(user).addOrt(newOrt);
            }
        }
        Gson gson = new Gson();

        model.addAttribute("user", mockDB.getUser(user).getName());
        model.addAttribute("users", mockDB.getAllUsers());
        ApiCaller api = new ApiCaller(restTemplate);
        String jsonString = api.getJson(mockDB.getUser(user)).getBody();
        System.out.println(jsonString);
        WeatherData[] weatherData = gson.fromJson(jsonString, WeatherData[].class);
        for (WeatherData data : weatherData) {
            data.setPlace_name(mockDB.getPlace(data.getLatitude(), data.getLongitude()));
        }
        model.addAttribute("fields", mockDB.getUser(user).getSettings());
        model.addAttribute("apiData", weatherData);
        return "user";
    }
    @GetMapping("/settings")
    public String Settings(@RequestParam(value = "user", defaultValue = "") String user, Model model) {
        if (user.isEmpty()) {
            return "index";
        }
        model.addAttribute("user", user);
        model.addAttribute("user_fields", mockDB.getUser(user).getSettings());
        model.addAttribute("user_places", mockDB.getUser(user).getOrte());
        model.addAttribute("all_fields", mockDB.getSettings());
        model.addAttribute("all_places", mockDB.getPlaces());
        return "settings";
    }
    @PostMapping("/submit")
    public String changeSettings(@RequestParam Map<String, String> formData) {

        for (Map.Entry<String, String> entry : formData.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Value: " + entry.getValue());
          //  mockDB
        }
       // return "index";
       return "redirect:/user?user=" +formData.get("user");
    }

}