package com.inventory.businventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("bus/search")
    public ResponseEntity<List<Busroute>> searchBus(@RequestParam("source") String source, @RequestParam("destination") String destination, String date){
        List<Busroute> routes = inventoryService.searchBus(source, destination, date);
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @PostMapping("inventory")
    public ResponseEntity<Inventory> inventory(@RequestBody InventorySearch inventorySearch){
        Inventory inventory = inventoryService.inventory(inventorySearch);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

}
