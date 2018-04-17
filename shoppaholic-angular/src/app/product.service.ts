
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Comment } from './comment.model';

export interface Product{
    id?: number;
    name: string;
    price: number;
    description: string;
    imageUrl: string;
    label:string;
    pDate:string;
    score:number;
    comments:Comment[];
    idLogged:boolean;
}

const URL = 'https://localhost:8443/api/products/';

@Injectable()
export class ProductService {
   constructor(private http: Http) { }

      getProduct(id:number){
      let url="http://localhost:4200/api/Product/"+id;
       console.log(url);
    
    return this.http.get(url).map(
      response => response.json())
      //response => this.extractProduct(response))
      .catch(error =>this.handleError(error))

      
    }

    getProducts(){
       return this.http.get(URL, { withCredentials: true })
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
  }

  private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error.text);
    }

}
