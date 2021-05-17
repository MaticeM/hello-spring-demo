package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello") //controller level
public class HelloSpringController {

    //10.1 in book
    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye because of controller level and method level
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //10.2.1 in book
    //Handles request of the form /hello?name=LaunchCode
    //Whatever is entered after the = in the web address is what is used as the name in the plain text (aka response body).
    //lives at /hello because of controller level
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //10.2.4 in book
    //Handles requests of the form /hello/LaunchCode
    //Whatever is entered after the forward slash in the web address is what is used at the name in the plain text (aka response body).
    //lives at /hello/hello?name= because of controller level and method level
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //10.3 in book
    //lives at /hello/form because of controller level and method level
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
}

