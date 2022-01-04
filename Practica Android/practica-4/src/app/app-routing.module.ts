import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import {UsersComponent} from "./users/users.component";
import {ShoppingCartComponent} from "./shopping-cart/shopping-cart.component";
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: "users", component: UsersComponent
  },
  {
    path: "cart", component: ShoppingCartComponent
  },
  {
    path: "login", component: LoginComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
