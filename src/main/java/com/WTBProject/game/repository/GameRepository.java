package com.WTBProject.game.repository;


import com.WTBProject.game.model.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository <Game, String>{
    List <Game> findByName(String gameName);

    List<Game> findByNameLikeOrderByNameAsc(String queryString);
}
