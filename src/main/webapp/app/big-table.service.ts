import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BigTableService {

  private baseUrl = '/allBigTables';

  constructor(private http: HttpClient) { }

  getAllBigTables(): Observable<any> {
    return this.http.get('${this.baseUrl}');
  }
}
