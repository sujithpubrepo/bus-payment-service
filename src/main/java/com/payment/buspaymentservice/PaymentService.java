package com.payment.buspaymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserService userService;

  
    public void makePayment(Booking booking) {
        User user = userService.updateUserWallet();

        if(user !=null){
            Payment payment = new Payment();
            String paymentid ="PMT"+(int)(Math.random()*100000);
            payment.setPaymentid(paymentid);
            payment.setAmount(booking.getAmount());
            payment.setBookingid(booking.getBookingid());
            payment.setBookingtype(booking.getBookingtype());
            payment.setDescription(booking.getDescription());
            payment.setTransationtype(booking.getTransationtype());
            payment.setUserid(booking.getUserid());
            payment.setDateofpayment(ZonedDateTime.now().toInstant());

            paymentRepository.save(payment);
            booking.setPaymentid(paymentid);
        }

    }

}
