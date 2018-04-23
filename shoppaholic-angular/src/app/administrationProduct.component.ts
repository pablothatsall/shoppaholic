
import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
import { Product} from './product.model';
import { Router, ActivatedRoute } from '@angular/router';
import { Http } from '@angular/http';


@Component({
    selector: 'administrationProduct',
    templateUrl: './administrationProduct.component.html'
  })
  export class AdministrationProductComponent {
  	products:Product[];

  	constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private productService: ProductService){
       let id = activatedRoute.params.subscribe(params => {
       	 this.productService.getProducts().subscribe(
      products =>{
        this.products=products;
        
        
      
      },
      error =>  console.error(error)
      );
     
      
  });

  }



    private handleError(error: any) {
    console.error(error);
  }
 deleteProduct(id:number){

    this.productService.deleteProduct(id).subscribe(
       
    products =>{ 
        products
       
        },
      error => console.error(error)
    )
    this.router.navigate(['/admin'])
  }

}
