package com.example.atos.controller;

import com.example.atos.entity.User;
import com.example.atos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> getUser() {
        final List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/update/{data}")
    public ResponseEntity<User> getAssignedUser(@PathVariable("data") String data) {
        final List<User> users = userService.getUsers();
        final List<User> userList = new ArrayList<>();
        for (User u : users) {
            if (u.getStatus().equalsIgnoreCase("Online")) {
                if (u.getRole().equalsIgnoreCase("Agent")) {
                    if (u.getDocStatus().equalsIgnoreCase("Not Assigned")) {
                        userList.add(u);
                    }
                }
            }
        }

        if (userList != null && !userList.isEmpty()) {
            final Optional<User> hazmat = userList.stream().filter(user -> user.getDocType().equalsIgnoreCase("Hazmat")).findFirst();
            if (hazmat.isPresent()) {
                final User user = hazmat.get();
                user.setDocStatus("Assigned");
                user.setAssignedXML(data);
                return ResponseEntity.ok(user);
            } else {
                final Optional<User> assigned = userList.stream().map(user -> {
                    user.setDocStatus("Assigned");
                    user.setAssignedXML(data);
                    return user;
                }).findFirst();
                if (assigned.isPresent()) {
                    return ResponseEntity.ok(assigned.get());
                }
            }

        }
        return ResponseEntity.notFound().build();

    }
}
