package com.shopme.admin.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.admin.user.UserRepository;

import java.util.*;
import com.shopme.common.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }

}
