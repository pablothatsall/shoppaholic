import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AddProductComponent } from './addProduct.component';
import { AdministrationComponent } from './administration.component';
import { AdministrationProductComponent } from './administrationProduct.component';
import { CartComponent } from './cart.component';
import { EditProductComponent } from './editProduct.component';
import { EditProfileComponent } from './editProfile.component';
import { ErrorComponent } from './error.component';


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
 //{ path: 'customer/:id_user', component: userprofileComponent},
  { path: 'home', component:HomeComponent },
  { path: 'home/search/:id', component:SearchComponent },//NO FUNCIONAA
  { path: 'login', component:LoginComponent },
  { path: 'signUp', component: SignUpComponent},
  { path: 'product/:id', component:ProductComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }

  
]

export const routing = RouterModule.forRoot(appRoutes);
