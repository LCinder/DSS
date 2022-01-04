import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { RouteReuseStrategy } from '@angular/router';
import {HttpClientModule} from "@angular/common/http";

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import {UsersComponent} from "./users/users.component";
import {ShoppingCartComponent} from "./shopping-cart/shopping-cart.component";
import {LoginComponent} from "./login/login.component";

@NgModule({
  declarations: [AppComponent, UsersComponent, ShoppingCartComponent, LoginComponent],
  entryComponents: [],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule, HttpClientModule, CommonModule],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }],
  bootstrap: [AppComponent],
})
export class AppModule {}
