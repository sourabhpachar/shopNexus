package com.shopNexus.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

@Data
@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    private String zipcode;
    private String state;
    private String country;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order;



}
