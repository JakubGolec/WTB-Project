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

  getAllBigTables(): Observable<BigTable[]> {
    return this.http.get<BigTable[]>('http://localhost:8080/allBigTables');
  }


  saveInLocal(key, val): void {
    console.log('recieved= key:' + key + 'value:' + val);
    this.storage.set(key, val);
    this.data[key]= this.storage.get(key);
  }


  getFromLocal(key): void {
    console.log('recieved= key:' + key);
    this.data[key]= this.storage.get(key);
    console.log(this.data);
  }


}
