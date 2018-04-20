import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from './product.service';
import {Product} from './product.model';
import { Http, Response,Headers, RequestOptions } from '@angular/http';
const BASE_URL = 'http://localhost:4200/api/product/1';
const COMMENTS_URL = 'http://localhost:4200/api/comments/1';
@Component({
   
    
    templateUrl: './product.component.html'
  })
  export class ProductComponent {
    ;
  product:Product;
  comments:Comment[];
   constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private productService: ProductService){
       let id = activatedRoute.params.subscribe(params => {
              
      this.productService.getProduct(params['id']).subscribe(
      product =>{
        this.product=product,
        this.comments=product.comments;
      
      },
      error =>  console.error(error)
      );
     
      
  });

  }

  getComments(id:number){
    this.commentService.getComments(id).subscribe(
      comments => { this.comments=product.comments;},
      error => console.error(error)
      )
  }

  getProduct(id:number){
    this.productService.getProduct(id).subscribe(
      product =>{ this.product=product;},
      error => console.error(error)
    )
  }

   createProduct(artist:Product){
    let url="http://localhost:4200/api/admin/newproduct";
    const options = new RequestOptions({ withCredentials: true});
    return this.http.post(url,artist,options).map(
      response => response.json())
      
  }


  private handleError(error: any) {
    console.error(error);
  }

}