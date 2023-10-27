package com.simplestore.productservice.services;

import com.simplestore.productservice.dtos.ProductRequestDTO;
import com.simplestore.productservice.dtos.ProductResponseDTO;
import com.simplestore.productservice.models.Product;

import java.util.List;

public interface ProductService {

    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(int id);
    ProductResponseDTO createProduct(ProductRequestDTO product);

    boolean updateProduct(int id, ProductRequestDTO productRequestDTO);

    boolean deleteProduct(int id);

}
