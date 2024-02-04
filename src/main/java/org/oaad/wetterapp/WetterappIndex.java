package org.oaad.wetterapp;
import org.oaad.Entities.Benutzer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WetterappIndex {
    @GetMapping("/hello")
    @ResponseBody
    public String Hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}