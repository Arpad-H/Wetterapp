package org.oaad.wetterapp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WetterappIndex {
    @GetMapping("/")
    @ResponseBody
    public String HelloWorld() {
        return "Hello World!";
    }
}
