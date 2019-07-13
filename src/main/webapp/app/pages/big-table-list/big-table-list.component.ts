import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {BigTableService} from "app/services/big-table/big-table.service";
import {BigTable} from "app/services/big-table/big-table";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {BigTableReservationListService} from "app/pages/big-table-reservation-list/big-table-reservation-list.component";
import {Router} from "@angular/router";


@Component({
  selector: 'app-big-table-list',
  templateUrl: './big-table-list.component.html',
  styleUrls: ['./big-table-list.component.css']
})
export class BigTableListService implements OnInit {

  @Output() eventClicked = new EventEmitter<BigTable>();

  allBigTables : BigTable[];
  selectedBigTable:BigTable;

  constructor(private bigTableService: BigTableService, private modalService: NgbModal, private router: Router) {
  }

  ngOnInit() {
    this.bigTableService.getAllBigTables().subscribe(data => {
      this.allBigTables = data;
        // this.bigTableService.saveInLocal("allBigTables", this.allBigTables);
    },
      error => {
      console.log(error)
      });
  }

  onSelect(bigTable:BigTable) {
    console.log(bigTable);
    this.eventClicked.emit(bigTable);
    // let route = this.router.config.find(r => r.component == NgbModal);
    // route.data['bigTable'] = bigTable;
    // console.log(route.data);

    const variable = this.modalService.open(BigTableReservationListService);
    variable.componentInstance.bigTable = bigTable;

    // this.router.navigate(["allReservations"]);
  }

  // onSelect(bigTable: BigTable): void {
  //   this.selectedBigTable = bigTable;
  // }

  open() {
    const variable = this.modalService.open(BigTableReservationListService);
    variable.componentInstance.bigTable.id = this.selectedBigTable.id;

 //  this.bigTableService.saveInLocal("allBigTables", this.allBigTables.find());
  }

  findTable(){
  // todo
  }


  // trackElement(index: string, element: any) {
  //   return element ? element.id : null
  // }

}
