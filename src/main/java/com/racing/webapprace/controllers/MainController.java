package com.racing.webapprace.controllers;

import com.racing.webapprace.entity.Account;
import com.racing.webapprace.entity.Timetable;
import com.racing.webapprace.repo.AccountReposi;
import com.racing.webapprace.repo.TImetableReposi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private TImetableReposi timetableReposi;

    @GetMapping("/train")
    public String train(Model model) {
        Iterable<Timetable> tmtbl = timetableReposi.findAll();
        model.addAttribute("tmtbl",tmtbl);

        return "trening";
    }


    @PostMapping("/train/edit")
    public String edittraintpost(@RequestParam String name ,Model model) {
        Timetable tmtbl = new Timetable(name);
        timetableReposi.save(tmtbl);
        return "redirect:/train";
    }
    @Autowired
    private AccountReposi accountReposi;

    @GetMapping("/train/{id}")
    public String profile(@PathVariable(value = "id") int id, Model model) {
        Iterable<Timetable> tmtbl = timetableReposi.findAll();
        model.addAttribute("tmtbl",tmtbl);
        Optional<Account> accdt = accountReposi.findById(id);
        ArrayList<Account> res = new ArrayList<>();
        accdt.ifPresent(res::add);
        model.addAttribute("accdt",res);
        return "trening";
    }

    @Transactional
    @PostMapping("/train/{id}")
    public String trainrec(@PathVariable(value = "id") int id, @RequestParam int active , Model model) {
        Account accdat = accountReposi.findById(id).orElseThrow();
        accdat.setActive(active);
        accountReposi.save(accdat);

        return "trening";
    }





}