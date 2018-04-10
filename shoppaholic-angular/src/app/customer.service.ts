
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Pedido } from './pedido.model';



@Injectable()
export class CustomerService {
   constructor(private http: Http) { };

      getCustomer(id:number){
      let url="http://localhost:4200/api/customer/"+id;
    }


}
