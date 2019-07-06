//package com.WTBProject;
//
//import com.WTBProject.user.dto.UserDTO;
//import com.WTBProject.user.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import java.util.List;
//import java.util.Optional;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//  private final UserService userService;
//
//  @Autowired
//  public WebSecurityConfig(UserService userService) {
//    this.userService = userService;
//  }
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http
//      .csrf().disable()
//      .authorizeRequests()
//      .antMatchers("/").permitAll()
//      .anyRequest().authenticated()
//      .and()
//
//      .formLogin()
//      .loginPage("/login")
//      .permitAll()
//
//      .and()
//      .logout()
//      .invalidateHttpSession(true)
//      .deleteCookies("JSESSIONID")
//      .permitAll();
//  }
//
//  @Bean
//  @Override
//  public UserDetailsService userDetailsService() {
//
//    List<UserDTO> allUsers = userService.getAllUsers();
//    Optional<UserDTO> admin = allUsers.stream()
//      .filter(userDTO -> userDTO.getName().equals("admin"))
//      .findAny();
//    if (!admin.isPresent()) {
//      UserDTO user = new UserDTO("admin");
//      userService.saveUser(user);
//    }
//
//    UserDetails[] users = userService.getAllUsers().stream()
//      .map(this::createUser)
//      .toArray(UserDetails[]::new);
//    return new InMemoryUserDetailsManager(users);
//  }
//
//  private UserDetails createUser(UserDTO userDocument) {
//    if (userDocument.getName().equals("admin")) {
//      return User.withDefaultPasswordEncoder()
//        .username(userDocument.getName())
//        .password(userDocument.getPassword())
//        .roles("USER", "ADMIN")
//        .build();
//    } else {
//      return User.withDefaultPasswordEncoder()
//        .username(userDocument.getName())
//        .password(userDocument.getPassword())
//        .roles("USER")
//        .build();
//    }
//  }
//}
