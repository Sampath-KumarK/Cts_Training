package com.farmi.Order_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmi.Order_service.Entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long>{

}
