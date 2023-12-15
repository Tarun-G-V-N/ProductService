package com.simplestore.productservice.services;

import com.simplestore.productservice.models.Category;
import com.simplestore.productservice.models.Order;
import com.simplestore.productservice.models.Price;
import com.simplestore.productservice.models.Product;
import com.simplestore.productservice.repositories.CategoryRepository;
import com.simplestore.productservice.repositories.OrderRepository;
import com.simplestore.productservice.repositories.PriceRepository;
import com.simplestore.productservice.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceWithDBDemo {
    private CategoryRepository categoryRepository;
    private PriceRepository priceRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    public void initService() {

        Category category1 = new Category("Electronics");
        categoryRepository.save(category1);

        Price price1 = new Price("INR", 125000.00, 10.0);
        Price price2 = new Price("INR", 50000.00, 10.0);
        priceRepository.save(price1);
        priceRepository.save(price2);

        Product product1 = new Product("Iphone", price1, "Brand New Phone", category1, "image URL");
        Product product2 = new Product("Apple Watch", price2, "Brand New Watch", category1, "image URL");
        productRepository.save(product1);
        productRepository.save(product2);
        categoryRepository.save(category1);

        Order order = new Order(List.of(product1, product2));
        orderRepository.save(order);
    }
}
