

import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PedidoService } from './pedido.service';
import { CustomerService } from './customer.service';
import {Pedido} from './pedido.model'
import {Customer} from './customer.model';;
import { Http, Response,Headers, RequestOptions } from '@angular/http';
@Component({
    selector: 'payment',
    templateUrl: './payment.component.html'
  })
  export class PaymentComponent {

	cart:Pedido;
    customer:Customer;

  	 constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private pedidoService: PedidoService, private customerService: CustomerService){
       var x = customerService.customer.idCustomer;
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

  payCart(){
    this.pedidoService.payCart().subscribe(
       
      payment =>{ 
        this.customerService.reqIsLogged
       
        },
      error => console.error(error)
    )
     this.router.navigate(['/'])}
  
              
}

