
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Comment } from './comment.model';



@Injectable()
export class ProductService {
   constructor(private http: Http) { };

      getProduct(id:number){
      let url="http://localhost:4200/api/Product/"+id;
    }


}
