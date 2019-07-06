import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {BigTableService} from "app/big-table.service";
import {AppComponent} from "app/app.component";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";

const routes: Routes = [
  {path: '', redirectTo: 'allBigTables', pathMatch: 'full'},
  {path: 'allBigTables', component: BigTableService},

];

@NgModule({
  declarations: [
    AppComponent
  ],

  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppRoutingModule {
}
