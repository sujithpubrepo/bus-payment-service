package com.inventory.businventoryservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
   Inventory findInventoriesByDateAndBusid(LocalDate date, String busid);
}