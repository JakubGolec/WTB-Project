import { Injectable } from '@angular/core';
import {Game} from "app/services/game/game";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private http: HttpClient) { }


  public allGames(){
    return this.http.get<Game[]>('http://localhost:8080/allGames');
  }
}


