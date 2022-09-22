package com.pluralsight.conference2.controller;

import com.pluralsight.conference2.model.Registration;
import com.pluralsight.conference2.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController //forces app to look at content type and Rest headers to see what should be returned.
public class UserController {


    @GetMapping("/user")
    public User getUser(@RequestParam(value = "fName", defaultValue = "giovanni") String fName,
                        @RequestParam(value = "lName", defaultValue = "giorgio") String lName,
                        @RequestParam(value = "age", defaultValue = "267") int age){
    User user = new User();

        user.setfName(fName);
        user.setlName(lName);
        user.setAge(age);

    return user;

    }


    @PostMapping("/user")
    public User postUser(User user){
        System.out.println("User first name:"+user.getfName());
    return user;
    }

}
