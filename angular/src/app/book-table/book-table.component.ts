import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MdDialog, MdDialogRef } from '@angular/material';
import { SnackBarService } from '../shared/snackService/snackService.service';
import { BookTableDialogComponent } from './book-table-dialog/book-table-dialog.component';
import { InvitationDialogComponent } from './invitation-dialog/invitation-dialog.component';
import { WindowService } from '../shared/windowService/windowService.service';
import { BookTableService } from './shared/book-table.service';
import { last } from 'lodash';

@Component({
  selector: 'public-book-table',
  templateUrl: './book-table.component.html',
  styleUrls: ['./book-table.component.scss'],
})

export class BookTableComponent {

  invitationModel: string[] = [];
  minDate: Date = new Date();

  constructor(public window: WindowService,
              public dialog: MdDialog,
              public snackBarService: SnackBarService,
              public bookingService: BookTableService) {
  }

  // REVIEW use databinding instead and pass bound object as data
  showBookTableDialog(form: FormGroup): void {
    let dialogRef: MdDialogRef<BookTableDialogComponent> = this.dialog.open(BookTableDialogComponent, {
      width: this.window.responsiveWidth(),
      data: form.value,
    });
    dialogRef.afterClosed().subscribe((res: boolean) => {
      if (res) {
        form.reset();
      }
    });
  }

  // REVIEW use databinding instead and pass bound object as data
  showInviteDialog(form: FormGroup): void {
    let dialogRef: MdDialogRef<InvitationDialogComponent> = this.dialog.open(InvitationDialogComponent, {
      width: this.window.responsiveWidth(),
      data: form.value,
    });
    dialogRef.afterClosed().subscribe((res: boolean) => {
      if (res) {
        form.reset();
        this.invitationModel = [];
      }
    });
  }

  validateEmail(): void {
    if (!this.bookingService.isEmailValid(last(this.invitationModel))) {
      this.invitationModel.pop();
      this.snackBarService.openSnack('Email format not valid', 1000, 'red');
    }
  }
}
