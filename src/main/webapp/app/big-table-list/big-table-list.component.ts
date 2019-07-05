import { Component, OnInit } from '@angular/core';
import {BigTableService} from "app/big-table.service";


@Component({
  selector: 'app-big-table-list',
  templateUrl: './big-table-list.component.html',
  styleUrls: ['./big-table-list.component.css']
})
export class BigTableListService implements OnInit {

  allBigTables : Array<any>

  constructor(private bigTableService: BigTableService) {
  }

  ngOnInit() {
    this.bigTableService.getAllBigTables().subscribe(data => {
      this.bigTableService = data;
    });
  }

}
