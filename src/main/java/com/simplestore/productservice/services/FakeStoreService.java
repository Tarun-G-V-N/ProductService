package com.simplestore.productservice.services;

import com.simplestore.productservice.dtos.ProductRequestDTO;
import com.simplestore.productservice.dtos.ProductResponseDTO;
import com.simplestore.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreService implements ProductService{
    private final RestTemplateBuilder restTemplateBuilder;
    public FakeStoreService (RestTemplateBuilder restTemplateBuilder) {

        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String fakeStoreURL = "https://fakestoreapi.com/products/" + id;
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.getForEntity(fakeStoreURL, ProductResponseDTO.class);

        return productResponse.getBody();
    }

    @Override
    public Product createProduct(ProductRequestDTO product) {
        return null;
    }

    @Override
    public Product updateProduct(ProductRequestDTO product) {
        return null;
    }

    @Override
    public Product deleteProduct(ProductRequestDTO product) {
        return null;
    }
}
