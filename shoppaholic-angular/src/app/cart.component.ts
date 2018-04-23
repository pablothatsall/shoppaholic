import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PedidoService } from './pedido.service';
import { CustomerService } from './customer.service';
import { ProductService } from './product.service';
import {Pedido} from './pedido.model'
import {Customer} from './customer.model';;
import { Http, Response,Headers, RequestOptions } from '@angular/http';
@Component({
    selector: 'cart',
    templateUrl: './cart.component.html'
  })
  export class CartComponent {
  	cart:Pedido;
    customer:Customer;

  	 constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private pedidoService: PedidoService, private customerService: CustomerService, private productService:ProductService){
       let id = activatedRoute.params.subscribe(params => {
       	 this.pedidoService.getCart(params['id'], customerService.customer).subscribe(
      cart =>{
        this.customer=customerService.customer;
        this.cart=cart
        
      
      },
      error =>  console.error(error)
      );
     
      
  });

  }

  deleteFromCart(id:number){

  
    this.productService.deleteFromCart(id).subscribe(
       
      cart =>{ 
        this.cart=cart
       
        },
      error => console.error(error)
    )
  

  }
              
}