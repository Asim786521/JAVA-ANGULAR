import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { ProductListComponent } from './pages/products/products-list/product.component';
import { EditProductComponent } from './pages/products/edit-product/edit-product.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: RegisterComponent },
  { path: 'products', component: ProductListComponent },
  { path: 'products/:id', component: EditProductComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },  
  { path: '**', redirectTo: '/login' }  
  
];

 
export class AppRoutingModule { }
