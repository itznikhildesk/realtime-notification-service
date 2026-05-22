package com.microservices.product_service.dto;

public record ProductRequest(
        String name,
        String description,
        String price
) { }
