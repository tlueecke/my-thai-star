import { Observable } from 'rxjs/Observable';
import { ReservationView } from '../../viewModels/interfaces';
import { BookingInfo, FilterCockpit } from '../backendModels/interfaces';

// REVIEW in our OASP coding conventions there is a rule for avoiding such artifical names like I*
// We should not now introduce them here...
export interface IBookingDataService {

    getReservations(filter: FilterCockpit): Observable<ReservationView[]>;
    bookTable(booking: BookingInfo): Observable<number>;
    acceptInvite(token: string): Observable<number>;
    cancelInvite(token: string): Observable<number>;
    cancelReserve(token: string): Observable<number>;
}
