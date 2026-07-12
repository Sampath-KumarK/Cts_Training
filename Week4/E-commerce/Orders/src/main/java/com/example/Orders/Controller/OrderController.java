package com.example.Orders.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.Orders.DTO.OrderResponseDTO;
import com.example.Orders.DTO.ProductDTO;
import com.example.Orders.Entity.Order;
import com.example.Orders.Repository.OrderRepository;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    private final WebClient.Builder webClientBuilder;

    public OrderController(OrderRepository orderRepository, WebClient.Builder webClientBuilder) {
        this.orderRepository = orderRepository;
        this.webClientBuilder = webClientBuilder;
    }

    @PostMapping("/placeOrder")
    public Mono<ResponseEntity<OrderResponseDTO>> placeOrder(@RequestBody Order order) {

        return webClientBuilder
                .build()
                .get()
                .uri("http://PRODUCT/products/" + order.getProductId())
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .map(productDTO -> {

                    Order savedOrder = orderRepository.save(order);

                    OrderResponseDTO responseDTO = new OrderResponseDTO();

                    responseDTO.setOrderId(savedOrder.getId());
                    responseDTO.setProductId(order.getProductId());
                    responseDTO.setQuantity(order.getQuantity());

                    responseDTO.setProductName(productDTO.getName());
                    responseDTO.setProductPrice(productDTO.getPrice());

                    responseDTO.setTotalPrice(
                            order.getQuantity() * productDTO.getPrice());

                    return ResponseEntity.ok(responseDTO);

                });
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}