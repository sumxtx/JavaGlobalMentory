import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService
{
  private urlBase = "http://localhost:8080/inventory-app/products";

  constructor(private clientHttp : HttpClient){}

  getProductList(): Observable<Product[]>
  {
    return this.clientHttp.get<Product[]>(this.urlBase);
  }
}
