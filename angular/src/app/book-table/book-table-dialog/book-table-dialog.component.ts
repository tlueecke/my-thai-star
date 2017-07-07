import { Component, OnInit, Inject } from '@angular/core';
import { MdDialogRef, MD_DIALOG_DATA } from '@angular/material';
import { BookTableService } from '../shared/book-table.service';
import { SnackBarService } from '../../shared/snackService/snackService.service';
import * as moment from 'moment';

@Component({
  selector: 'public-book-table-dialog',
  templateUrl: './book-table-dialog.component.html',
  styleUrls: ['./book-table-dialog.component.scss'],
})
export class BookTableDialogComponent implements OnInit {
  
  // REVIEW why are we still not using databinding to concrete classes? Such declarations require redundant compose methods in services and 
  // do not leverage the full feature set of angular. I am sure there is a reason we don't do this since Bartek already remarked on this
  // and it is not yet changed, but a commment why this is done would be really helpful
  data: any;
  date: string;

  constructor (public snackBar: SnackBarService,
               public bookingService: BookTableService,
               private dialog: MdDialogRef<BookTableDialogComponent>,
               @Inject(MD_DIALOG_DATA) dialogData: any) {
                 this.data = dialogData;
  }

  ngOnInit(): void {
    this.date = moment(this.data.bookingDate).format('LLL');
  }

  sendBooking (): void {
    this.bookingService.postBooking(this.bookingService.composeBooking(this.data, 0)).subscribe( () => {
      this.snackBar.openSnack('Table succesfully booked', 4000, 'green');
    }, (error: any) => {
      this.snackBar.openSnack('Error booking, please try again later', 4000, 'red');
    });
    this.dialog.close(true);
  }

}
