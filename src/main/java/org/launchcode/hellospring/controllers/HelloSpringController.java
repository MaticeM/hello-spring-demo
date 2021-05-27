package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello") //controller level
public class HelloSpringController {

    //10.1 in book
    //Handles request at path /hello/hello
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    //lives at /hello/goodbye because of controller level and method level
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //10.2.1 in book
    //Handles request of the form /hello?name=LaunchCode
    //Whatever is entered after the = in the web address is what is used as the name in the plain text (aka response body).
    //lives at /hello?name=(input a name minus parentheses) because of controller level
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //10.2.4 in book
    //Handles requests of the form /hello/LaunchCode
    //Whatever is entered after the forward slash in the web address is what is used at the name in the plain text (aka response body).
    //lives at /hello/hello/(input a name minus parentheses) because of controller level and method level
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //10.3 in book
    //lives at /hello/form because of controller level and method level
    //NOT WORKING where it lives
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type = 'text' name='name'>" +
                "<input type = 'submit' value = 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    //chapter 10 exercises below
    //lives at hello/form/exercise
    @RequestMapping(method= RequestMethod.GET, value = "form/exercise")
    public String helloFormExercise() {
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

    @RequestMapping(method= RequestMethod.POST, value = "form/exercise")
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

