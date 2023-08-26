package com.inventory.businventoryservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusrouteRepository extends JpaRepository<Busroute, String> {
   Busroute findByBusid(String busid);


   List<Busroute> findAllBySourceAndDestination(String source, String destination);
}