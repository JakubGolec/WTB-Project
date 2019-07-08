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

    return allUsers.stream()
      .map(user -> modelMapper.map(user, UserDTO.class))
      .collect(Collectors.toList());
  }

  public UserDTO getUserById(String id) {
    Optional<User> foundUserOption = userRepository.findById(id);

    if (foundUserOption.isPresent()) {
      return modelMapper.map(foundUserOption.get(), UserDTO.class);
    }
    throw new IllegalArgumentException("User with such id not found");

  }

//    public UserDTO getUserByNickAndPassword(String nick, String password) {
//        Optional<User> foundUserOption = userRepository.findRegisteredUser(nick, password);
//
//        if (foundUserOption.isPresent()) {
//            return modelMapper.map(foundUserOption.get(), UserDTO.class);
//        }
//        throw new IllegalArgumentException("Wrong nick or password");
//
//    }

  public List<UserDTO> findByQueryString(String queryString) {
    List<User> foundUsers = userRepository.findByNameLikeOrderByNameAsc(queryString);
    return userRepository
      .findByNameLikeOrderByNameAsc(queryString)
      .stream()
      .map(user -> modelMapper.map(user, UserDTO.class))
      .collect(Collectors.toList());
  }


  private boolean validateUser(UserDTO userDTO) {
    String name = userDTO.getName();
    String surname = userDTO.getSurname();
    String nick = userDTO.getNick();
    if (name.length() < 1 || name.length() > 100) {
      return false;
    }
    if (surname.length() < 1 || surname.length() > 100) {
      return false;
    }
    if (nick.length() < 3 || nick.length() > 100) {
      return false;
    }

    return true;
  }


  public Long saveUser(UserDTO userDTO) {
    User userToSave = modelMapper.map(userDTO, User.class);
    User insertedUser = userRepository.save(userToSave);
    return insertedUser.getId();
  }

  public UserDTO findByNickAndEmail(String nick,String email){
    Optional<User> foundUserOption = userRepository.findByNickAndEmail(nick, email);

    if (foundUserOption.isPresent()) {
      return modelMapper.map(foundUserOption.get(), UserDTO.class);
    }
    throw new IllegalArgumentException("User with such id not found");

  }


}


