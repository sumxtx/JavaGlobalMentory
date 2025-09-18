import { inject, Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  imports: [FormsModule],
  templateUrl: './add-product.html',
})
export class AddProduct {
  product: Product = new Product();

  private productService = inject(ProductService);
  private router = inject(Router);

  onSubmit(){
    this.saveProduct();
  }

  saveProduct(){
    this.productService.addProduct(this.product).subscribe({
      next: (datos)=>
      {
        this.goToProducts();
      },
      error: (error: any) => {console.log(error)}
    });
  }

  goToProducts()
  {
    this.router.navigate(['/products']);
  }
}
