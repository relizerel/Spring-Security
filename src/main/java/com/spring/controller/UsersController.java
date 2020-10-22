package com.spring.controller;


import com.spring.model.User;
import com.spring.service.UserServiceImp;
import org.antlr.v4.codegen.model.ModelElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
@RequestMapping("/user/**")
public class UsersController {

    @GetMapping("userPage")
    public ModelAndView showUserForm(@AuthenticationPrincipal User user) {
        ModelAndView modelAndView = new ModelAndView("/user/userPage");
        modelAndView.addObject("userData", user);
        return modelAndView;
    }
}
