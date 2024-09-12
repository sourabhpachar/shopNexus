package com.shopNexus.Repository;

import com.shopNexus.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {


    public Product findByName(String name);

    public Optional<Product> findById(Long Id);

    //find by multiple fields

    public List<Product> findByNameOrDescription(String name,String description);

    public List<Product> findByNameAndDescription(String name,String description);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByNameContaining(String match);

    List<Product> findByNameLike(String match);

    List<Product>findByPriceBetween(BigDecimal firstPrice, BigDecimal lastPrice);

    List<Product>findByDateCreatedBetween(LocalDateTime startdate, LocalDateTime enddate);

    List<Product>findByNameIn(List<String> names);

    List<Product>findFirst2ByOrderByNameAsc();
    List<Product>findFirst2ByOrderByPriceDesc();


    //define JPQL Query with annotation with index or poosition parameters

    @Query("select p from Product p where p.name=?1 or p.description=?2")
    List<Product>findByNameOrDescriptionJPQLIndexParams(String name,String description);

    //define JPQL Query with annotation with named parameters
    @Query("select p from Product p where p.name=:nam or p.description=:desc")
    List<Product>findByNameOrDescriptionJPQLNamedParams(@Param("nam") String name,@Param("desc") String description);

 //define native sql query with index parameters
    @Query(value = "select * from Product p where p.name=?1 or p.description=?2",nativeQuery = true)
    List<Product>findByNameOrDescriptionNativeSQLIndexParams(String name,String description);

    //define Native sql Query with annotation with named parameters
    @Query(value = "select * from Product p where p.name=:na or p.description=:de",nativeQuery = true)
    List<Product>findByNameOrDescriptionNativeSQLNamedParams(@Param("na") String name,@Param("de") String description);

    //define named jpql Query with namedquery annotation with index parameters
    Product findByPrice(BigDecimal price);

    //define named jpql Query with namedquery annotation with index parameters
    List<Product> findAllOrderByPriceDesc();


    //define named native SQL Query with namednativequery annotation with index parameters
    @Query(nativeQuery = true)
    List<Product>  NamedNativeQueryPrice(BigDecimal price);



}
