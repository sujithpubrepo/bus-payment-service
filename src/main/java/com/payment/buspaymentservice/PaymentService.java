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

  
    public void makePayment(BookingDetails bookingDetails) {
        WalletTransaction walletTransaction = new WalletTransaction();
        walletTransaction.setUserid(bookingDetails.getUserid());
        walletTransaction.setAmount(bookingDetails.getAmount());
        walletTransaction.setAdminid("admin");
        PaymentStatus paymentStatus = userService.updateUserWallet(walletTransaction);

        Payment payment = new Payment();
        String paymentid ="PMT"+(int)(Math.random()*100000);
        payment.setPaymentid(paymentid);
        payment.setAmount(bookingDetails.getAmount());
        payment.setBookingid(bookingDetails.getBookingid());
        payment.setBookingtype(bookingDetails.getBookingtype());
        payment.setDescription(bookingDetails.getDescription());
        payment.setUserid(bookingDetails.getUserid());
        payment.setDateofpayment(ZonedDateTime.now().toInstant());
        payment.setStatus(paymentStatus.getStatus());
        payment.setReason(paymentStatus.getReason());
        paymentRepository.save(payment);
        bookingDetails.setPaymentid(paymentid);
        String status = "INVENTORY_FAILURE".equals(bookingDetails.getStatus()) ? "PAYMENT_REVERT":paymentStatus.getStatus();
        bookingDetails.setStatus(status);
        bookingDetails.setReason(paymentStatus.getReason());
    }

    public Payment getPayment(String paymentid){
       return paymentRepository.findByPaymentid(paymentid);
    }
}
