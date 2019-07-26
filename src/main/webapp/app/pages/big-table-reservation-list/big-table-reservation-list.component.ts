import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {BookingBigTableService} from "app/services/bookingBigTable/booking-big-table.service";
import {BookingBigTable} from "app/services/bookingBigTable/booking-big-table";
import {BigTable} from "app/services/big-table/big-table";
import {NgbActiveModal, NgbModal} from "@ng-bootstrap/ng-bootstrap";
// import {NgbdModal2Content} from "app/pages/modal-stacked/modal-stacked";
import {ActivatedRoute, Router} from "@angular/router";
import {ReservationComponent} from "app/pages/reservation/reservation.component";

@Component({
  selector: 'app-big-table-reservation-list',
  templateUrl: './big-table-reservation-list.component.html',
  styleUrls: ['./big-table-reservation-list.component.css']
})
export class BigTableReservationListService implements OnInit {
  @Input() bigTable: BigTable;
  @Output() eventClicked = new EventEmitter<BigTable>();


  allReservations: BookingBigTable[];

  constructor(private bookingBigTableService: BookingBigTableService, private modalService: NgbModal, public activeModal: NgbActiveModal, private router: ActivatedRoute) {

  }

  ngOnInit() {
    console.log(this.bigTable);
    this.bookingBigTableService.allReservationsForTheTable(this.bigTable).subscribe(data => {
        this.allReservations = data;

      },
      error => {
        console.log(error)
      });
  }

  open(bigTable:BigTable) {
    bigTable = this.bigTable;
    console.log(bigTable);
    this.eventClicked.emit(bigTable);
    const variable = this.modalService.open(ReservationComponent, {
      size: 'sm'
    });
    variable.componentInstance.bigTable = bigTable;
  }



}
