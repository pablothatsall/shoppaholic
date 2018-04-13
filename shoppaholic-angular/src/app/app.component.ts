import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {Product} from './product.model';
import { ProductService } from './product.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  //styleUrls: ['../assets/css/bootstrap.min.css']
})
export class AppComponent {

  product:Product;
 
  
 constructor(private productService: ProductService){


        
        this.productService.getProducts().subscribe(
        product =>this.product=product,
        error =>  console.error(error)
        );

    
 
  }

}
