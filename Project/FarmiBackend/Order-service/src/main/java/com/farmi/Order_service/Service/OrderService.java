package com.farmi.Order_service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmi.Order_service.Entity.Orders;
import com.farmi.Order_service.Repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Create Order
    public Orders createOrder(Orders order) {
        return orderRepository.save(order);
    }

    // Get All Orders
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get Order By Id
    public Orders getOrderById(Long id) {
        Optional<Orders> order = orderRepository.findById(id);

        if (order.isPresent()) {
            return order.get();
        } else {
            throw new RuntimeException("Order not found with id: " + id);
        }
    }

    // Update Order
    public Orders updateOrder(Long id, Orders orderDetails) {

        Orders existingOrder = getOrderById(id);

        existingOrder.setCustomerId(orderDetails.getCustomerId());
        existingOrder.setFarmerId(orderDetails.getFarmerId());
        existingOrder.setOrderDate(orderDetails.getOrderDate());
        existingOrder.setStatus(orderDetails.getStatus());
        existingOrder.setTotalAmount(orderDetails.getTotalAmount());

        return orderRepository.save(existingOrder);
    }

    // Delete Order
    public void deleteOrder(Long id) {

        Orders order = getOrderById(id);

        orderRepository.delete(order);
    }
}