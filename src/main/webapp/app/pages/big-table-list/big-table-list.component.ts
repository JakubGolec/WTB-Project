import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {BigTableService} from "app/services/big-table/big-table.service";
import {BigTable} from "app/services/big-table/big-table";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {BigTableReservationListService} from "app/pages/big-table-reservation-list/big-table-reservation-list.component";
import {Router} from "@angular/router";
import {BookingBigTableService} from "app/services/bookingBigTable/booking-big-table.service";


@Component({
  selector: 'app-big-table-list',
  templateUrl: './big-table-list.component.html',
  styleUrls: ['./big-table-list.component.css']
})
export class BigTableListService implements OnInit {

  @Output() eventClicked = new EventEmitter<BigTable>();

  allBigTables : BigTable[];

  constructor(private bigTableService: BigTableService, private modalService: NgbModal, private reservationService:BookingBigTableService) {
  }

  ngOnInit() {
    this.bigTableService.getAllBigTables().subscribe(data => {
      this.allBigTables = data;
    },
      error => {
      console.log(error)
      });
  }

  onSelect(bigTable:BigTable) {
    console.log(bigTable);
    this.eventClicked.emit(bigTable);
    const variable = this.modalService.open(BigTableReservationListService);
    variable.componentInstance.bigTable = bigTable;
  }


  // trackElement(index: string, element: any) {
  //   return element ? element.id : null
  // }

}
