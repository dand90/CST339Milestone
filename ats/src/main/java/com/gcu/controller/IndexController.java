package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Controller to root URL to return home page
 * 
 * @param model object to pass view
 * @return home page view
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("title", "Home");
        return "index"; 
    }
}


