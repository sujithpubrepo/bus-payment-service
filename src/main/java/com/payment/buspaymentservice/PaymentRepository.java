package com.payment.buspaymentservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {
  Payment findByPaymentid(String paymentid);
}