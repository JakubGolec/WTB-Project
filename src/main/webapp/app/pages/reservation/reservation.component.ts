import { Component, OnInit } from '@angular/core';
import {BookingBigTable} from "app/services/bookingBigTable/booking-big-table";
import {ActivatedRoute, Router} from "@angular/router";
import {BookingBigTableService} from "app/services/bookingBigTable/booking-big-table.service";

@Component({
  selector: 'app-pages-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent {

  bookingBigTable : BookingBigTable;

  constructor(private route: ActivatedRoute, private router: Router, private bookingBigTableService : BookingBigTableService) {
    this.bookingBigTable = new BookingBigTable();
  }

  onSubmit() {
    this.bookingBigTableService.addReservation(this.bookingBigTable);
     // .subscribe(result => this.gotoAllReservations());
  }

  gotoAllReservations() {
    this.router.navigate(['/allReservations']);
  }

}
