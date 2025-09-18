import { Routes } from '@angular/router';
import { ProductList } from './product-list/product-list';
import { AddProduct } from './add-product/add-product'
import { ModifyProduct } from './modify-product/modify-product';

export const routes: Routes = [
  {path: 'products', component: ProductList},
  {path: '', redirectTo: 'products', pathMatch: 'full'},
  {path: 'add-product', component:AddProduct},
  {path: 'modify-product/:id', component:ModifyProduct}
];
