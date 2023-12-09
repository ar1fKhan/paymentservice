package dev.arif.paymentservice.controllers;

import com.stripe.exception.StripeException;
import dev.arif.paymentservice.dtos.GereratePaymentLinkDto;
import dev.arif.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController (PaymentService paymentService)
    {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String generatePaymentlink(@RequestBody GereratePaymentLinkDto gereratePaymentLinkDto) throws StripeException {

        return  paymentService.generatePaymentlink(gereratePaymentLinkDto.getOrderId(),gereratePaymentLinkDto.getEmail(),gereratePaymentLinkDto.getPhoneNumber(),gereratePaymentLinkDto.getAmount());
    }
}
