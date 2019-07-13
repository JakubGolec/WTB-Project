import {NgModule} from "@angular/core";
import {AppComponent} from "app/app.component";
import {BigTableListService} from "app/pages/big-table-list/big-table-list.component";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {AppRoutingModule} from "app/app.routing-module";
import {HomeComponent} from "app/pages/home/home.component";
import {LoginComponent} from "app/pages/login/login.component";
import {SignupComponent} from "app/pages/signup/signup.component";
import {NgbdModalStackedModule} from "app/pages/modal-stacked/modal-stacked.module";
import {BigTableService} from "app/services/big-table/big-table.service";
import {StorageServiceModule} from "angular-webstorage-service";
import {AngularWebStorageModule} from "angular-web-storage";
import {BigTableReservationListService} from "app/pages/big-table-reservation-list/big-table-reservation-list.component";

@NgModule({
  declarations: [
    AppComponent,
    BigTableListService,
    HomeComponent,
    LoginComponent,
    SignupComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbdModalStackedModule,
    StorageServiceModule
  ],
  providers: [BigTableService],
  bootstrap: [AppComponent],

  entryComponents:[BigTableListService]
})
export class AppModule {
}
