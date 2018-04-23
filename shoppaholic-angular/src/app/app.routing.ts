import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AddProductComponent } from './addProduct.component';
import { AdministrationComponent } from './administration.component';
import { AdministrationProductComponent } from './administrationProduct.component';
import { CartComponent } from './cart.component';
import { EditProductComponent } from './editProduct.component';
import { EditProfileComponent } from './editProfile.component';
import { ErrorComponent } from './error.component';

import { topProductsComponent } from './topProducts.component';
import { LoginErrorComponent } from './loginerror.component';
import { ManageUserComponent } from './manageUser.component';
import { OrderComponent } from './order.component';
import { OrderlistComponent } from './orderlist.component';
import { PaymentComponent } from './payment.component';
import { ProductComponent } from './product.component';
import { SearchComponent } from './search.component';
import { NavigationComponent } from './navigation.component';
import { FooterComponent } from './footer.component';

import { userprofileComponent } from './userprofile.component';
import { LoginComponent } from './login.component';
import { SignUpComponent } from './signUp.component';
import { HomeComponent } from './home.component';


const appRoutes = [

  { path: 'order/:id', component: OrderComponent},
  { path: 'adminproducts', component: AdministrationProductComponent},
  { path: 'editproduct/:id', component: EditProductComponent},
  { path: 'addproduct', component: AddProductComponent},
  { path: 'manageusers', component: ManageUserComponent},
  { path: 'admin', component: AdministrationComponent},
  { path: 'customer/:id', component: userprofileComponent},
  { path: 'home', component:HomeComponent },
  { path: 'editprofile/:id', component:EditProfileComponent },
  { path: 'myorders/:id', component:OrderlistComponent },
  { path: 'cart/:id', component:CartComponent },
  { path: 'login', component:LoginComponent },
  { path: 'loginError', component:LoginErrorComponent },
  { path: 'signUp', component: SignUpComponent},
  { path: 'product/:id', component:ProductComponent },
  { path: 'search/:searchtext', component:SearchComponent},
  { path: 'payment/:id', component:PaymentComponent },  

  { path: '', redirectTo: 'home', pathMatch: 'full' }

  
]

export const routing = RouterModule.forRoot(appRoutes);
