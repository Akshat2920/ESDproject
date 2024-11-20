package org.akshat.yummy.controller;

import org.akshat.yummy.dto.*;
import org.akshat.yummy.entity.Product;
import org.akshat.yummy.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.akshat.yummy.entity.Product;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")

public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody @Valid ProductRequest request) {
        return ResponseEntity.ok(productService.addProduct(request));
    }

    @GetMapping("{Name}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("Name") String Name) {
        return ResponseEntity.ok(productService.retrieveProduct(Name));
    }

    @DeleteMapping("{Name}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("Name") String Name) {
        productService.deleteProduct(Name);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PatchMapping("{Name}")
    public ResponseEntity<String> updateCustomer(@PathVariable("Name") String Name,@RequestBody @Valid ProductUpdate request) {
        return ResponseEntity.ok(productService.updateProduct(request, Name));
    }

    @GetMapping("range")
    public List<Product> getProductsByPriceRange(@RequestParam Integer low, @RequestParam Integer high) {
        return productService.getTopProducts(low, high);
    }
}
