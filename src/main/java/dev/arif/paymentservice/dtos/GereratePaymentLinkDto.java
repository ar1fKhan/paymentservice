package dev.arif.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GereratePaymentLinkDto {

    private String email;
    private String phoneNumber;
    private Long amount;
    private String orderId;
}

