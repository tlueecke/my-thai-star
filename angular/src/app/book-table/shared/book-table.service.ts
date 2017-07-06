import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { FriendsInvite, ReservationView } from '../../shared/viewModels/interfaces';
import { BookingDataService } from '../../shared/backend/booking/booking-data-service';
import { BookingInfo, ReservationInfo } from '../../shared/backend/backendModels/interfaces';
import { map, assign, forEach } from 'lodash';

@Injectable()
// REVIEW in summary this service seeems redundant to me if we introduce proper databinding at the components. 
// Please check comments below for details
export class BookTableService {

  constructor(private bookingDataService: BookingDataService) {
  }

  // REVIEW why did we introduce this delegation here? My guess is to have a single service for booking?
  postBooking(bookInfo: BookingInfo): Observable<any> {
    return this.bookingDataService.bookTable(bookInfo);
  }

  // REVIEW should be redundant if we introduce databinding. Then we would have a ReservationInfo already at hand
  // The type would then become irrelevant, since could fill the remaining information in the concrete places.
  // Introducing a flag for handling logic paths is IMHO not clean code either.
  composeBooking(invitationData: any, type: number): BookingInfo {
    let composedBooking: BookingInfo = {
      booking: {
        bookingDate: invitationData.bookingDate,
        name: invitationData.name,
        email: invitationData.email,
        bookingType: type, 
      },
    };

    if (type) {
      composedBooking.invitedGuests = map(invitationData.invitedGuests, (guest: FriendsInvite) => { return {email : guest}; } );
    } else {
      composedBooking.booking.assistants = invitationData.assistants;
    }

    return composedBooking;
  }

  // REVIEW how does this relate to the ValidateEmailDirective? Seems redundant to me...
  isEmailValid(email: string): boolean {
    let re: RegExp = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
    return re.test(email);
  }

}
