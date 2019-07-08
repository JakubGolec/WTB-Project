import {Component, OnInit} from '@angular/core';
import {BookingBigTableService} from "app/services/bookingBigTable/booking-big-table.service";
import {BookingBigTable} from "app/services/bookingBigTable/booking-big-table";

@Component({
  selector: 'app-big-table-reservation-list',
  templateUrl: './big-table-reservation-list.component.html',
  styleUrls: ['./big-table-reservation-list.component.css']
})
export class BigTableReservationListService implements OnInit {

  allReservations: BookingBigTable[];

  constructor(private bookingBigTableService: BookingBigTableService) {
  }

  ngOnInit() {
    this.bookingBigTableService.allReservationsForTheTable().subscribe(data => {
        this.allReservations = data;

      },
      error => {
        console.log(error)
      });
  }

}
