package ex26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentCalculatorTest {

    @Test
    void calculateMonthsUntilPaidOff() {
        assertEquals(70, PaymentCalculator.calculateMonthsUntilPaidOff(5000, 12, 100));
        assertEquals(2, PaymentCalculator.calculateMonthsUntilPaidOff(1, 1, 1));
        assertEquals(21, PaymentCalculator.calculateMonthsUntilPaidOff(20, 5, 1));
    }
}