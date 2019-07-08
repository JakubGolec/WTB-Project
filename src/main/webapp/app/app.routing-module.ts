import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {BigTableService} from "app/services/big-table/big-table.service";
import {HomeComponent} from "app/pages/home/home.component";
import {LoginComponent} from "app/pages/login/login.component";
import {SignupComponent} from "app/pages/signup/signup.component";
import {BigTableListService} from "app/pages/big-table-list/big-table-list.component";
import {BookingBigTableService} from "app/services/bookingBigTable/booking-big-table.service";
import {BigTableReservationListService} from "app/pages/big-table-reservation-list/big-table-reservation-list.component";
import {ReservationComponent} from "app/pages/reservation/reservation.component";


const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'signup', component: SignupComponent},
  // { path: '', redirectTo: 'allBigTables', pathMatch: 'full' },
  { path: 'allBigTables', component: BigTableListService },
  { path: 'allReservations', component: BigTableReservationListService },

  // otherwise redirect to home
  { path: '**', redirectTo: '' },
  {path:'reservation', component:ReservationComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
