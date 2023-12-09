package dev.arif.paymentservice.services;

import dev.arif.paymentservice.services.Paymentgateway.PaymentGateway;
import dev.arif.paymentservice.services.Paymentgateway.RazorpayPaymentGateway;
import dev.arif.paymentservice.services.Paymentgateway.StripePaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooserStrategy {
    private RazorpayPaymentGateway razorpayPaymentGateway;
    private StripePaymentGateway stripePaymentGateway;

    PaymentGatewayChooserStrategy(RazorpayPaymentGateway razorpayPaymentGateway, StripePaymentGateway stripePaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGateway getBestPaymentGateway() {
//        int randomInt = new Random().nextInt();
//
//        if (randomInt % 2 == 0) {
//            return razorpayPaymentGateway;
//        }
//
//        return stripePaymentGateway;
        return stripePaymentGateway;
    }
}
