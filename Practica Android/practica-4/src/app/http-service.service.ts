import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {IProduct} from "../IProduct";

@Injectable({
  providedIn: 'root'
})
export class HTTPService {

  constructor(public httpClient: HttpClient) { }

  getRequest(url: string) {
    return new Promise(resolve => {
      this.httpClient.get(url).subscribe(data=>{
        resolve(data);
      });
    });
  }

  postRequest(url: string, data: any) {
    const headers = new HttpHeaders({
      "Content-Type": "application/json"
    });
    this.httpClient.post<any>(url, JSON.stringify(data), {headers: headers}).subscribe(data => {
      console.log(data);
    });
  }

  putRequest(url: string, data: IProduct) {
    const headers = new HttpHeaders({
      "Content-Type": "application/json"
    });
    this.httpClient.put<IProduct>(url, JSON.stringify(data), {headers: headers}).subscribe(data => {
      console.log(data);
    });
  }

  deleteRequest(url: string, data: IProduct) {
    url += `/${data.id}`;

    this.httpClient.delete(url).subscribe(data => {
      console.log(data);
    });
  }

}
