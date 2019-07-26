import { Component, OnInit } from '@angular/core';
import {GameService} from "app/services/game/game-service";
import {Game} from "app/services/game/game";

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.css']
})
export class GameListComponent implements OnInit {

  games:Game[];

  constructor(private gameService: GameService) { }

  ngOnInit() {
    this.gameService.allGames().subscribe(data => {
      this.games = data;
    });
  }

}
