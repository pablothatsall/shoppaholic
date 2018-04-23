import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from './product.service';
import { CommentService } from './comment.service';
import { Comment } from './comment.model';
import { CustomerService } from './customer.service';
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
  newcomment:Comment;
   constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private productService: ProductService, private commentService: CommentService, private customerService:CustomerService){

   
   


       let id = activatedRoute.params.subscribe(params => {
              this.getComments(params['id']);
      this.productService.getProduct(params['id']).subscribe(
      product =>{
        this.product=product
        
      },
      error =>  console.error(error)
      );
     

     
      this.newcomment={id:5, customer:customerService.customer, comment:"", date:"", product:this.product,idLogged:null};

  }); 

  }

  getComments(id:number){
     this.commentService.getComments(id).subscribe(
      comments=>{
        this.comments=comments
      
      },
      error =>  console.error(error)
      )


  }

  getProduct(id:number){
    this.productService.getProduct(id).subscribe(
      product =>{ this.product=product;},
      error => console.error(error)
    )
  }

  AddToCart(id:number){
    this.productService.addToCart(id).subscribe(
       
      product =>{ 
        this.customerService.reqIsLogged
       
        },
      error => console.error(error)
    )
  }

  AddComment(id:number, commentinfo:string){
    
      this.newcomment.comment=commentinfo;
    this.commentService.addComments(id,this.newcomment).subscribe(
       
      product =>{ 
      
        },
      error => console.error(error)
    )
     this.router.navigate(['/product',id])
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