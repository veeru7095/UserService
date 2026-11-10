package com.example.demo.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Dto.InventoryDto;

@FeignClient(name = "INVENTORYSERVICE")
public interface InventoryClient {

    @GetMapping("/api/inventory/getProduct/{id}")
    public InventoryDto getProductBYid(
            @PathVariable("id") Long id
    );
}