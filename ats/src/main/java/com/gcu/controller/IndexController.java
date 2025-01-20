package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("title", "Home");
        return "index"; 
    }
}


