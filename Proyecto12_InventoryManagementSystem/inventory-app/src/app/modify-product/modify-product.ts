import { inject, Component } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import {ActivatedRoute, RouterModule, Router} from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-modify-product',
  imports: [FormsModule],
  templateUrl: './modify-product.html'
})
export class ModifyProduct {
  product: Product = new Product();
  id!: number;

  private productService = inject(ProductService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  ngOnInit()
  {
    this.id = this.route.snapshot.params['id'];
    this.productService.getProductById(this.id).subscribe(
      {
        next: (datos)=>this.product = datos
        ,
        error : (error: any) => console.log(error)
      }
    );
  }

  onSubmit()
  {
    this.saveProduct();
  }

  saveProduct()
  {
    this.productService.modifyProduct(this.id, this.product).subscribe(
      {
        next: (datos)=>this.goToProductList(),
        error: (error)=>console.log(error)
      }
    );
  }

  goToProductList()
  {
    this.router.navigate(['/products']);
  }

}
