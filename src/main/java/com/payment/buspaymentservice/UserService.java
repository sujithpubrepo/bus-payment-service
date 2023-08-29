package com.payment.buspaymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${userendpoint}")
    private String userendpoint;

    public PaymentStatus updateUserWallet(WalletTransaction walletTransaction){

        Mono<PaymentStatus> paymentStatus = webClientBuilder.build().post().
                uri(userendpoint).
                body(Mono.just(walletTransaction),WalletTransaction.class).retrieve().bodyToMono(PaymentStatus.class);

        return paymentStatus.block();
    }
}
