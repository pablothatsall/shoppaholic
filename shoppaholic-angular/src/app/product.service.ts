
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Comment } from './comment.model';
import { Product } from './product.model';
import {CustomerService} from './customer.service';
import {PedidoService} from './pedido.service';


const URL = 'http://localhost:4200/api/product/' ;

@Injectable()
export class ProductService {
   constructor(private http: Http) { }

      getProduct(id:number|string){
      return this.http.get(URL + id, { withCredentials: true })
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
    }

    getProducts(){
       return this.http.get('http://localhost:4200/api/products/', { withCredentials: true })
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
  }

   addToCart(id:number|string){
       return this.http.post('http://localhost:4200/api/addToCart/' + id, { withCredentials: true })
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
  }

      searchProducts(searchtext:string){
       return this.http.get('http://localhost:4200/api/searchname/' + searchtext + '/1',{ withCredentials: true })
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
  }

  private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error.text);
    }

    /*  addToCart(){
    this.pedidoService.addToCart(id).subscribe(
    pedido => {
        
      },
      error => console.error(error)
    )
  }*/
}
