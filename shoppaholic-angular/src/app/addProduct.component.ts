/*
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Product } from './product.model';
import {ProductService} from './product.service';
import { Component } from '@angular/core';

@Component({
     selector: 'addProduct',
    templateUrl: './addProduct.component.html'
})

export class export class AddProductComponent {

    product: Product;
  
  constructor(private router: Router, activatedRoute: ActivatedRoute, private loginService: LoginService,
  private adminService: AdminService,private productService:ProductService) {
        this.product={ name: '', price: '', label''};
                error =>  console.error(error)
            );
        }
    }

    createProduct(event:any, name:string,price:string,label:string){
        event.preventDefault();
        this.product.name=name;
        this.product.price=price;
        this.product.label=label;
        this.productService.addProduct(this.product).subscribe(
            product =>{ 
                this.product=product;
            },
        error => console.error(error)
    )
    }



}
*/
  
