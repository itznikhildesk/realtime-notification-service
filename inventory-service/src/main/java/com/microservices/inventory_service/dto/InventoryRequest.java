package com.microservices.inventory_service.dto;

public record InventoryRequest(
        String skuCode,
        int quantity
) {
}
