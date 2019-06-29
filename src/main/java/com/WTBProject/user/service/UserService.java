package com.WTBProject.user.service;

import com.WTBProject.user.model.User;
import com.WTBProject.user.dto.UserDTO;
import com.WTBProject.user.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:values.properties")
public class UserService {
    private final UserRepository userRepository;
    private ModelMapper modelMapper;


    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    public List<UserDTO> getAllUsers() {
        List<User> allUsers = (List<User>) userRepository.findAll();
        //UserDocument userDocument= new UserDocument();
        //UserDTO map = modelMapper.map(userDocument, UserDTO.class);

        return allUsers.stream()
                .map(userDocument -> modelMapper.map(userDocument, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(String id) {
        Optional<User> foundUserOption = userRepository.findById(id);

        if (foundUserOption.isPresent()) {
            return modelMapper.map(foundUserOption.get(), UserDTO.class);
        }
        throw new IllegalArgumentException("User with id not found");

    }

    public List<UserDTO> findByQueryString(String queryString) {
        List<User> foundUsers = userRepository.findByNameLikeOrderByNameAsc(queryString);
        return userRepository
                .findByNameLikeOrderByNameAsc(queryString)
                .stream()
                .map(userDocument -> modelMapper.map(userDocument, UserDTO.class))
                .collect(Collectors.toList());
    }


    private boolean validateUser(UserDTO userDTO) {
        String name = userDTO.getName();
        if (name.length() < 1 || name.length() > 100) {
            return false;
        }

        return true;
    }


    public Long saveUser(UserDTO userDTO) {
        User userToSave = modelMapper.map(userDTO, User.class);
        User insertedUser = userRepository.save(userToSave);
        return insertedUser.getId();
    }


    public String saveUser(String userName) {
        return "";
    }

}

