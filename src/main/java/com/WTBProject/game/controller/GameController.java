package com.WTBProject.game.controller;


import com.WTBProject.game.dto.GameDTO;
import com.WTBProject.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("allGamesPage")
    public String getAllGamesPage(Model model) {
        model.addAttribute("allGames", gameService.getAllGames());
        model.addAttribute("newGame", new GameDTO());
        return "allGamesPage";
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
