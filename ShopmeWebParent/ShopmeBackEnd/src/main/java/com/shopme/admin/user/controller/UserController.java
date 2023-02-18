package com.shopme.admin.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopme.admin.user.service.UserService;
import com.shopme.common.entity.User;

import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listAll(Model model) {
        List<User> listUser = userService.listAll();
        model.addAttribute("listUsers", listUser);
        return "users";
    }
}
