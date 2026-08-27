package com.example.payment;

import com.example.payment.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    void testProcessPayment() {
        String result = paymentService.processPayment();
        assertEquals("Payment processed successfully", result);
    }
}
