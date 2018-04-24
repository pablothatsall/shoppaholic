
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
import { Product} from './product.model';
@Component({
    selector: 'searchtext',
    templateUrl: './search.component.html'
  })
  export class SearchComponent {
  products:Product[];
  searchtext:String;
  productmore:Product[]
  more:boolean;
   constructor(private router: Router, activatedRoute: ActivatedRoute,  private productService: ProductService){
       let id = activatedRoute.params.subscribe(params => {
              
      this.productService. searchProducts(params['searchtext']).subscribe(
      products =>{
        this.products=products;
      
        if (this.products.length>7){this.more=true;} 
        this.searchtext=params['searchtext'];
      },

      error =>  console.error(error)
      );
     
      
  });



  }

  getProducts(id:number){
    this.productService.getProduct(id).subscribe(
      product =>{ this.products=product;
      	if (this.products.length>8){this.more=true;}},
      error => console.error(error)
    )

  }

  loadMore(searchtext:string){
 this.productService.searchMoreProducts(searchtext).subscribe(

      productmore =>{
	   this.products=this.products
       this.productmore=productmore
;		
      	
      	
      	if (this.productmore.length<8){this.more=false;}},
      error => console.error(error)
    )



  }
  

  private handleError(error: any) {
    console.error(error);
  }



}