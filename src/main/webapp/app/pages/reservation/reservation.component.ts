import {Component, Input, OnInit} from '@angular/core';
import {BookingBigTable} from "app/services/bookingBigTable/booking-big-table";
import {ActivatedRoute, Router} from "@angular/router";
import {BookingBigTableService} from "app/services/bookingBigTable/booking-big-table.service";
import {BigTable} from "app/services/big-table/big-table";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-pages-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent {
  @Input() bigTable: BigTable;

  bookingBigTable : BookingBigTable;

  constructor(private route: ActivatedRoute, private router: Router, private bookingBigTableService : BookingBigTableService, public activeModal: NgbActiveModal) {
    this.bookingBigTable = new BookingBigTable();
  }

  onSubmit() {
    console.log(this.bigTable);
    this.bookingBigTableService.addReservation(this.bookingBigTable);
     // .subscribe(result => this.gotoAllReservations());
  }

  gotoAllReservations() {
    this.router.navigate(['/allReservations']);
  }

}
