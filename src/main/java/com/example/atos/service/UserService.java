package com.example.atos.service;

import com.example.atos.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static List<User> userList = new ArrayList<>();
    static {
        init();
    }

    public List<User> getUsers(){
       return userList;
    }

    static void init(){
        userList.add( new User("Ramana","Online", "Agent","Assigned","879845.xml","Hazmat"));
        userList.add(new User("Suhas", "Online","Agent","Assigned", "12345678.xml","Hazmat"));
        userList.add(new User("Bhushan","Online","Agent","Not Assigned", "","Normal"));
        userList.add(new User("Kanti","Online","Agent","Not Assigned", "","Hazmat"));
    }



}
