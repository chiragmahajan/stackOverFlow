package com.example.stackOverFlow.controller;

import com.example.stackOverFlow.model.UserModel;
import com.example.stackOverFlow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/getAllUsers", method = { RequestMethod.GET })
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }
    @RequestMapping(value = "/getUser/{id}", method = { RequestMethod.GET })
    public UserModel getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @RequestMapping(value = "/getUserByEmail/{email}", method = { RequestMethod.GET })
    public UserModel getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
    @RequestMapping(value = "/addUser",method = {RequestMethod.POST},consumes = "application/json")
    public void addUser(@RequestBody UserModel userModel){
        userService.addUser(userModel);
    }
    @RequestMapping(value = "/updateUser/{id}" ,method = { RequestMethod.PUT }, consumes = "application/json")
    public void updateUser(@RequestBody UserModel userModel,@PathVariable int id){
        userService.updateUser(userModel,id);
    }
    @RequestMapping(value = "/deleteUser/{id}", method = { RequestMethod.GET })
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
    @RequestMapping(value = "/getUpVoteUsers/{ansId}", method = { RequestMethod.GET })
    public List<UserModel> getUpVoteUsers(@PathVariable int ansId){
        return userService.getVoteUpUsers(ansId);
    }
    @RequestMapping(value = "/getDownVoteUsers/{ansId}", method = { RequestMethod.GET })
    public List<UserModel> getDownVoteUsers(@PathVariable int ansId){
        return userService.getVoteDownUsers(ansId);
    }
    @RequestMapping(value = "/getBookmarkUsers/{ansId}", method = { RequestMethod.GET })
    public List<UserModel> getBookmarkUsers(@PathVariable int ansId){
        return userService.getBookmarkUsers(ansId);
    }
}
