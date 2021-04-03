package com.example.atos.controller;

import com.example.atos.entity.User;
import com.example.atos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> getUser(){
        final List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/update/{data}")
    public ResponseEntity<User> getAssignedUser(@PathVariable("data") String data) {
        final List<User> users = userService.getUsers();
        final Optional<User> first = users.stream()
                .filter(u -> u.getStatus().equalsIgnoreCase("Online"))
                .filter(u -> u.getRole().equalsIgnoreCase("Agent"))
                .filter(u -> u.getDocStatus().equalsIgnoreCase("Not Assigned")).findFirst();

        if (first.isPresent())
        {
            final User user = first.get();
            user.setDocStatus("Assigned");
            user.setAssignedXML(data);
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.notFound().build();
    }


}
