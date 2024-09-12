package com.shopNexus.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@NamedQueries(
        {
                @NamedQuery(name="Product.findByPrice", query = "select p from Product p where p.price=?1"),
                @NamedQuery(name="Product.findAllOrderByPriceDesc",query = "select p from Product p Order By p.price Desc")
        }
        )
@NamedNativeQuery(name = "Product.NamedNativeQueryPrice" ,query="select * from Product p where p.price =?1",resultClass = Product.class)
@Table(name="product",schema = "shopNexus",uniqueConstraints = {@UniqueConstraint(name = "sku_unique",columnNames = "stock_keeping_unit")})
public class Product {

    @SequenceGenerator(name = "id_generator",sequenceName ="id_generator",allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_generator")
    @Id
    private Long Id;

    private BigDecimal price;

    private boolean active;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    private String description;

    private String imageUrl;

    @Column(nullable = false)
    private String name;


    @Column(name="stock_keeping_unit",nullable = false)
    private String sku;


}
