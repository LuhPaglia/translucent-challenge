import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Game } from '../models/game.module';
import { GameService } from '../services/game.service';

@Component({
  selector: 'app-new-game',
  templateUrl: './new-game.component.html',
  styleUrls: ['./new-game.component.scss']
})
export class NewGameComponent implements OnInit {

  @Output() onSubmit = new EventEmitter<any>();

  newGame = {
    title: "",
    console: "",
    completed: "",
    dateCompletion: "",
    personalNotes: "",
    releaseYear: "",
    rate: "",
    urlImage: ""
  }

  constructor(private service: GameService,public dialogRef: MatDialogRef<NewGameComponent>,) { }

  ngOnInit(): void {
  }

  submit(): void {
    this.service.addGame(this.newGame).subscribe((games: Game[]) => {console.table(games)}
    , (error) => console.log(error));
    this.dialogRef.close();
  }

}
