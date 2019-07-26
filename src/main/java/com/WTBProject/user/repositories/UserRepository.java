package com.WTBProject.user.repositories;

import com.WTBProject.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByNickAndEmail(String nick, String email);

    List<User> findByNameLikeOrderByNameAsc(String queryString);


//    Optional findRegisteredUser(String nick, String password);
}
