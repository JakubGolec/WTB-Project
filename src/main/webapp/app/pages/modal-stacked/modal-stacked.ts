import { Component } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';

// MODAL nr 1 - właściwości
@Component({
  template: `
    <div class="modal-header">
      <h4 class="modal-title">[ NUMER WYBRANEGO STOLIKA ]</h4>
      <button type="button" class="close" aria-label="Close" (click)="activeModal.dismiss('Cross click')">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    <div class="modal-body">
      <p>Lista Rezerwacji</p>
      <p><button class="btn btn-lg btn-outline-primary" (click)="open()">Zarezerwuj</button></p>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-outline-dark" (click)="activeModal.close('Close click')">Zamknij</button>
    </div>
  `
})

export class NgbdModal1Content {
  constructor(private modalService: NgbModal, public activeModal: NgbActiveModal) {}
  open() {
    this.modalService.open(NgbdModal2Content, {
      size: 'sm'
    });
  }
}

// MODAL nr 2 - właściwości
@Component({
  template: `
    <div class="modal-header">
      <h4 class="modal-title">Wybierz godzinę</h4>
      <button type="button" class="close" aria-label="Close" (click)="activeModal.dismiss('Cross click')">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    <div class="modal-body">
      <p>A tu trzeba wcisnąć wybór godzin</p>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-outline-dark" (click)="activeModal.close('Close click')">Close</button>
    </div>
  `
})
export class NgbdModal2Content {
  constructor(public activeModal: NgbActiveModal) {}
}

@Component({
  selector: 'ngbd-modal-stacked',
  templateUrl: './modal-stacked.html'
})
export class NgbdModalStacked {
  constructor(private modalService: NgbModal) {}

  open() {
    this.modalService.open(NgbdModal1Content);
  }
}
