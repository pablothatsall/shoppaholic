
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Comment } from './comment.model';
import { Product } from './product.model';


const URL = 'https://localhost:4200/api/product/' ;

@Injectable()
export class ProductService {
   constructor(private http: Http) { }

      getProduct(id:number|string){
      return this.http.get(URL + id, { withCredentials: true })
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
    }

    getProducts(){
       return this.http.get('https://localhost:4200/api/products/', { withCredentials: true })
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
  }

  private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error.text);
    }

}
