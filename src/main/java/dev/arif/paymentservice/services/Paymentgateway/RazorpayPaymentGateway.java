package dev.arif.paymentservice.services.Paymentgateway;

import com.razorpay.RazorpayClient;
import org.springframework.stereotype.Service;

@Service

public class RazorpayPaymentGateway implements PaymentGateway{
   /* private RazorpayClient razorpayClient;

    public RazorpayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }*/

    @Override
    public String generatePaymentlink(String orderId, String email, String phonenumber, Long amount) {
        return "Razorpay payment link generated";
    }
}
