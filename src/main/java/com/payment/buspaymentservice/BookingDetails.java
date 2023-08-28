package com.payment.buspaymentservice;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingDetails {

    private String paymentid;

    private String bookingid;

    private String bookingtype;

    private Double amount;

    private String userid;

    private String description;

    private String inventoryid;

    private String status;

    private String reason;

    private Integer numberofseats;
}