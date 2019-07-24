package com.WTBProject.game.repository;


import com.WTBProject.game.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface GameRepository extends CrudRepository <Game, String>{
    List <Game> findByName(String gameName);

    List<Game> findByNameLikeOrderByNameAsc(String queryString);
}
