import { BookTableComponent } from './book-table.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MaterialModule } from '@angular/material';
import { CovalentModule } from '../shared/covalent.module';
import { Md2Module } from 'md2';

import { BookTableService } from './shared/book-table.service';
import { WindowService } from '../shared/windowService/windowService.service';
import { SnackBarService } from '../shared/snackService/snackService.service';

import { BookTableDialogComponent } from './book-table-dialog/book-table-dialog.component';
import { InvitationDialogComponent } from './invitation-dialog/invitation-dialog.component';

@NgModule({
  imports: [
    CommonModule,
    Md2Module,
    MaterialModule,
    CovalentModule,
  ],
  providers: [
    BookTableService,
    WindowService,
    SnackBarService,
  ],
  declarations: [
    InvitationDialogComponent,
    BookTableDialogComponent,
    BookTableComponent,
  ],
  exports: [
    BookTableComponent,
  ],
  entryComponents: [
    InvitationDialogComponent,
    BookTableDialogComponent,
  ],
})
export class BookTableModule { }
