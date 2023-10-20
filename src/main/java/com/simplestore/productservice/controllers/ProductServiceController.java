package com.simplestore.productservice.controllers;

import com.simplestore.productservice.dtos.ProductResponseDTO;
import com.simplestore.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductServiceController {
        private ProductService productService;

        @Autowired
        public ProductServiceController(ProductService productService) {

            this.productService = productService;
        }

        @GetMapping("/products/{id}")
        public ResponseEntity getTheProduct(@PathVariable int id) {

            ProductResponseDTO productResponseDTO = productService.getProductById(id);

            return ResponseEntity.ok(productResponseDTO);
        }

    @GetMapping("/products")
        public ResponseEntity getAllProducts() {

            List<ProductResponseDTO> productResponseDTOS = productService.getAllProducts();
            return ResponseEntity.ok(productResponseDTOS);
        }
    }

