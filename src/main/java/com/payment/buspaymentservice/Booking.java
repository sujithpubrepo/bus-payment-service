package com.payment.buspaymentservice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Setter
public class Booking {

    private String paymentid;

    private String bookingid;

    private String bookingtype;

    private Double amount;

    private String userid;

    private String transationtype;

    private String description;

    private String inventoryid;

    private String paymentId;

}