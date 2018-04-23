import { Component } from '@angular/core';
import { Http, Response,Headers, RequestOptions } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import {Customer} from './customer.model';
import {Product} from './product.model'
import { ProductService } from './product.service';
import { CustomerService } from './customer.service';

@Component({
    selector: 'editProduct',
    templateUrl: './editProduct.component.html'
  })
  export class EditProductComponent {
product:Product;
constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private productService: ProductService, private customerService:CustomerService){

	    


       let id = activatedRoute.params.subscribe(params => {
            
      this.productService.getProduct(params['id']).subscribe(
      product =>{
        this.product=product
        
      },
      error =>  console.error(error)
      );
     

     
      
  }); 

	
    
  
    
}


editProduct (name:string,price:number,labels:string,description:string){
 	
this.product.name=name;
this.product.price=price;
this.product.label=labels;
this.product.description=description;


this.productService.editProduct(this.product,this.product.id).subscribe(
      product =>{ this.product=product;},
      error => console.error(error)
    )


  }
}
  