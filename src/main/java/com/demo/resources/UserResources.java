package com.demo.resources;

import com.demo.model.User;
import com.demo.repository.UserRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;
import java.util.List;

@Path("user")
public class UserResources {

    UserRepository userRepository = new UserRepository();

    public UserResources() throws Exception {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("get")
    public User getUser(){

        return new User(123444, "aaaaa");
    }

    @POST
    @Path("create")
    public User createUSer(User user){
        System.out.println("User created");
        return user;
    }

    @PUT
    @Path("update")
    public List<User> getUsers() throws SQLException {
        return userRepository.ListUsers();
    }


}
