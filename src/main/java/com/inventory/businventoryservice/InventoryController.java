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
    private BusrouteRepository busrouteRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("bus/search")
    public ResponseEntity<List<Busroute>> searchBus(@RequestParam("source") String source, @RequestParam("destination") String destination, String date){
        List<Busroute> routes = busrouteRepository.findAllBySourceAndDestination(source, destination);
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @PostMapping("inventory")
    public ResponseEntity<Inventory> inventory(@RequestBody InventorySearch inventorySearch){

        Inventory inventory = inventoryRepository.findInventoriesByDateAndBusid(inventorySearch.getDate(),inventorySearch.getBusid());
        if(inventory == null){
            inventory = new Inventory();
            Busroute route = busrouteRepository.findByBusid(inventorySearch.getBusid());
            inventory.setAvailableseats(route.getTotalseats());
            inventory.setBusid(inventorySearch.getBusid());
            inventory.setLastupdated(LocalDate.now());
            inventory.setDate(inventorySearch.getDate());
            inventory.setInventoryid("INV"+String.valueOf((int)(Math.random()*100000)));
            inventoryRepository.save(inventory);
        }
         return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

}
