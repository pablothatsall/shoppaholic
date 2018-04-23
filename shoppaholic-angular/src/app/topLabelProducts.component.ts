
import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
import { Product} from './product.model';
import { Router, ActivatedRoute } from '@angular/router';
import { Http } from '@angular/http';


@Component({
    selector: 'toplabelproducts',
    templateUrl: './topLabelProducts.component.html'
  })
  export class topLabelProductsComponent {
  	toplabelproducts:Product[];

  	constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private productService: ProductService){
       let id = activatedRoute.params.subscribe(params => {
       	 this.productService.getTopLabelProducts(params['searchtext']).subscribe(
          
        topproducts => {this.toplabelproducts = topproducts.getContent()},
      
      
      error =>  console.error(error)
      );
     
      
  });

  }



    private handleError(error: any) {
    console.error(error);
  }
}