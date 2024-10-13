package com.example.ecommerce.controller;


import com.example.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;


import org.springframework.web.bind.annotation.*;
import com.example.ecommerce.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    ;

    @PostMapping
////    @PreAuthorize("hasRole('ADMIN')") // Only ADMIN can create products
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')") // Only ADMIN can update products
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')") // Only ADMIN can delete products
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
//}
}