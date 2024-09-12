package com.shopNexus.Repository;

import com.shopNexus.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findByNameMethod(){
      Product fetchedProduct= productRepository.findByName("dettol");
        System.out.println(fetchedProduct);
    }
    @Test
    void findByIdMethod(){
        Product fetchedProduct= productRepository.findById(9l).get();
        System.out.println(fetchedProduct);
    }

    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> products=productRepository.findByNameOrDescription("lifebuoy","product 3 desc");
        products.forEach(product -> {
            System.out.println(product.getName());
        });
        System.out.println(products);
    }
   @Test
    void findDistinctByNameMethod(){
        Product product=productRepository.findDistinctByName("dettol");
       System.out.println(product);
   }

   @Test
   void findByPriceGreaterthanMethod(){
        List<Product> products=productRepository.findByPriceGreaterThan(new BigDecimal(90));
       products.forEach(product -> {
           System.out.println(product.getName());
       });
   }
    @Test
    void findByPriceLessthanMethod(){
        List<Product> products=productRepository.findByPriceLessThan(new BigDecimal(900));
        products.forEach(product -> {
            System.out.println(product.getName());
        });
    }

    @Test
    void findByNameContainingMethod(){
        List<Product> products=productRepository.findByNameContaining("ett");
        products.forEach(product -> {
            System.out.println(product.getName());
        });
    }

    @Test
    void findByNameLikeMethod(){
        List<Product> products=productRepository.findByNameLike("Dettol");
        products.forEach(product -> {
            System.out.println(product.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> products=productRepository.findByPriceBetween(new BigDecimal(70),new BigDecimal(100));

        products.forEach(product -> {
            System.out.println(product.getName());
        });
    }

    @Test
   void findByDateCreatedBetween(){
        ;
        LocalDateTime startDate=LocalDateTime.of(2024,8,25,1,03,0);

        LocalDateTime endDate=LocalDateTime.of(2024,8,25,1,05,0);


        List<Product> products=productRepository.findByDateCreatedBetween(startDate,endDate);

        products.forEach(product -> {
            System.out.println(product.getName());
        });
    }


    @Test
   void findByNameInMethod(){
        List<String> names=List.of("lifebuoy","lux");
        List<Product> products=productRepository.findByNameIn(names);

        products.forEach(product -> {
            System.out.println(product.getName());
        });
   }

@Test
    void findFirst2ByOrderByNameAscMethod(){
    List<Product> products=productRepository.findFirst2ByOrderByNameAsc();
    products.forEach(product -> {
        System.out.println(product.getName());
    });
}
    @Test
    void findFirst2ByOrderByPriceDesc(){
        List<Product> products=productRepository.findFirst2ByOrderByPriceDesc();
        products.forEach(product -> {
            System.out.println(product.getName());
        });
    }

    @Test
    void findByNameOrDescriptionJPQLIndexParams(){
        List<Product> products=productRepository.findByNameOrDescriptionJPQLIndexParams("lifebuoy","product 3 desc");
        products.forEach(product -> {
            System.out.println(product.getName());
        });
        System.out.println(products);
    }


    @Test
    void findByNameOrDescriptionJPQLNamedParams(){
        List<Product> products=productRepository.findByNameOrDescriptionJPQLNamedParams("lifebuoy","product 3 desc");
        products.forEach(product -> {
            System.out.println(product.getName());
        });
        System.out.println(products);
    }

    @Test
    void findByNameOrDescriptionNativeSQLIndexParams(){
        List<Product> products=productRepository.findByNameOrDescriptionNativeSQLIndexParams("lifebuoy","product 3 desc");
        products.forEach(product -> {
            System.out.println(product.getName());
        });
        System.out.println(products);
    }

    @Test
    void findByNameOrDescriptionNativeSQLNamedParams(){
        List<Product> products=productRepository.findByNameOrDescriptionNativeSQLIndexParams("lifebuoy","product 3 desc");
        products.forEach(product -> {
            System.out.println(product.getName());
        });
        System.out.println(products);
    }





}

