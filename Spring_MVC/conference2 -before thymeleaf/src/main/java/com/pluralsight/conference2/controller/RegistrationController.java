package com.pluralsight.conference2.controller;

import com.pluralsight.conference2.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //view resolver
public class RegistrationController {

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration") Registration registration) {
        return "registration";
    }
    @PostMapping("registration")
    public String addRegistration(@ModelAttribute("registration") Registration registration) {
        System.out.println("registration: " + registration.getName());
        return "redirect:registration"; // refers to registration.jsp using application.properties prefix and suffix. Clears form
    }


    
}
