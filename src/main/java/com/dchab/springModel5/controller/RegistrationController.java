package com.dchab.springModel5.controller;


import com.dchab.springModel5.domain.Role;
import com.dchab.springModel5.domain.User;
import com.dchab.springModel5.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;


    @GetMapping("/registration")
    public String registration(){
        return "regisrtation";
    }

   @PostMapping("/registration")
     public String addUser(User user, Map<String,Object> model){
      User userFromOb = userRepo.findByUsername(user.getUsername());
       if (userFromOb != null){
           model.put("message", "User exists!" );
           return "registration";


       }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);  // создает сет с одним значением

      return "redirect:/login";

    }

}
