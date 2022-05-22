import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DeleteGameComponent } from '../delete-game/delete-game.component';
import { EditGameComponent } from '../edit-game/edit-game.component';
import { Game } from '../models/game.module';
import { GameService } from '../services/game.service';

@Component({
  selector: 'app-game-details',
  templateUrl: './game-details.component.html',
  styleUrls: ['./game-details.component.scss']
})
export class GameDetailsComponent implements OnInit {

  constructor(public dialog: MatDialog, private service: GameService,
    public dialogRef: MatDialogRef<GameDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Game,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }

  openDialogDeleteGame(data: Game): void {
    const dialogRef = this.dialog.open(DeleteGameComponent, {
      width: '30%',
      data
    });

    dialogRef.afterClosed().subscribe(result => {
      this.dialogRef.close();
    });
  }

  openDialogEditGame(data: Game): void {
    const dialogRef = this.dialog.open(EditGameComponent, {
      width: '50%',
      data: data,
    });

    dialogRef.afterClosed().subscribe(result => {
    });
  }

}
