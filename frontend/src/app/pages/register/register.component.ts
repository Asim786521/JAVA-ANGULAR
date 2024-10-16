// src/app/pages/register/register.component.ts
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.services';
import { HttpClientModule, provideHttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule, ReactiveFormsModule],
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  signupForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService, // Injecting AuthService
    private router: Router // Injecting Router
  ) {
    this.signupForm = this.fb.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role:'ROLE_ADMIN',
    });
  }

  onSubmit() {
    if (this.signupForm.valid) {
      console.log(this.signupForm.value);
      this.authService.register(this.signupForm.value).subscribe(
        (response) => {
          console.log('Registration successful:', response);
          this.router.navigate(['/login']); // Redirect to login page after successful registration
        },
        (error) => {
          console.error('Error during registration:', error);
        }
      );
    }
  }
}
