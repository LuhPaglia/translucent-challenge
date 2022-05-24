import { PutGame } from './../models/put-game.module';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Game } from '../models/game.module';
import { GameService } from '../services/game.service';

@Component({
  selector: 'app-edit-game',
  templateUrl: './edit-game.component.html',
  styleUrls: ['./edit-game.component.scss']
})
export class EditGameComponent implements OnInit {

  constructor(public dialog: MatDialog, private service: GameService,
    public dialogRef: MatDialogRef<EditGameComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Game,) { }

  ngOnInit(): void {
  }
  submit(): void {
    this.service.putGame({
      id: this.data.id,
      completed: this.data.completed,
      dateCompletion: this.data.dateCompletion,
      personalNotes: this.data.personalNotes,
      rate: this.data.rate,
      urlImage: this.data.urlImage
    }).subscribe((games: Game[]) => {console.table(games)}
    , (error) => console.log(error));
    this.dialogRef.close();
  };
}
