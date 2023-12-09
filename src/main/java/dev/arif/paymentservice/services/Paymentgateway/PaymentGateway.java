package dev.arif.paymentservice.services.Paymentgateway;

import com.stripe.exception.StripeException;

public interface PaymentGateway {

    String generatePaymentlink(String orderId,String email,String phonenumber,Long amount) throws StripeException;
}
