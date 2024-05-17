package com.testProject.testProjec.service;

import com.testProject.testProjec.dto.UserDTO;
import com.testProject.testProjec.entity.User;
import com.testProject.testProjec.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
     public UserDTO saveUser(UserDTO userDTO){
         userRepo.save(modelMapper.map(userDTO, User.class ));
         return userDTO;
     }
     public List<UserDTO> getAllUsers(){
         List<User>userList=userRepo.findAll();
         return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
     }

     public UserDTO updateUser(UserDTO userDTO){
         userRepo.save(modelMapper.map(userDTO,User.class));
         return userDTO;
     }

     public boolean deleteUser(UserDTO userDTO){
         userRepo.delete(modelMapper.map(userDTO,User.class));
         return true;
     }

     //user id > user details
    public UserDTO getUserByUserId(int userID){
         User user=userRepo.getUserById(userID);
         return modelMapper.map(user,UserDTO.class);
    }

    //user id,address > user details

    public UserDTO getUserByData(int userID,String address){
         User user=userRepo.getUserByData(userID,address);
         return modelMapper.map(user,UserDTO.class);
    }
}
