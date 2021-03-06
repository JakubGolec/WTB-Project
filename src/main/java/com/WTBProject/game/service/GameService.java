package com.WTBProject.game.service;

import com.WTBProject.game.dto.GameDTO;
import com.WTBProject.game.model.Game;
import com.WTBProject.game.repository.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GameService(GameRepository gameRepository, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }


    public List<GameDTO> getAllGames() {
        List<Game> allGames = (List<Game>) gameRepository.findAll();
        return allGames
                .stream()
                .map(games -> modelMapper.map(games, GameDTO.class))
                .collect(Collectors.toList());
    }

    public Long saveGame(GameDTO newGame) {
        Game gameToSave = modelMapper.map(newGame, Game.class);
        Game savedGame = gameRepository.save(gameToSave);
        return savedGame.getId();
    }

    //TODO gdyby mogło się przydać
  /* public GameDTO getGameById(String id) {
        Optional<Game> foundGameOption = gameRepository.findById(id);

        if (foundGameOption.isPresent()) {
            return modelMapper.map(foundGameOption.get(), GameDTO.class);
        }
        throw new IllegalArgumentException("Game with such id not found");
    }
*/

    public List<GameDTO> findGameByName(String gameName) {
        List<Game> foundGames = gameRepository.findByName(gameName);
        return gameRepository
                .findByName(gameName)
                .stream()
                .map(game -> modelMapper.map(game, GameDTO.class))
                .collect(Collectors.toList());
    }

}
