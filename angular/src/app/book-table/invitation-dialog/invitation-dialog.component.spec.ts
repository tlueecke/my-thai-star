import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MdDialog } from '@angular/material';

import { BackendModule } from '../../shared/backend/backend.module';
import { BookTableModule } from '../book-table.module';

import { BookTableService } from '../shared/book-table.service';
import { SnackBarService } from '../../shared/snackService/snackService.service';

import { InvitationDialogComponent } from './invitation-dialog.component';

describe('InvitationDialogComponent', () => {
  let component: InvitationDialogComponent;
  let dialog: MdDialog;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [SnackBarService, BookTableService],
      imports: [
        BrowserAnimationsModule,
        BookTableModule,
        BackendModule.forRoot({environmentType: 0, restServiceRoot: 'v1'}),
      ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    dialog = TestBed.get(MdDialog);
    component = dialog.open(InvitationDialogComponent).componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
