package com.cydeo.user_creation.controller;


import com.cydeo.user_creation.enums.State;
import com.cydeo.user_creation.model.User;
import com.cydeo.user_creation.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        //TODO we would like to retrieve all users stored in the database by relevant html.
        model.addAttribute("users", userService.getUsers());

        return "/user/register-page";
    }

    @GetMapping("/create-page")
    public String getFormPage(Model model) {
        //TODO we would like to get form with necessary models
        model.addAttribute("user", new User());
        model.addAttribute("states", State.values());

        return "/user/create-page";
    }

    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        //TODO register a new user with validation
        if(bindingResult.hasErrors()){
            model.addAttribute("states", State.values());
            return "/user/create-page";
        }

        userService.save(user);

        return "redirect:/user/register";
    }

    @GetMapping("/update/{email}")
    public String updateUser(@PathVariable String email, Model model) {
        //TODO we would like to get a form page with target user to update its required fields
        model.addAttribute("user", userService.findByEmail(email));
        model.addAttribute("states", State.values());

        return "/user/update-page";
    }

    @PostMapping("/update")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        //TODO register again updated user with validation
        if(bindingResult.hasErrors()){
            model.addAttribute("states", State.values());
            return "/user/update-page";
        }

        userService.update(user);

        return "redirect:/user/register";

    }

    @GetMapping("/{email}")
    public String getUser(@PathVariable String email, Model model) {

        //TODO get specific user to show it in ui

        model.addAttribute("user", userService.findByEmail(email));

        return "/user/user-page";
    }

    @GetMapping("/delete/{email}")
    public String deleteUser(@PathVariable String email) {
        //todo delete user based on email information

        userService.deleteByEmail(email);

        return "redirect:/user/register";
    }

    @GetMapping
    public String getAllWithFirstName(@RequestParam("search") String search, Model model) {
        //TODO use search function with request param. Find corresponding method by service class.
        model.addAttribute("users", userService.findAllUsersWithFirstName(search));


        return "/user/register-page";
    }

}
