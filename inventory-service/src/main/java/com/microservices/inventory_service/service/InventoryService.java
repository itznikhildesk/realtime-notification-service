package com.microservices.inventory_service.service;

import com.microservices.inventory_service.dto.InventoryRequest;
import com.microservices.inventory_service.model.Inventory;
import com.microservices.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public Inventory createInventory(InventoryRequest request){
        Inventory inventory = Inventory.builder()
                .id(UUID.randomUUID())
                .skuCode(request.skuCode())
                .quantity(request.quantity()).build();

        inventoryRepository.save(inventory);
        log.info("Inventory created with id: {}", inventory.getId());
        return inventory;
    }


    public boolean isStockAvailable(String skuCode, int quantity){
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
