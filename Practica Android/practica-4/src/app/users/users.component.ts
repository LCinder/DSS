import {Component, Input, OnInit} from '@angular/core';
import {HTTPService} from "../http-service.service";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss'],
})
export class UsersComponent {

  private users: any;
  private readonly URL_USERS: string;

  constructor(private requestService: HTTPService) {
    this.URL_USERS = "http://localhost:8080/users";
  }

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    this.requestService.getRequest(this.URL_USERS).then(data => {
      this.users = data;
    });
  }

}
