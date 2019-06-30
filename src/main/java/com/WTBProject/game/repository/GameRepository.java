package com.WTBProject.game.repository;


import com.WTBProject.game.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository <Game, String>{
}
