package com.WTBProject.user.controller;
import com.WTBProject.user.dto.UserDTO;
import com.WTBProject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public UserDTO getUserById(@RequestParam("id") String id) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/user")
    public Long saveUser(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("nick") String nick, @RequestParam("password") String password, @RequestParam("email") String email) {

        UserDTO userDTO = new UserDTO(name, surname, nick, password, email);
        return userService.saveUser(userDTO);
    }

}