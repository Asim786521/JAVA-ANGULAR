import { Component, OnInit } from "@angular/core";
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from "@angular/forms";
import { ProductService } from "../../../services/product.services";
import { ActivatedRoute, Router, RouterModule } from "@angular/router";
import { Product } from "../../../model/product.model";

import { CommonModule } from "@angular/common";
@Component({
  selector: "app-edit-product",
  templateUrl: "./edit-product.component.html",
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule,ReactiveFormsModule],
  styleUrls: ["./edit-product.component.css"],
})
export class EditProductComponent implements OnInit {
  productForm: FormGroup;
  productId: string;

  constructor(
    private formBuilder: FormBuilder,
    private productService: ProductService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.productForm = this.formBuilder.group({
      name: ["", Validators.required],
      description: ["", Validators.required],
      price: ["", [Validators.required, Validators.min(0)]],
      imageUrl: ["", Validators.required],
    });
    this.productId = this.route.snapshot.paramMap.get("id")!; // Get product ID from route parameters
  }

  ngOnInit() {
    this.productService.getProductById(this.productId).subscribe(
      (product: Product) => {
        this.productForm.patchValue(product); // Populate the form with existing product data
      },
      (error) => {
        console.error("Error fetching product:", error);
      }
    );
  }

  onSubmit() {
    if (this.productForm.valid) {
      this.productService
        .updateProduct(this.productId, this.productForm.value)
        .subscribe(
          (response) => {
            console.log("Product updated successfully:", response);
            this.router.navigate(["/products"]); // Redirect to product list after successful update
          },
          (error) => {
            console.error("Error updating product:", error);
          }
        );
    }
  }
}
