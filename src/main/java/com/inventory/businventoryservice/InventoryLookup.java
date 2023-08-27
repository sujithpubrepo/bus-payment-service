package com.inventory.businventoryservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryLookup {

    private String inventoryid;

    private Integer numberofseats;

    private String bookingid;

    private String busid;

    private String paymentid;

    private String type;
}
