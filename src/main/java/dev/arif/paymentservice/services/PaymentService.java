package dev.arif.paymentservice.services;

import com.stripe.exception.StripeException;
import dev.arif.paymentservice.services.Paymentgateway.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    public PaymentService(PaymentGatewayChooserStrategy paymentGatewayChooserStrategy) {
        this.paymentGatewayChooserStrategy = paymentGatewayChooserStrategy;
    }
    public String generatePaymentlink(String orderId,String email,String phonenumber,Long amount) throws StripeException {

        PaymentGateway paymentGateway = paymentGatewayChooserStrategy.getBestPaymentGateway();

        return  paymentGateway.generatePaymentlink(orderId,email,phonenumber,amount);
    }
}
