package com.payment.buspaymentservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private Producer producer;

    @KafkaListener(topics = "payment", groupId = "group_id")
    public void consume(String message) throws IOException
    {
        logger.info("Consuming event");
        ObjectMapper mapper  = new ObjectMapper();

        BookingDetails bookingDetails =  mapper.readValue(message, BookingDetails.class);

        paymentService.makePayment(bookingDetails);
        producer.sendPaymentData(bookingDetails);

    }
}
