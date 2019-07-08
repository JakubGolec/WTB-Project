import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {BookingBigTable} from "app/services/bookingBigTable/booking-big-table";

@Injectable({
  providedIn: 'root'
})
export class BookingBigTableService {


  constructor(private http: HttpClient) {
  }

  allReservationsForTheTable(): Observable<BookingBigTable[]> {
    return this.http.get<BookingBigTable[]>('http://localhost:8080/allReservations');
  }

  public addReservation(bookingBigTable: BookingBigTable){
    const params = new HttpParams().set('startDate', bookingBigTable.startDate)
    .set('endDate', bookingBigTable.endDate);
    return this.http.post<BookingBigTable>('http://localhost:8080/reservation', params);
  }
}
