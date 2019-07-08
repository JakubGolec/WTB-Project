package com.WTBProject.user.controller;

import com.WTBProject.user.dto.UserDTO;
import com.WTBProject.user.model.User;
import com.WTBProject.user.repositories.UserRepository;
import com.WTBProject.user.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

  private UserService userService;
  private UserRepository userRepository;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }


  @GetMapping("/allUsersPage")
  public String displayAllUsers(Model model) {
    List<UserDTO> allUserDTOS = userService.getAllUsers();
    model.addAttribute("allUsers", allUserDTOS);
    model.addAttribute("newUser", new UserDTO("admin"));
    model.addAttribute("queryString", "");
    return "allUsersPage";
  }

  //  @Secured("ROLE_ADMIN")
  @PostMapping("/addUserAction")
  public String addNewUser(@ModelAttribute("newUser") UserDTO userDTO, Model model) {
    userService.saveUser(userDTO);
    List<UserDTO> updatedUserDTOList = userService.getAllUsers();
    model.addAttribute("allUsers", updatedUserDTOList);
    return "redirect:/allUsersPage";
  }

  @GetMapping("/searchUserAction")
  public String searchUserByNick(String queryString, Model model) {
    List<UserDTO> foundUsers = userService.findByQueryString(queryString);

    model.addAttribute("allUsers", foundUsers);
    model.addAttribute("newUser", new UserDTO("admin"));
    model.addAttribute("queryString", "");

    return "allUsersPage";
  }

//@PostMapping("/login")
//  public
//}

}
