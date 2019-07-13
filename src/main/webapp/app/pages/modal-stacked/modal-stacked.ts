import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {BigTableReservationListService} from "app/pages/big-table-reservation-list/big-table-reservation-list.component";
import {Import} from "@angular/core/schematics/utils/typescript/imports";
import {BigTable} from "app/services/big-table/big-table";

// MODAL nr 1 - właściwości
// @Component({
//   template: `
//     <div class="modal-header">
//       <h4 class="modal-title">Rezerwacja stolika</h4>
//       <button type="button" class="close" aria-label="Close" (click)="activeModal.dismiss('Cross click')">
//         <span aria-hidden="true">&times;</span>
//       </button>
//     </div>
//     <div class="modal-body">
//
//       <app-big-table-reservation-list></app-big-table-reservation-list>
//
//       <p>
//         <button class="btn btn-lg btn-outline-primary" (click)="open()">Zarezerwuj</button>
//       </p>
//     </div>
//     <div class="modal-footer">
//       <button type="button" class="btn btn-outline-dark" (click)="activeModal.close('Close click')">Zamknij</button>
//     </div>
//   `
//
// })

// export class NgbdModal1Content implements OnInit{
//   @Input() public selectedBigTable;
//
//   constructor(private modalService: NgbModal, public activeModal: NgbActiveModal) {
//   }
//
//   ngOnInit(): void {
//     console.log(this.selectedBigTable)
//   }
//
//   open() {
//     this.modalService.open(NgbdModal2Content, {
//       size: 'sm'
//     })
//   }
// }

// MODAL nr 2 - właściwości
@Component({
  template: `
    <div class="modal-header">
      <h4 class="modal-title">Wybierz godziny rezerwacji</h4>
      <button type="button" class="close" aria-label="Close" (click)="activeModal.dismiss('Cross click')">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    <div class="modal-body">
<app-pages-reservation></app-pages-reservation>
<!--      <time-picker></time-picker>-->
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-outline-dark" (click)="activeModal.close('Close click')">Close</button>
    </div>
  `
})
export class NgbdModal2Content {
  @Input() selectedBigTable:BigTable;

  constructor(public activeModal: NgbActiveModal) {
  }
}

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
