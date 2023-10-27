package com.simplestore.productservice.controllers;

import com.simplestore.productservice.dtos.ProductRequestDTO;
import com.simplestore.productservice.dtos.ProductResponseDTO;
import com.simplestore.productservice.exceptions.ProductNotFoundException;
import com.simplestore.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProductServiceController {
        private ProductService productService;

        @Autowired
        public ProductServiceController(ProductService productService) {

            this.productService = productService;
        }

        @GetMapping("/products/{id}")
        public ResponseEntity getProductByID(@PathVariable int id) throws ProductNotFoundException{

            ProductResponseDTO productResponseDTO = productService.getProductById(id);
            return ResponseEntity.ok(productResponseDTO);
//            try {
//                ProductResponseDTO productResponseDTO = productService.getProductById(id);
//                return ResponseEntity.ok(productResponseDTO);
//            }
//            catch (ProductNotFoundException exception) {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with ID: "+id+" not available in the store!!");
//            }
        }

        @GetMapping("/products")
        public ResponseEntity getAllProducts() {

            List<ProductResponseDTO> productResponseDTOS = productService.getAllProducts();
            return ResponseEntity.ok(productResponseDTOS);
        }
        @PostMapping("/products")
        public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO) {

            ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDTO);
            return ResponseEntity.ok(productResponseDTO);
        }
        @PutMapping("/products/{id}")
        public ResponseEntity updateProduct(@PathVariable int id, @RequestBody ProductRequestDTO productRequestDTO) {

            if(productService.updateProduct(id, productRequestDTO)) return ResponseEntity.ok("Product updated Successfully");

            return ResponseEntity.badRequest().body("Your request is not valid!!");
        }
        @DeleteMapping("/products/id")
        public ResponseEntity deleteProduct(@PathVariable int id) {

            if(productService.deleteProduct(id)) return ResponseEntity.ok("Product is deleted Successfully");

            return ResponseEntity.badRequest().body("Your request is not valid!!");
        }
    }

