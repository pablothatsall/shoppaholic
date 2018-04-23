
import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
import { Product} from './product.model';
import { Router, ActivatedRoute } from '@angular/router';
import { Http } from '@angular/http';


const BASE_URL = 'http://localhost:4200/api/firstproducts';
@Component({
    selector: 'home',
    templateUrl: './home.component.html'
  })
  export class HomeComponent {

  products:Product[];
  topproducts:Product[];
 
  
 constructor(private http: Http,  private productService: ProductService, activatedRoute:ActivatedRoute){ let id = activatedRoute.params.subscribe(params => {
          this.productService.getTopProducts().subscribe(
          
        topproducts => {this.topproducts = topproducts.getContent()},
      
      
      error =>  console.error(error)
      );
     
      
  });
}

    ngOnInit() {
    this.refresh();
    this.top();
      
  

  }

  private refresh() {
    this.http.get(BASE_URL).subscribe(
      response => this.products = response.json(),

      error => this.handleError(error)
    );

  }
private top(){

this.http.get('localhost:4200/api/topproducts/1').subscribe(
      response => this.topproducts = response.json(),
    
      error => this.handleError(error)
    );

}

  

    
  

  private handleError(error: any) {
    console.error(error);
  }
 
  
}