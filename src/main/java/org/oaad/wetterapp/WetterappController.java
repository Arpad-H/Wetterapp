package org.oaad.wetterapp;

import org.oaad.Entities.Benutzer;
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
public class WetterappController {

    private final MockDB mockDB = new MockDB();

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Handles the index page of the application.
     * @param model Model of the application
     * @return index.html
     */
    @GetMapping(value = {"/index", "/"})
    public String Thyme(Model model) {
        model.addAttribute("users", mockDB.getAllUsers());
        return "index";
    }

    /**
     * Handles the user page of the application.
     * Displays the weather data of the user and the settings of the user.
     * Also handles the adding of new places to the user. If the place does not exist in the database, it will be added.
     * If the place exists in the database, it will be added to the user.
     * @param user current user
     * @param latitude latitude of the place
     * @param longitude longitude of the place
     * @param nameInput name of the place
     * @param model Model of the application
     * @return user.html
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
        Benutzer currentUser = mockDB.getUser(user);
        if (!Objects.equals(latitude, "0") && !Objects.equals(longitude, "0") && !Objects.equals(nameInput, "0")) {
            Ort newOrt = new Ort(new Pair<>(Double.parseDouble(latitude), Double.parseDouble(longitude)), nameInput);
            if (mockDB.placeExists(nameInput) == null) {
                mockDB.addPlace(newOrt.getCoordinates(), newOrt.getPlace_name());
            }
            if (!currentUser.userHasOrt(newOrt)) {
                currentUser.addOrt(newOrt);
            }
        }
        Gson gson = new Gson();

        model.addAttribute("user", currentUser.getName());
        model.addAttribute("users", mockDB.getAllUsers());
        ApiCaller api = new ApiCaller(restTemplate);
        String jsonString = api.getJson(currentUser).getBody();
        System.out.println(jsonString);
        if (jsonString.charAt(0) == '[') {
            WeatherData[] weatherData = gson.fromJson(jsonString, WeatherData[].class);
            for (WeatherData data : weatherData) {
                data.setPlace_name(mockDB.getPlace(data.getLatitude(), data.getLongitude()));
            }
            model.addAttribute("fields", currentUser.getSettings());
            model.addAttribute("apiData", weatherData);
            return "user";
        } else {
            WeatherData weatherData = gson.fromJson(jsonString, WeatherData.class);
            weatherData.setPlace_name(mockDB.getPlace(weatherData.getLatitude(), weatherData.getLongitude()));
            model.addAttribute("fields", currentUser.getSettings());
            model.addAttribute("apiData", weatherData);
            return "user";
        }

    }

    /**
     * Displays the settings of the user also
     * and allows him to change them.
     * @param user current user
     * @param model Model of the application
     * @return settings.html
     */
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

    /**
     * Handles submit of the settings page.
     * Changes the settings of the user and the places of the user.
     * @param formData Map of the form data
     * @return Redirects to the user page of current user
     */
    @PostMapping("/submit")
    public String changeSettings(@RequestParam Map<String, String> formData) {
        Benutzer currentUser = mockDB.getUser(formData.get("user"));
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Value: " + entry.getValue());
            if (entry.getKey().contains("settings_")) {
                currentUser.getSettings().put(entry.getKey().substring(9), entry.getValue().equals("on"));
            }
            if (entry.getKey().contains("place_")) {
                Ort ort = mockDB.getPlace(entry.getKey().substring(6));
                if (entry.getValue().equals("on")) {
                    if (!currentUser.userHasOrt(ort.getPlace_name())) {
                        currentUser.addOrt(ort);
                    }
                } else if (entry.getValue().equals("off")) {
                    if (currentUser.userHasOrt(ort.getPlace_name())) {
                        currentUser.removeOrt(ort.getPlace_name());
                    }
                }
            }

        }
        return "redirect:/user?user=" + formData.get("user");
    }


}