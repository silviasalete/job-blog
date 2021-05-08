package com.empregospernambuco1.controller;

import com.empregospernambuco1.service.UserService;
import com.empregospernambuco1.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationGet(Model model){
        model.addAttribute("user",new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPost(UserRegistrationDto userRegistrationDto){
        userService.save(userRegistrationDto);
        return "redirect:/user/registration?success";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    @GetMapping("/home")
    public String homeUser(Model model, Principal principal) {
        model.addAttribute("user", userService.findByEmail(principal.getName()));
        return "user/home";
    }
}
