package com.shopNexus.Repository;


import com.shopNexus.entity.Address;
import com.shopNexus.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUnidirectionalTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void saveOrderMethodTest(){
        Order order=new Order();
        order.setOrderTrackingNumber("as33994");
        order.setStatus("new");
        order.setTotalPrice(new BigDecimal(1234));
        order.setTotalQuantity(1);

        Address address=new Address();
        address.setCity("jaipur");
        address.setState("rajasthan");
        address.setCountry("india");
        address.setStreet("gali 1 no");
        address.setZipcode("asdfadf34567u8i");

        order.setBillingAddress(address);
        orderRepository.save(order);

    }

    @Test
    public void UpdateMethodTest(){
        Order order=orderRepository.findById(1L).get();
        order.getBillingAddress().setCity("kudaipur");
        orderRepository.save(order);

    }

    @Test
    public void DeleteMethodTest(){
        orderRepository.deleteById(1L);

    }
    @Test
    public void GetOrderMethodTest(){
       Order order= orderRepository.findById(2L).get();
        System.out.println(order.toString());

    }






}
