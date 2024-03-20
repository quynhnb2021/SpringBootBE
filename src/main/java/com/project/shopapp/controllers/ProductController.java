package com.project.shopapp.controllers;

import com.project.shopapp.dtos.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Validated
@RequestMapping("api/v1/products")
public class ProductController {

    @PostMapping("")
    public ResponseEntity<String> creatProducts(@Valid @RequestBody ProductDTO productDto, BindingResult result) {
        try {
                if(result.hasErrors()){
                    List<String> errorMsg =  result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                    return ResponseEntity.badRequest().body(String.valueOf(errorMsg));
                }
                return ResponseEntity.ok("Product created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @GetMapping("")
    public ResponseEntity<String> getProducts(@RequestParam("page") int page,
                                              @RequestParam("limit") int limit) {
        return ResponseEntity.ok("getproducts here");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String productId) {
        return ResponseEntity.ok("Product with ID" + productId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {
        return ResponseEntity.ok(String.format("Product with id = ${id} deleted successfully"));
    }
 }
