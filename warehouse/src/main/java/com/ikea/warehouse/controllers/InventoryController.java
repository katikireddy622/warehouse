package com.ikea.warehouse.controllers;

import com.ikea.warehouse.models.Articles;
import com.ikea.warehouse.models.json.InventoryJson;
import com.ikea.warehouse.repository.InventoryRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    final
    InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @PostMapping(path = "/updateList",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Articles> updateInventory(@RequestBody InventoryJson inventoryJson)
    {
        return inventoryRepository.saveAll(inventoryJson.getInventory());
    }

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Articles saveOrUpdateArticle(@RequestBody Articles article)
    {
        return inventoryRepository.save(article);
    }

    @GetMapping(path = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Articles> getAllInventory()
    {
        return inventoryRepository.findAll();
    }
}
