package com.farmi.Order_service.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="orders_service")
public class Orders {

	    private Long orderId;

	    private Long customerId;

	    private Long farmerId;

	    private LocalDateTime orderDate;

	    private String status;

	    private Double totalAmount;
	
}
