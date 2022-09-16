package com.racing.webapprace.controllers;

import com.racing.webapprace.annotation.constraints.PhoneNumber;
import com.racing.webapprace.entity.Account;
import com.racing.webapprace.repo.AccountReposi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProfileController {

    @GetMapping("/")
    public String main(Model model) {
        return "profile1";

    }

    @Autowired
    private AccountReposi accountReposi;

    @GetMapping("/home")
    public String profile1(Model model) {
        Iterable<Account> accdata = accountReposi.findAll();
        model.addAttribute("accdata",accdata);
        return "profile1";

    }
    @GetMapping("/profile1")
    public String profile11(Model model) {
        Iterable<Account> accdata = accountReposi.findAll();
        model.addAttribute("accdata",accdata);
        return "profile1";

    }


    @GetMapping("/license/{id}")
    public String licensebyid(@PathVariable(value = "id") int id, Model model) {
        Optional<Account> accdt = accountReposi.findById(id);
        ArrayList<Account> res = new ArrayList<>();
        accdt.ifPresent(res::add);
        model.addAttribute("accdt",res);

        return "license";
    }
    @GetMapping("/profile/{id}")
    public String profile(@PathVariable(value = "id") int id, Model model) {
        Optional<Account> accdt = accountReposi.findById(id);
        ArrayList<Account> res = new ArrayList<>();
        accdt.ifPresent(res::add);
        model.addAttribute("accdt",res);
        return "profile";
    }

    @GetMapping("/profile/{id}/edit")
    public String profileedit(@PathVariable(value = "id") int id, Model model) {
        Optional<Account> accdt = accountReposi.findById(id);
        ArrayList<Account> res = new ArrayList<>();
        accdt.ifPresent(res::add);
        model.addAttribute("accdt",res);
        return "editprof1";
    }
    @Email
    @NotNull
    @Valid
    @PostMapping("/profile/{id}/edit")
    public String editprofpost(@PathVariable(value = "id") int id, @RequestParam @PhoneNumber String tel ,
                               @RequestParam String firstName , @RequestParam String lastName ,
                               @RequestParam String about , @RequestParam @Valid @NotNull @Email String email, Model model) {
        Account accdt = accountReposi.findById(id).orElseThrow();
        accdt.setTel(tel);
        accdt.setFirstName(firstName);
        accdt.setLastName(lastName);
        accdt.setAbout(about);
        accdt.setEmail(email);
       
        accountReposi.save(accdt);

        return "redirect:/profile/{id}";
    }
    @GetMapping("/allpr")
    public String profilescheck( Model model) {
        Iterable<Account> accdt = accountReposi.findAll();
        model.addAttribute("accdt",accdt);
        ArrayList<Account> res = new ArrayList<>();
        return "allpr";
    }


}