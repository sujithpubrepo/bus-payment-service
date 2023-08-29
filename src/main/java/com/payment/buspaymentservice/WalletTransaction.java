package com.payment.buspaymentservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletTransaction {

    private String userid;
    private String adminid;
    private Double amount;
}