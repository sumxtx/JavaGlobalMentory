import { Component, inject } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  imports: [],
  templateUrl: './product-list.html'
/*  styleUrl: './product-list.css' */
})

export class ProductList {
  products!: Product[];

  private productService = inject(ProductService);
  private router = inject(Router);

  ngOnInit()
  {
    this.getProducts();
  }

  private getProducts(): void
  {
    this.productService.getProductList().subscribe(
      {
        next: (datos) => {
          this.products = datos;
        },
        error: (error) =>
        {
          console.error("Failed to get products", error);
        }
      }
    );
  }

  modifyProduct(id: number){
    this.router.navigate(['modify-product', id]);
  }

  deleteProduct(id:number)
  {
    this.productService.deleteProduct(id).subscribe({
      next: (datos)=>this.getProducts(),
      error: (error)=>console.log(error)
    });
  }
}
