package com.demo.repository;

import com.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    List<User> users;

    public UserRepository(){
        users = new ArrayList<>();
        User user = new User();
        user.setName("Alien");
        user.setId(1234322);

        User user2 = new User();
        user2.setName("Alien");
        user2.setId(12322);

        users.add(user);
        users.add(user2);

    }

//    public User getUser(int id){
//
//        return users.;
//    }

    public List<User> getUsers() {
        return users;
    }
}
