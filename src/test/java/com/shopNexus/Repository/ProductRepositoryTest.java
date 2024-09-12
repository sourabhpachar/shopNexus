package com.shopNexus.Repository;

import com.shopNexus.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    //create a product

    @Test
    void Save(){
        //create product

        Product product=new Product();
        product.setName("lifebuoy");
        product.setDescription("product 1 desc");
        product.setSku("sasdfa1213");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("https://asdfa.com");

        //save product

        Product SavedProduct=productRepository.save(product);

        //display product
        System.out.println(SavedProduct.getId());
        System.out.println(SavedProduct.toString());

    }

    @Test
    void updateUsingSaveMethod(){
        //retrieve the object by id
       Long id=1l;
        Product product=productRepository.findById(id).get();

        //update the object
        product.setName("lux");
        product.setDescription("updated project desc");

        //save the update object back
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Product product=productRepository.findById(1l).get();
        System.out.println(product);
    }

    @Test
    void saveAllMethod(){
        //create product

        Product product=new Product();
        product.setName("lifebuoy");
        product.setDescription("product 2 desc");
        product.setSku("sasdfa121szdfs3");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("https://asdfa.com/sdfas");

        //create product

        Product product3=new Product();
        product3.setName("dettol");
        product3.setDescription("product 3 desc");
        product3.setSku("sasdfa121kkk3");
        product3.setPrice(new BigDecimal(100));
        product3.setActive(true);
        product3.setImageUrl("https://asdfa.com");

        productRepository.saveAll(List.of(product,product3));

    }

    @Test
    void findAllMethod(){
List<Product> allproducts=productRepository.findAll();
       allproducts.forEach((product -> System.out.println(product.getName())));
    }

    @Test
    void DeleteByIdMethod(){
        productRepository.deleteById(1l);
    }
    @Test
    void DeleteMethod(){
        //find an entity by id
        Long id=2l;
        Product product=productRepository.findById(id).get();

        //delete (entity)
        productRepository.delete(product);

    }

    @Test
    void DeleteAllMethod(){
      // productRepository.deleteAll();

        Product prd1=productRepository.findById(7l).get();
        Product prd2=productRepository.findById(8l).get();

        productRepository.deleteAll(List.of(prd1,prd2));
    }

    @Test
    void CountMethod(){
        Long count=productRepository.count();
        System.out.println(count);

    }

    @Test
    void ExistsByIdMethod(){
        System.out.println(productRepository.existsById(9l));

    }

}