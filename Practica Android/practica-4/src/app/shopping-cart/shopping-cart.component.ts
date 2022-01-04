import { Component, OnInit } from '@angular/core';
import {HTTPService} from "../http-service.service";
import {AlertController, MenuController} from "@ionic/angular";
import {IProduct} from "../../IProduct";

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss'],
})
export class ShoppingCartComponent implements OnInit {

  private products: any;
  private readonly URL_USERS: string;

  constructor(private requestService: HTTPService) {
    this.URL_USERS = "http://localhost:8080/users";
  }

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    this.requestService.getRequest(`${this.URL_USERS}/9/products`).then(data => {
      this.products = data;
    });
  }

  deleteProduct(product: IProduct) {
    this.requestService.deleteRequest(`${this.URL_USERS}/9/products`, product);
    window.location.reload();
  }

  add2User(product: IProduct) {

  }

}
