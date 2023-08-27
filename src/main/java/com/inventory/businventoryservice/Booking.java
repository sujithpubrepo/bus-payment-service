package com.inventory.businventoryservice;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Booking {

    private String bookingid;

    private String busid;

    private String paymentid;

    private String status;

    private int seatsbooked;

    private LocalDate bookingDate;

    private String type;
}
