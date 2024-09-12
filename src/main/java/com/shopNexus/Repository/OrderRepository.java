package com.shopNexus.Repository;

import com.shopNexus.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByOrderTrackingNumber(String orderTrackingNumber);

}
