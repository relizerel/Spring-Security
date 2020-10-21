package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class Index{

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("This is a test page");
        messages.add("To view the program, follow the link below");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping(value = "/admin/adminPage")
    public String admin() {
        return "/admin/adminPage";
    }
    @GetMapping(value = "/user/userPage")
    public String user() {
        return "/user/userPage";
    }
}
