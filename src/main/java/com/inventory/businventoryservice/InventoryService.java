package com.inventory.businventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private BusrouteRepository busrouteRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Busroute> searchBus(String source, String destination, String date){
        List<Busroute> routes = busrouteRepository.findAllBySourceAndDestination(source, destination);
        return routes;
    }

    public Inventory inventory(InventorySearch inventorySearch){

        Inventory inventory = inventoryRepository.findInventoriesByDateAndBusid(inventorySearch.getDate(),inventorySearch.getBusid());
        if(inventory == null){
            Busroute route = busrouteRepository.findByBusid(inventorySearch.getBusid());
            String inventoryId ="INV"+(int)(Math.random()*100000);
            inventory = new Inventory();
            inventory.setAvailableseats(route.getTotalseats());
            inventory.setBusid(inventorySearch.getBusid());
            inventory.setLastupdated(LocalDate.now());
            inventory.setDate(inventorySearch.getDate());
            inventory.setInventoryid(inventoryId);

            inventoryRepository.save(inventory);
        }
        return inventory;
    }

    public Booking getBookingData(InventoryLookup inventoryLookup){
        String inventoryId = inventoryLookup.getInventoryid();
        Booking booking =  new Booking();
        booking.setPaymentid(inventoryLookup.getPaymentid());
        booking.setBookingid(inventoryLookup.getBookingid());
        booking.setBusid(inventoryLookup.getBusid());
        booking.setStatus("PENDING");
        booking.setType(inventoryLookup.getType());
        Optional<Inventory> inventoryOptional =inventoryRepository.findById(inventoryId);

        if(inventoryOptional.isPresent() && inventoryOptional.get()!=null){
            Inventory inventory = inventoryOptional.get();
            Integer updatedseats = inventory.getAvailableseats() - inventoryLookup.getNumberofseats();
            inventory.setAvailableseats(updatedseats);
            inventory.setLastupdated(LocalDate.now());
            inventoryRepository.save(inventory);
            booking.setBookingDate(inventory.getDate());
            booking.setSeatsbooked(inventoryLookup.getNumberofseats());
            booking.setStatus("SUCCESS");

        }else{
            booking.setStatus("FAILURE");
        }
        return booking;
    }

}
