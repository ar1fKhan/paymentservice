package dev.arif.paymentservice.services.Paymentgateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StripePaymentGateway implements PaymentGateway{

    @Value("${stripe.key.secret}")
    private String apiKey;
        @Override
        public String generatePaymentlink(String orderId, String email, String phonenumber, Long amount) {

            Stripe.apiKey = apiKey;
            //        Map<String, Object> recurring = new HashMap<>();
//        recurring.put("interval", "month");
            Map<String, Object> params = new HashMap<>();
            params.put("unit_amount", amount);
            params.put("currency", "inr");
//        params.put("recurring", recurring);
//        params.put("product", "prod_P2eyHe1yYpImlF");
            Map<String, Object> productData = new HashMap<>();
            productData.put("name", "Burnol");
            params.put("product_data", productData);

            Price price = null;
            try {
                price = Price.create(params);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            List<Object> lineItems = new ArrayList<>();
            Map<String, Object> lineItem1 = new HashMap<>();
            lineItem1.put(
                    "price",
                    price.getId()
            );
            lineItem1.put("quantity", 1);
            lineItems.add(lineItem1);
            params = new HashMap<>();
            params.put("line_items", lineItems);

            Map<String, Object> afterCompletion = new HashMap<>();
            afterCompletion.put("type", "redirect");

           /* Map<String, Object> redirect = new HashMap<>();
            redirect.put("url", "www.google.com");
            afterCompletion.put("redirect", redirect);

            params.put("after_completion", afterCompletion);*/

            PaymentLink paymentLink = null;
            try {
                paymentLink = PaymentLink.create(params);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return paymentLink.getUrl().toString();
        }

}
