package com.racing.webapprace.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegController {

    @GetMapping("/login")
    public String signin(Model model) {

        return "login";
    }

    @PostMapping("/login")
    public String signin1(Model model) {

        return "redirect:/";
    }

    @GetMapping("/registration")
    public String reg() {

        return "regi";
    }
    @PostMapping("/registration")
    public String regpost() {

        return "regi";
    }

}