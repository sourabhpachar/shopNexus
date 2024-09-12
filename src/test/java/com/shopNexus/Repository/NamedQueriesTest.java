package com.shopNexus.Repository;

import com.shopNexus.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {
    @Autowired
    private ProductRepository productRepository;


    @Test
    void findByPriceUsingNamedJpqlQuery(){
        Product product=productRepository.findByPrice(new BigDecimal(100));
        System.out.println(product);
    }

    @Test
    void findAllOrderByPriceDesc(){
        List<Product> products= productRepository.findAllOrderByPriceDesc();
        products.forEach(product -> {
            System.out.println(product.getName());
        });
    }
    @Test
    void findBfindByPriceNativeQueryyPriceMethod(){
        List<Product> products=productRepository.NamedNativeQueryPrice(new BigDecimal(100));
        products.forEach(product -> {
            System.out.println(product.getName());
        });
        System.out.println(products);
    }
}
