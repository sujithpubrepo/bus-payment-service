package com.admin.busadminservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AdminController {

    @Autowired
    public BusrouteRepository busrouteRepository;

    @GetMapping("busroutes")
    public ResponseEntity<List<Busroute>> getRoutes(){
        List<Busroute> routes = busrouteRepository.findAll();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @GetMapping("busroutes/{busid}")
    public ResponseEntity<Busroute> getRoutes(@PathVariable("busid") String busid){
        Busroute route = busrouteRepository.findByBusid(busid);
        return new ResponseEntity<>(route, HttpStatus.OK);
    }

    @PostMapping("busroutes")
    public ResponseEntity<Busroute> addRoute(@RequestBody Busroute busroute){
        String id = "BUS" + String.valueOf((int)(Math.random()*100000));
        System.out.println("ssfsdf "+id);
        System.out.println(busroute);
        busroute.setBusid(id);
        busrouteRepository.save(busroute);
        return new ResponseEntity<>(busroute, HttpStatus.OK);
    }

    @PatchMapping("busroutes")
    public ResponseEntity<Busroute> updateRoute(@RequestBody Busroute busroute){
        busrouteRepository.save(busroute);
        return new ResponseEntity<>(busroute, HttpStatus.OK);
    }

    @DeleteMapping("busroutes/{busid}")
    public ResponseEntity<Busroute> deleteRoute(@PathVariable("busid") String busid){
        Busroute route = busrouteRepository.findByBusid(busid);
        busrouteRepository.delete(route);
        return new ResponseEntity<>(route, HttpStatus.OK);
    }
}
