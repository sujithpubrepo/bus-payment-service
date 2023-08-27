package com.inventory.businventoryservice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "inventories")
public class Inventory {
    @Id
    @Column(name = "inventoryid", nullable = false, length = 10)
    private String inventoryid;

    @Column(name = "busid", nullable = false, length = 10)
    private String busid;

    @Column(name = "availableseats", nullable = false)
    private Integer availableseats;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "lastupdated", nullable = false)
    private LocalDate lastupdated;

    @Column(name = "price", nullable = false)
    private Double price;

}