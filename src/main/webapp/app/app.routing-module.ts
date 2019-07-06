import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {BigTableService} from "app/services/big-table/big-table.service";
import {HomeComponent} from "app/pages/home/home.component";
import {LoginComponent} from "app/pages/login/login.component";
import {SignupComponent} from "app/pages/signup/signup.component";

const routes: Routes = [
  { path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  // { path: '', redirectTo: 'allBigTables', pathMatch: 'full' },
  { path: 'allBigTables', component: BigTableService },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
