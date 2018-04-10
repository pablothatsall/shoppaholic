import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { AddProductComponent } from './addProduct.component';
import { AdministrationComponent } from './administration.component';
import { AdministrationProductComponent } from './administrationProduct.component';
import { CartComponent } from './cart.component';
import { EditProductComponent } from './editProduct.component';
import { EditProfileComponent } from './editProfile.component';
import { ErrorComponent } from './error.component';
import { ListComponent } from './list.component';
import { LoginComponent } from './login.component';
import { LoginErrorComponent } from './loginerror.component';
import { ManageUserComponent } from './manageUser.component';
import { OrderComponent } from './order.component';
import { OrderlistComponent } from './orderlist.component';
import { PaymentComponent } from './payment.component';
import { ProductComponent } from './product.component';
import { SearchComponent } from './search.component';
import { SignUpComponent } from './signUp.component';
import { userprofileComponent } from './userprofile.component';
import { HeaderComponent } from './header.component';
import { FooterComponent } from './footer.component';
import { CommentService } from './comment.service';
import { ProductService } from './product.service';
import { PedidoService } from './pedido.service';
import { CustomerService } from './customer.service';


@NgModule({
  declarations: [
    AppComponent,
    AddProductComponent,
    AdministrationComponent,
    AdministrationProductComponent,
    CartComponent,
    EditProductComponent,
    EditProfileComponent,
    ErrorComponent,
    ListComponent,
    LoginComponent,
    LoginErrorComponent,
    ManageUserComponent,
    OrderComponent,
    OrderlistComponent,
    PaymentComponent,
    ProductComponent,
    SearchComponent,
    SignUpComponent,
    userprofileComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule
  ],
  providers: [CommentService,ProductService,PedidoService,CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
