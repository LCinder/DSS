import {IProduct} from "../IProduct";


export class User {
  private _id: number;
  private _name: string;
  private _email: string;
  private _admin: boolean;
  private _products: IProduct[];

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  constructor(name: string, email: string, admin: boolean, products: IProduct[]) {
    this._name = name;
    this._email = email;
    this._admin = admin;
    this._products = products;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get admin(): boolean {
    return this._admin;
  }

  set admin(value: boolean) {
    this._admin = value;
  }

  get products(): IProduct[] {
    return this._products;
  }

  set products(value: IProduct[]) {
    this._products = value;
  }
}
