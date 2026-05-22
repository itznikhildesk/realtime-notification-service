package com.microservices.inventory_service.controller;

import com.microservices.inventory_service.dto.InventoryRequest;
import com.microservices.inventory_service.model.Inventory;
import com.microservices.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    ResponseEntity<Inventory> createInventory(@RequestBody InventoryRequest request){
        return ResponseEntity.ok(inventoryService.createInventory(request));
    }

    @GetMapping
    ResponseEntity<Boolean> existInInventory(@RequestParam String skuCode, @RequestParam int quantity){
        return ResponseEntity.ok(inventoryService.isStockAvailable(skuCode, quantity));
    }

    @GetMapping("fetch-all")
    ResponseEntity<List<Inventory>> getAllInventory(){
        return ResponseEntity.ok(inventoryService.getAllInventory());
    }
}
