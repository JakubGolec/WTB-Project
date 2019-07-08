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
import {BigTableReservationListService} from "app/pages/big-table-reservation-list/big-table-reservation-list.component";
import {BookingBigTableService} from "app/services/bookingBigTable/booking-big-table.service";
import { ReservationComponent } from './pages/reservation/reservation.component';

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
    NgbdModalStackedModule
  ],
  providers: [BigTableService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
