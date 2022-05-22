import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Game } from '../models/game.module';
import { GameService } from '../services/game.service';

@Component({
  selector: 'app-delete-game',
  templateUrl: './delete-game.component.html',
  styleUrls: ['./delete-game.component.scss']
})
export class DeleteGameComponent implements OnInit {

  constructor(private service: GameService,
    @Inject(MAT_DIALOG_DATA) public data: Game,public dialogRef: MatDialogRef<DeleteGameComponent>) { }

  ngOnInit(): void {
  }

  delete(): void {
    this.service.deleteGame(this.data.id).subscribe((games: Game[]) => {console.table(games)}
    , (error) => console.log(error));
    this.dialogRef.close();
  }

  noDelete(): void {
    this.dialogRef.close();
  }

}
