import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BigTable} from "app/services/big-table/big-table";
import {LOCAL_STORAGE, WebStorageService} from "angular-webstorage-service";

@Injectable({
  providedIn: 'root'
})
export class BigTableService {

  public data:any=[];

  constructor(@Inject(LOCAL_STORAGE) private storage: WebStorageService, private http: HttpClient) { }

  public getAllBigTables(): Observable<BigTable[]> {
    return this.http.get<BigTable[]>('http://localhost:8080/allBigTables');
  }


}
