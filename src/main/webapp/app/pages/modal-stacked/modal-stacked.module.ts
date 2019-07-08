import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {
  NgbdModal1Content,
  NgbdModal2Content,
  NgbdModalStacked,
} from './modal-stacked';
import {BigTableReservationListService} from "app/pages/big-table-reservation-list/big-table-reservation-list.component";
import {BookingBigTableService} from "app/services/bookingBigTable/booking-big-table.service";
import {AppRoutingModule} from "app/app.routing-module";
import {HttpClientModule} from "@angular/common/http";
import {AppModule} from "app/app.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AppComponent} from "app/app.component";

import {FormsModule} from "@angular/forms";
import {
  OWL_DATE_TIME_FORMATS,
  OWL_DATE_TIME_LOCALE,
  OwlDateTimeModule,
  OwlNativeDateTimeModule
} from "ng-pick-datetime";
import {TimePickerComponent} from "app/pages/time-picker/time-picker.component";
import {BigTableListService} from "app/pages/big-table-list/big-table-list.component";
import {ReservationComponent} from "app/pages/reservation/reservation.component";
export const MY_NATIVE_FORMATS = {timePickerInput: {hour: 'numeric', minute: 'numeric'},};


@NgModule({
  imports: [BrowserModule, NgbModule, AppRoutingModule, HttpClientModule, BrowserAnimationsModule,
    FormsModule, OwlDateTimeModule, OwlNativeDateTimeModule],
  declarations: [NgbdModalStacked, NgbdModal1Content, NgbdModal2Content, BigTableReservationListService, TimePickerComponent, NgbdModal2Content, ReservationComponent],
  exports: [NgbdModalStacked],
  bootstrap: [NgbdModalStacked, AppComponent, TimePickerComponent, NgbdModal2Content],
  providers: [{provide: OWL_DATE_TIME_FORMATS, useValue: MY_NATIVE_FORMATS}],
  entryComponents: [NgbdModal1Content]
})
export class NgbdModalStackedModule {
}

