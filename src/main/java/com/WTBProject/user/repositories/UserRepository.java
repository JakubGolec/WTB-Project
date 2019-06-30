package com.WTBProject.user.repositories;

import com.WTBProject.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {

    User findByName(String userName);

    List<User> findByNameLikeOrderByNameAsc(String queryString);

//    Optional findRegisteredUser(String nick, String password);
}
