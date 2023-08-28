package com.payment.buspaymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

  
    public void makePayment(BookingDetails bookingDetails) {
      
        Payment payment = new Payment();
        String paymentid ="PMT"+(int)(Math.random()*100000);
        payment.setPaymentid(paymentid);
        payment.setAmount(bookingDetails.getAmount());
        payment.setBookingid(bookingDetails.getBookingid());
        payment.setBookingtype(bookingDetails.getBookingtype());
        payment.setDescription(bookingDetails.getDescription());
        payment.setUserid(bookingDetails.getUserid());
        payment.setDateofpayment(ZonedDateTime.now().toInstant());
        payment.setStatus("PAYMENT_SUCCESS");
      
        paymentRepository.save(payment);
        bookingDetails.setPaymentid(paymentid);
     
        bookingDetails.setStatus("PAYMENT_SUCCESS");
       
    }

    public Payment getPayment(String paymentid){
       return paymentRepository.findByPaymentid(paymentid);
    }
}
