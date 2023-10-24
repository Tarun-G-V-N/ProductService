package com.simplestore.productservice.services;

import com.simplestore.productservice.dtos.ProductRequestDTO;
import com.simplestore.productservice.dtos.ProductResponseDTO;
import com.simplestore.productservice.exceptions.ProductNotFoundException;
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

        RestTemplate restTemplate = restTemplateBuilder.build();
        String fakeStoreURL = "https://fakestoreapi.com/products";
        ResponseEntity<ProductResponseDTO[]> productsResponse = restTemplate.getForEntity(fakeStoreURL, ProductResponseDTO[].class);
        return List.of(productsResponse.getBody());
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException{

        if(id > 20) {
            throw new ProductNotFoundException(id);
        }

        RestTemplate restTemplate = restTemplateBuilder.build();
        String fakeStoreURL = "https://fakestoreapi.com/products/" + id;
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.getForEntity(fakeStoreURL, ProductResponseDTO.class);

        return productResponse.getBody();
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String fakeStoreURL = "https://fakestoreapi.com/products/";
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.postForEntity(fakeStoreURL, productRequestDTO, ProductResponseDTO.class);
        return productResponse.getBody();
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
