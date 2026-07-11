package com.example.Orders.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.reactive.function.client.WebClient;

import com.example.Orders.DTO.OrderResponseDTO;
import com.example.Orders.DTO.ProductDTO;
import com.example.Orders.Entity.Order;
import com.example.Orders.Repository.OrderRepository;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @PostMapping("/placeOrder")
    public Mono<ResponseEntity<OrderResponseDTO>> placeOrder(@RequestBody Order order) {

        return webClientBuilder
                .build()
                .get()
                .uri("http://Product/products/" + order.getProductId())
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .map(productDTO -> {

                    OrderResponseDTO responseDTO = new OrderResponseDTO();

                    responseDTO.setOrderId(order.getId());
                    responseDTO.setProductId(order.getProductId());
                    responseDTO.setQuantity(order.getQuantity());

                    responseDTO.setProductName(productDTO.getName());
                    responseDTO.setProductPrice(productDTO.getPrice());

                    responseDTO.setTotalPrice(
                            order.getQuantity() * productDTO.getPrice());

                    orderRepository.save(order);

                    return ResponseEntity.ok(responseDTO);

                });
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}