
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
import { Product} from './product.model';
@Component({
    selector: 'searchtext',
    templateUrl: './search.component.html'
  })
  export class SearchComponent {
  products:Product[];
   constructor(private router: Router, activatedRoute: ActivatedRoute,  private productService: ProductService){
       let id = activatedRoute.params.subscribe(params => {
              
      this.productService. searchProducts(params['searchtext']).subscribe(
      products =>{
        this.products=products;
      
      },
      error =>  console.error(error)
      );
     
      
  });

  }

  getProducts(id:number){
    this.productService.getProduct(id).subscribe(
      product =>{ this.products=product;},
      error => console.error(error)
    )
  }


  private handleError(error: any) {
    console.error(error);
  }



}