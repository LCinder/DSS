import {IProduct} from "./IProduct";

export interface IUser {
  id: number,
  name: string,
  email: string,
  products: IProduct[]
}
