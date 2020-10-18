package com.spring.controller;


import com.spring.model.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;


@Controller
public class UsersController {

    private UserService userService;

    public UsersController(){}

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "users/")
    public ModelAndView index(){
        List<User> listUsers = userService.listUsers();
        ModelAndView modelAndView = new ModelAndView("users/users");
        modelAndView.addObject("allUsers", listUsers);
        return modelAndView;
    }

    @GetMapping(value = "/users/save")
    public String saveUser() {
        userService.saveUser(new User());
        return "redirect:/users/";
    }

    @PostMapping(value = "/users/update/{id}")
    public String updateUser(@PathVariable long id, User user) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/users/";
    }

    @GetMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User user = userService.getUser(id);
        userService.deleteUser(user);
        return "redirect:/users/";
    }

    @GetMapping(value = "/users/get/{id}")
    public ModelAndView getUser(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("users/get");
        modelAndView.addObject("getUser", userService.getUser(id));
        return modelAndView;
    }

    // Тут начинается настройка Security





    // Тут начинается куча мусора, можно удалить, но что-то может потом пригодиться

/*
    @GetMapping(value = "/save")
    @ResponseBody
    public User saveUser(@RequestBody User user) {
        return (User) userService.saveUser(user);
    }

    @GetMapping(value = "/update")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return (User) userService.updateUser(user);
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public User deleteUser(@RequestBody User user) {
        return (User) userService.deleteUser(user);
    }


    @GetMapping(value = "/find/{id}")
    @ResponseBody
    public User getUser(@PathVariable long id) {
        return (User) userService.getUser(id);
    }

 */

    /*
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("users");
    modelAndView.addObject("allUsers", userService.getAllUsers());
    return modelAndView;
}
 */
}
