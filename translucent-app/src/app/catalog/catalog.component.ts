import { GameService } from './../services/game.service';
import { Component } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { GameDetailsComponent } from "../game-details/game-details.component";
import { Game } from '../models/game.module';
import { NewGameComponent } from '../new-game/new-game.component';


@Component({
    selector: 'app-catalog',
    templateUrl: './catalog.component.html',
    styleUrls: ['./catalog.component.scss']
})
export class CatalogComponent{

  constructor(public dialog: MatDialog, private service: GameService) {}

  listGames: Game[] = [];

  ngOnInit(): void {
    this.service.getAllGames().subscribe((games: Game[]) => this.listGames = games);
  }

  displayedColumns: string[] = ['id', 'title', 'years', 'completed', 'console', 'dateCompletion'];

  openDialogDetails(data: Game): void {
    const dialogRef = this.dialog.open(GameDetailsComponent, {
      width: '60%',
      data: data,
    });

    dialogRef.afterClosed().subscribe(result => {
      this.delay(500).then(() =>
      this.service.getAllGames().subscribe((games: Game[]) => {this.listGames = games;})
      );
    });
  }

  openDialogNewGame(): void {
    const dialogRef = this.dialog.open(NewGameComponent, {
      width: '30%',
    });

    dialogRef.afterClosed().subscribe(result => {
      this.delay(500).then(() =>
      this.service.getAllGames().subscribe((games: Game[]) => {this.listGames = games;})
      );
    });
  }

  formatDate(data: string){
    var date = new Date(data);
    return data == null? "":date.toISOString().substring(0, 10);
  }

  numberofYears(data: string){
    var dateActual = new Date(Date.now());
    var actualDate = dateActual.toISOString().substring(0, 4);

    return Number(actualDate ) - Number(data);
  }

  delay(time: number) {
    return new Promise(resolve => setTimeout(resolve, time));
  }

}
