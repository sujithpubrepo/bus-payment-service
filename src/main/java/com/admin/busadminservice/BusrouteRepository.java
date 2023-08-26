package com.admin.busadminservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BusrouteRepository extends JpaRepository<Busroute, String> {
   Busroute findByBusid(String busid);
}