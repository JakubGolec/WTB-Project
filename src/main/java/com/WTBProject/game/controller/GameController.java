package com.WTBProject.game.controller;


import com.WTBProject.game.dto.GameDTO;
import com.WTBProject.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {

  private GameService gameService;

  @Autowired
  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @GetMapping("/allGames")
  @CrossOrigin(origins = "http://localhost:4200")
  public List<GameDTO> getAllGames(Model model) {
    List<GameDTO> allGames = gameService.getAllGames();
    model.addAttribute("allGames", gameService.getAllGames());
    model.addAttribute("newGame", new GameDTO());
    return allGames;
  }

  @GetMapping("searchGameAction")
  public String searchGameByName(String gameName, Model model) {
    List<GameDTO> foundGames = gameService.findGameByName(gameName);
    model.addAttribute("allGames", foundGames);
    model.addAttribute("queryString", "");
    return "AllGamesPage";
  }

  @PostMapping("saveGameAction")
  public String saveGameAction(@ModelAttribute("newGame") GameDTO newGame, Model model) {
    gameService.saveGame(newGame);
    return "redirect:/allGamesPage";
  }

}
