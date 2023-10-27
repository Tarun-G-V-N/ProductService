package com.simplestore.productservice.clients;

import com.simplestore.productservice.dtos.FakeStoreProductRequestDTO;
import com.simplestore.productservice.dtos.FakeStoreProductResponseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class FakeStoreClient {

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductResponseDTO getProductById(int id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        String fakeStoreURL = "https://fakestoreapi.com/products/" + id;
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.getForEntity(fakeStoreURL, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        String fakeStoreURL = "https://fakestoreapi.com/products";
        ResponseEntity<FakeStoreProductResponseDTO[]> productsResponse = restTemplate.getForEntity(fakeStoreURL, FakeStoreProductResponseDTO[].class);
        return List.of(productsResponse.getBody());
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        String fakeStoreURL = "https://fakestoreapi.com/products/";
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.postForEntity(fakeStoreURL, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public boolean updateProduct(int id, FakeStoreProductRequestDTO fakeStoreProductRequestDTO) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        String fakeStoreURL = "https://fakestoreapi.com/products/" + id;
        restTemplate.put(fakeStoreURL, fakeStoreProductRequestDTO);
        return true;
    }

    public boolean deleteProduct(int id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        String fakeStoreURL = "https://fakestoreapi.com/products/" + id;
        restTemplate.delete(fakeStoreURL);
        return true;
    }
}
