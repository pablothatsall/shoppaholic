import { Component } from '@angular/core';
import { Http, Response,Headers, RequestOptions } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import {Customer} from './customer.model';
import {Product} from './product.model'
import { ProductService } from './product.service';

@Component({
    selector: 'addProduct',
    templateUrl: './addProduct.component.html'
  })
  export class AddProductComponent {
product:Product;
constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private productService: ProductService){}


 addProduct (name:string,price:number,labels:string,description:string){
 	
this.product.name=name;
this.product.price=price;
this.product.label=labels;
this.product.description=description;


this.productService.addProduct(this.product).subscribe(
      product =>{ this.product=product;},
      error => console.error(error)
    )


  }
}
  