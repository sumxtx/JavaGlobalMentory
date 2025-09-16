import { Component, inject } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  imports: [],
  templateUrl: './product-list.html',
/*  styleUrl: './product-list.css' */
})

export class ProductList {
  products!: Product[];

  private productService = inject(ProductService);

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
}
