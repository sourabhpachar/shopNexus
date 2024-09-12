package com.shopNexus.Repository;

import com.shopNexus.entity.Address;
import com.shopNexus.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBidirectionalTest {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    AddressRepository addressRepository;

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
        address.setOrder(order);
        addressRepository.save(address);


    }
    @Test
    public void UpdateOrderMethodTest(){
        Address address=addressRepository.findById(1L).get();
        address.setCity("jhunjhunu");
        address.getOrder().setStatus("delivered");

        addressRepository.save(address);


    }

    @Test
    public void DeleteAddress(){
        addressRepository.deleteById(1L);
    }

    @Test
    public void GetOrder(){
        Order order=orderRepository.findById(2L).get();
       // System.out.println(order);
    }
    @Test
    public void GetAddress(){
        Address address=addressRepository.findById(2L).get();
       // System.out.println(address);
    }


}
