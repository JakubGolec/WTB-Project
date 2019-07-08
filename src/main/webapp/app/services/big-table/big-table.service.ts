import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BigTable} from "app/services/big-table/big-table";

@Injectable({
  providedIn: 'root'
})
export class BigTableService {

  constructor(private http: HttpClient) { }

  getAllBigTables(): Observable<BigTable[]> {
    return this.http.get<BigTable[]>('http://localhost:8080/allBigTables');
  }
}
