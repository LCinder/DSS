import { Component, OnInit } from '@angular/core';
import {IProduct} from "../../IProduct";
import {IUser} from "../../IUser";
import {HTTPService} from "../http-service.service";
import {FormControl, FormGroup} from "@angular/forms";
import {HomePage} from "../home/home.page";
import {User} from "../user";
import {user} from "../app.component"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {

  private readonly URL_LOGIN: String;
  private formCredentials: FormGroup;

  constructor(private requestService: HTTPService) {
    this.URL_LOGIN = "http://localhost:8080/users/login"
    this.formCredentials = new FormGroup({
      email: new FormControl(""),
      password: new FormControl("")
    })
  }

  ngOnInit() {}

  login(): User {
    console.log(this.formCredentials.value);
    const credentials: any = {email: this.formCredentials.value.email, password: this.formCredentials.value.password};
    const data: any = this.requestService.postRequest(`${this.URL_LOGIN}`, credentials);
    let user: User;
    user.name = data.name;
    user.email = data.email;
    user.products = data.products;

    return user;
  }
}
