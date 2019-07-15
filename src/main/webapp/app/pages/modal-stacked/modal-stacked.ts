import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {BigTableReservationListService} from "app/pages/big-table-reservation-list/big-table-reservation-list.component";
import {Import} from "@angular/core/schematics/utils/typescript/imports";
import {BigTable} from "app/services/big-table/big-table";



@Component({
  selector: 'ngbd-modal-stacked',
  templateUrl: './modal-stacked.html'
})
export class NgbdModalStacked {
  constructor(private modalService: NgbModal) {
  }

}

// @Component({
//   selector: 'ngbd-timepicker-basic',
//   templateUrl: '../time-picker/time-picker.component.html'
// })
// export class NgbdTimepickerBasic {
//   time = {hour: 13, minute: 30};
// }
