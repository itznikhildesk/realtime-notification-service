package com.microservices.order_service.dto;

import java.util.UUID;

public record OrderRequest(
        String skuCode,
        double price,
        int quantity
) {}
