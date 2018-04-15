import { Component } from '@angular/core';
import { ProductService } from './product.service';
import { Product} from './product.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'home',
    templateUrl: './home.component.html'
  })
  export class HomeComponent {

  product:Product[];
 
  
 constructor(private router: Router, activatedRoute: ActivatedRoute, private productService: ProductService){


        
        this.productService.getProducts().subscribe(
        product =>this.product=product,
        error =>  console.error(error)
        );

    
 
  }
}