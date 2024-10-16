import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { ProductService } from '../../../services/product.services';
 
import { Router, RouterModule } from '@angular/router';
 
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css'],
  standalone: true,
  imports: [CommonModule, RouterModule,FormsModule],  
})
export class CreateProductComponent {
  productForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private productService: ProductService, private router: Router) {
    this.productForm = this.formBuilder.group({
      name: ['', Validators.required],
    //   description: ['', Validators.required],
      price: ['', [Validators.required, Validators.min(0)]],
    //   imageUrl: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.productForm.valid) {
      this.productService.createProduct(this.productForm.value).subscribe(
        (response) => {
          console.log('Product created successfully:', response);
          this.router.navigate(['/products']); // Redirect to product list after successful creation
        },
        (error) => {
          console.error('Error creating product:', error);
        }
      );
    }
  }
}
