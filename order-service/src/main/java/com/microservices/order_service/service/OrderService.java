package com.microservices.order_service.service;

import com.microservices.order_service.client.InventoryClient;
import com.microservices.order_service.dto.OrderRequest;
import com.microservices.order_service.model.Order;
import com.microservices.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public Order placeOrder(OrderRequest request){

        var isProductInStock = inventoryClient.isInStock(request.skuCode(), request.quantity());

        if(isProductInStock){
            Order order = Order.builder()
                               .id(UUID.randomUUID())
                               .orderNumber(UUID.randomUUID().toString())
                               .price(request.price())
                               .quantity(request.quantity()).build();

            orderRepository.save(order);
            orderRepository.save(order);
            log.info("Order placed successfully: {}", order.getId());
            return order;
        } else {
            throw new RuntimeException("Product with SKU code " + request.skuCode() + " is not in stock");
        }
    }
}
