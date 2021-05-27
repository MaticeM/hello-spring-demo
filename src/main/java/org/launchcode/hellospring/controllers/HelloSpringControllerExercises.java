package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")

public class HelloSpringControllerExercises {

    @RequestMapping(method= RequestMethod.GET, value = "form")
    public String helloForm() {
        return "<form method= 'post'>" +
                "<input type='text' name='name'>" +
                "<select name = 'language'>" +
                "<option value = 'english'> English </option>" +
                "<option value = 'french'> French </option>" +
                "<option value = 'italian'> Italian </option>" +
                "<option value = 'spanish'> Spanish </option>" +
                "<option value = 'german'> German </option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet me!' />" +
                "</form>";
    }

    @RequestMapping(method= RequestMethod.POST, value = "form")
    public String createMessage(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        String greeting = "";

        if (language.equals("english")) {
            greeting = "Hello";
        } else if (language.equals("french")) {
            greeting = "Bonjour";
        } else if (language.equals("italian")) {
            greeting = "Ciao";
        } else if (language.equals("spanish")) {
            greeting = "Hola";
        } else if (language.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + ", " + name + "!";
    }

}
