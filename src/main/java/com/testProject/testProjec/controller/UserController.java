package com.testProject.testProjec.controller;

import com.testProject.testProjec.dto.UserDTO;
import com.testProject.testProjec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping ("/getUser")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);


    }
    @PutMapping ("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }

    @GetMapping("/getUserById/{userId}")
    public UserDTO getUserByUserID(@PathVariable int userId){
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/getUserByData/{userId}/{address}")
    public UserDTO getUserByData(@PathVariable int userId,@PathVariable String address){
        return userService.getUserByData(userId,address);
    }
}
