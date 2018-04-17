import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from './product.service';
import {Product} from './product.model';

@Component({
    selector: 'product',
    templateUrl: './product.component.html'
  })
  export class ProductComponent {
  product:Product;
   constructor(private router: Router, activatedRoute: ActivatedRoute, private productService: ProductService,
        ){
  let id = activatedRoute.params.subscribe(params=>{
  	 this.productService.getProduct(params['id']).subscribe(
        product=>{ 
          this.product=product
          

        },
        error=>console.error(error)
);
    });


    
  }

      getProduct(id:number){
    this.productService.getProduct(id).subscribe(
      product =>{ this.product=product;},
      error => console.error(error)
    )
  }	
}