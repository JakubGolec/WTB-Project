import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {BigTableService} from "app/big-table.service";

const routes: Routes = [
  { path: '', redirectTo: 'allBigTables', pathMatch: 'full' },
  { path: 'allBigTables', component: BigTableService },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
