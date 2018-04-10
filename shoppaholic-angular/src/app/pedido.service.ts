
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Product } from './product.model';



@Injectable()
export class PedidoService {
   constructor(private http: Http) { };

      getPedido(id:number){
      let url="http://localhost:4200/api/order/"+id;
    }


}
