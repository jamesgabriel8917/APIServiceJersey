package com.demo.resources;

import com.demo.model.User;
import com.demo.repository.UserRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("user")
public class UserResources {

    UserRepository userRepository = new UserRepository();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public User getUser(){
        User user = new User();
        user.setName("Alien");
        user.setId(1234322);

        return user;
    }

    public List<User> getUsers(){
        return userRepository.getUsers();
    }


}
