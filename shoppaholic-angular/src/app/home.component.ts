
import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
import { Product} from './product.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'home',
    templateUrl: './home.component.html'
  })
  export class HomeComponent {

  products:Product[];
 
  
 constructor(private router: Router, activatedRoute: ActivatedRoute, private productService: ProductService){


    this.productService.getProducts().subscribe(
      products => this.products = products,
      error => console.log(error)
    );
  }
 
  
}