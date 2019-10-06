package com.example.stackOverFlow.service;

import com.example.stackOverFlow.model.UserModel;
import com.example.stackOverFlow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void addUser(UserModel userModel){
        userRepository.save(userModel);
    }
    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }
    public UserModel getUserById(int id){
        return userRepository.findById(id).get();
    }
    public UserModel getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public void updateUser(UserModel userModel,int id){
        UserModel old = userRepository.getOne(id);
        if(old!=null)
           userRepository.updateUser(userModel.getEmail(),userModel.getPassword(),id);
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
    public List<UserModel> getVoteUpUsers(int ansId){
        return userRepository.getVoteUpUsers(ansId);
    }
    public List<UserModel> getVoteDownUsers(int ansId){
        return userRepository.getVoteDownUsers(ansId);
    }
    public List<UserModel> getBookmarkUsers(int ansId){
        return userRepository.getBookmarkUsers(ansId);
    }
}
