import { Component } from '@angular/core';
import {HTTPService} from "../http-service.service";
import {AlertController, MenuController} from "@ionic/angular";
import {IProduct} from "../../IProduct";
import {IUser} from "../../IUser";

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  private products: any;
  private readonly URL_PRODUCTS: string;
  private readonly URL_USERS: string;

  constructor(private requestService: HTTPService, private menu: MenuController,
  private alertController: AlertController) {
    this.URL_PRODUCTS = "http://localhost:8080/products";
    this.URL_USERS = "http://localhost:8080/users";
  }

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    this.requestService.getRequest(this.URL_PRODUCTS).then(data => {
      this.products = data;
    });
  }

  addProduct(data: any) {
    const product: any = {name: data.name, price: data.price, image: data.image, description: data.description};
    this.requestService.postRequest(this.URL_PRODUCTS, product);
    window.location.reload();
  }

  modifyProduct(id:number, data: any) {
    const url: string = `${this.URL_PRODUCTS}/${id}`;
    this.requestService.putRequest(url, data);
    window.location.reload();
  }

  deleteProduct(product: IProduct) {
    this.requestService.deleteRequest(this.URL_PRODUCTS, product);
    window.location.reload();
  }

  formAddProduct() {
    const alert = this.alertController.create({
      header: "Add Product",
      inputs: [
        {
          name: "name",
          placeholder: "Name"
        },
        {
          name: "price",
          placeholder: "Price"
        },
        {
          name: "image",
          placeholder: "Image (URL)"
        },
        {
          name: "description",
          placeholder: "Description"
        }
      ],
      buttons: [
        {
          text: "Cancel"
        },
        {
          text: "Add",
          handler: (data: any) => {
            this.addProduct(data);
          }
        }
      ]
    }).then(res => {
      res.present();
    });
  }

  formModifyProduct(product: IProduct) {
    const alert = this.alertController.create({
      header: "Modify Product",
      inputs: [
        {
          name: "name",
          value: product.name
        },
        {
          name: "price",
          value: product.price
        },
        {
          name: "image",
          value: product.image
        },
        {
          name: "description",
          value: product.description
        }
      ],
      buttons: [
        {
          text: "Cancel"
        },
        {
          text: "Add",
          handler: (data: any) => {
            this.modifyProduct(product.id, data);
          }
        }
      ]
    }).then(res => {
      res.present();
    });
  }

  add2User(product: IProduct) {
    this.requestService.getRequest(`${this.URL_USERS}/9`).then((data: IUser) => {
      const user: IUser = {id: data.id, name: data.name, email: data.email, products: data.products};
      this.requestService.postRequest(`${this.URL_PRODUCTS}/${product.id}/users/${data.id}`, user);
    });
  }
}
