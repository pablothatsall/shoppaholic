import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PedidoService } from './pedido.service';
import { CustomerService } from './customer.service';
import {Pedido} from './pedido.model'
import {Customer} from './customer.model';;
import { Http, Response,Headers, RequestOptions } from '@angular/http';

@Component({
    selector: 'order',
    templateUrl: './order.component.html'
  })
  
export class OrderComponent {
	order:Pedido;
    customer:Customer;
    constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private pedidoService: PedidoService, private customerService: CustomerService){
       let id = activatedRoute.params.subscribe(params => {
      this.pedidoService.getPedido(params['id'],customerService.customer).subscribe(
      order =>{
        this.order=order
        
      },
      error =>  console.error(error)
      );
     

     
      
  }); 

/*
 	constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private pedidoService: PedidoService, private customerService: CustomerService){
		let id = activatedRoute.params.subscribe(params => {
       	this.pedidoService.getPedido(params['id']).subscribe(
    order =>{
        this.order = order
			},
			error =>  console.error(error)
			);
		});
	}*/           
}
}