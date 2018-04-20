
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Pedido } from './pedido.model';
import { Customer } from './customer.model';

const URL = 'http://localhost:4200/api';

@Injectable()
export class CustomerService {
   constructor(private http: Http) { };

      getCustomer(id:number){
      let url= URL+ "/customer/" + id;
    }

/*
    createCustomer(user:Customer){
      let url = URL + "/newCustomer";
      const headers = new Headers({        
        'Content-Type': 'application/json'
      });

      return this.http.post(url,user, headers)
        .map(response => response.json())
        .catch(error => this.handleError(error));

    }
*/

    createCustomer(user:Customer){
      let url = URL + "/newCustomer";
      return this.http.post(url,user)
        .map(response => response.json())
        .catch(error => this.handleError(error));
    }

    
    private handleError(error: any) {
      console.error(error);
      return Observable.throw('Server error (' + error.status + '): ' + error.text);
    }
    

}
