
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";



@Injectable()
export class CommentService {
   constructor(private http: Http) { };

      getComments(){
      let url="http://localhost:4200/api/comments";
    }


}
