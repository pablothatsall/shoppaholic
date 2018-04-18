
import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
import { Product} from './product.model';
import { Router, ActivatedRoute } from '@angular/router';
import { Http } from '@angular/http';


const BASE_URL = 'http://localhost:4200/api/products';
@Component({
    selector: 'home',
    templateUrl: './home.component.html'
  })
  export class HomeComponent {

  products:Product[];
 
  
 constructor(private http: Http,  private productService: ProductService){}

    ngOnInit() {
    this.refresh();
  }

  private refresh() {
    this.http.get(BASE_URL).subscribe(
      response => this.products = response.json(),
      error => this.handleError(error)
    );
  }

    
  

  private handleError(error: any) {
    console.error(error);
  }
 
  
}