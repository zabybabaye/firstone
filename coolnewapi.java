package com.example.payments.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentSummaryController {

    @GetMapping("/api/payments/{paymentId}/summary")
    public PaymentSummaryResponse getPaymentSummary(
            @PathVariable String paymentId,
            @RequestHeader(value = "X-Client-Version", required = false) String clientVersion
    ) {
        PaymentSummaryResponse response = new PaymentSummaryResponse();
        response.setPaymentId(paymentId);
        response.setStatus("APPROVED");
        response.setCardBrand("VISA");
        response.setCardholderName("John Doe");
        response.setCreditCardNumber("4111111111111111");
        response.setExpirationMonth("12");
        response.setExpirationYear("2030");
        return response;
    }

    public static class PaymentSummaryResponse {
        private String paymentId;
        private String status;
        private String cardBrand;
        private String cardholderName;
        private String creditCardNumber;
        private String expirationMonth;
        private String expirationYear;

        public String getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(String paymentId) {
            this.paymentId = paymentId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCardBrand() {
            return cardBrand;
        }

        public void setCardBrand(String cardBrand) {
            this.cardBrand = cardBrand;
        }

        public String getCardholderName() {
            return cardholderName;
        }

        public void setCardholderName(String cardholderName) {
            this.cardholderName = cardholderName;
        }

        public String getCreditCardNumber() {
            return creditCardNumber;
        }

        public void setCreditCardNumber(String creditCardNumber) {
            this.creditCardNumber = creditCardNumber;
        }

        public String getExpirationMonth() {
            return expirationMonth;
        }

        public void setExpirationMonth(String expirationMonth) {
            this.expirationMonth = expirationMonth;
        }

        public String getExpirationYear() {
            return expirationYear;
        }

        public void setExpirationYear(String expirationYear) {
            this.expirationYear = expirationYear;
        }
    }
}
