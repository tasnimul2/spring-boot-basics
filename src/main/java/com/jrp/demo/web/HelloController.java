package com.jrp.demo.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class HelloController {
    @RequestMapping("/basic")
    public String sayHello(){
        return "<h1>hey there!</h1>";
    }

    @RequestMapping("/proper")
    public String sayProperHello(){
        return "<h1>hey there! how are you?</h1>";
    }

    @RequestMapping("/user_entry")
    public String userForm(){
        return "<form action=\"/greeting/user_greeting\" method=\"POST\">\n" +
                "  <label for=\"fname\">First name:</label><br>\n" +
                "  <input type=\"text\" id=\"fname\" name=\"firstName\"><br>\n" +
                "  <label for=\"lname\">Last name:</label><br>\n" +
                "  <input type=\"text\" id=\"lname\" name=\"lastName\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> ";
    }
    @RequestMapping(value = "/user_greeting",method = RequestMethod.POST)
    public String printUserGreeting(@RequestParam String firstName, @RequestParam String lastName){
        return "<h1>Form Submitted!</h1>" + "<h3> Welcome, " + firstName + " " + lastName + "</h3>";
    }

    @RequestMapping(value="/orders/{id}",method = RequestMethod.GET)
    public String getOrder(@PathVariable String id){
        return "Order Id: " + id;
    }
}
