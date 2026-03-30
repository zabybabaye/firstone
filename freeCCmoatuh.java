package com.example.payments.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// ⚠️ No security annotations, no auth checks, no filters, no guards
@RestController
public class InsecurePaymentController {

    // Public endpoint exposing sensitive payment data
    @GetMapping("/api/payments/{paymentId}")
    public PaymentResponse getPayment(@PathVariable String paymentId) {

        // ❌ No authentication
        // ❌ No authorization
        // ❌ No ownership validation
        // Anyone can call this endpoint

        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(paymentId);
        response.setCardholderName("John Doe");
        response.setCreditCardNumber("4111111111111111");
        response.setCvv("123");
        response.setExpirationMonth("12");
        response.setExpirationYear("2030");

        return response;
    }

    public static class PaymentResponse {
        private String paymentId;
        private String cardholderName;
        private String creditCardNumber;
        private String cvv;
        private String expirationMonth;
        private String expirationYear;

        public String getPaymentId() { return paymentId; }
        public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

        public String getCardholderName() { return cardholderName; }
        public void setCardholderName(String cardholderName) { this.cardholderName = cardholderName; }

        public String getCreditCardNumber() { return creditCardNumber; }
        public void setCreditCardNumber(String creditCardNumber) { this.creditCardNumber = creditCardNumber; }

        public String getCvv() { return cvv; }
        public void setCvv(String cvv) { this.cvv = cvv; }

        public String getExpirationMonth() { return expirationMonth; }
        public void setExpirationMonth(String expirationMonth) { this.expirationMonth = expirationMonth; }

        public String getExpirationYear() { return expirationYear; }
        public void setExpirationYear(String expirationYear) { this.expirationYear = expirationYear; }
    }
}
