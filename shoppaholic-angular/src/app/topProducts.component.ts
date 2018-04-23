
import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
import { Product} from './product.model';
import { Router, ActivatedRoute } from '@angular/router';
import { Http } from '@angular/http';


@Component({
    selector: 'topproducts',
    templateUrl: './topProducts.component.html'
  })
  export class topProductsComponent {
  	topproducts:Product[];

  	constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private productService: ProductService){
       let id = activatedRoute.params.subscribe(params => {
       	 this.productService.getTopProducts().subscribe(
          
        topproducts => {this.topproducts = topproducts.getContent()},
      
      
      error =>  console.error(error)
      );
     
      
  });

  }



    private handleError(error: any) {
    console.error(error);
  }
}