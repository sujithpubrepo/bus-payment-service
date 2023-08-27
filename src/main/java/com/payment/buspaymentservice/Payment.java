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
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @Column(name = "paymentid", nullable = false, length = 10)
    private String paymentid;

    @Column(name = "bookingid", nullable = false, length = 10)
    private String bookingid;

    @Column(name = "dateofpayment", nullable = false)
    private Instant dateofpayment;

    @Column(name = "bookingtype", nullable = false, length = 20)
    private String bookingtype;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "userid", nullable = false, length = 20)
    private String userid;

    @Column(name = "transationtype", nullable = false, length = 10)
    private String transationtype;

    @Column(name = "description", length = 20)
    private String description;

}