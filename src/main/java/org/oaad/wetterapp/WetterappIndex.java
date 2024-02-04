package org.oaad.wetterapp;
import org.oaad.Entities.Benutzer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class WetterappIndex {

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
        Benutzer mockUser = new Benutzer("Jan",new HashMap<String, Boolean>());
        Benutzer mockUser1 = new Benutzer("Alex",new HashMap<String, Boolean>());
        Benutzer mockUser2 = new Benutzer("Arpad",new HashMap<String, Boolean>());
        HashMap<String, Benutzer> mockMap = new HashMap<String, Benutzer>();
        mockMap.put("Jan",mockUser);
        mockMap.put("Alex",mockUser1);
        mockMap.put("Arpad",mockUser2);

        model.addAttribute("user", mockMap.get(user).getName());
        return "user";
    }

}