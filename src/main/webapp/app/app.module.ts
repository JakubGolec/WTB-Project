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

@NgModule({
  declarations: [
    AppComponent,
    BigTableListService,
    HomeComponent,
    LoginComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
