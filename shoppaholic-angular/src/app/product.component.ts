import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from './product.service';
import {Product} from './product.model';
import { Http } from '@angular/http';
const BASE_URL = 'http://localhost:4200/api/product/1';
@Component({
   
    
    templateUrl: './product.component.html'
  })
  export class ProductComponent {
  product:Product;
   constructor(private http: Http,  private productService: ProductService){}
    ngOnInit() {
    this.refresh();
  }

  private refresh() {
    this.http.get(BASE_URL).subscribe(
      response => this.product = response.json(),
      error => this.handleError(error)
    );
  }

    
  

  private handleError(error: any) {
    console.error(error);
  }

}