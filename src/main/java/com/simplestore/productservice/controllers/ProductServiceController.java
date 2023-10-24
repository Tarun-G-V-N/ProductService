package com.simplestore.productservice.controllers;

import com.simplestore.productservice.dtos.ProductRequestDTO;
import com.simplestore.productservice.dtos.ProductResponseDTO;
import com.simplestore.productservice.exceptions.ProductNotFoundException;
import com.simplestore.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductServiceController {
        private ProductService productService;

        @Autowired
        public ProductServiceController(ProductService productService) {

            this.productService = productService;
        }

        @GetMapping("/products/{id}")
        public ResponseEntity getTheProduct(@PathVariable int id) throws ProductNotFoundException {

            ProductResponseDTO productResponseDTO = productService.getProductById(id);

            return ResponseEntity.ok(productResponseDTO);
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
    }

