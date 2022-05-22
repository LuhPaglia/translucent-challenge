import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../models/game.module';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  private backendUrl: string = "http://localhost:8080/";
  private gamesList: Game[];

  constructor(private httpClient: HttpClient) { this.gamesList = []}

  getAllGames(): Observable<Game[]>{
    return this.httpClient.get<Game[]>(this.backendUrl);
  }

  get games(){
    return this.gamesList;
  }

  addGame(game: any): Observable<Game[]>{
    return this.httpClient.post<Game[]>(this.backendUrl, game);
  }

  deleteGame(id: number): Observable<Game[]>{
    return this.httpClient.delete<Game[]>(this.backendUrl+id);
  }
}
