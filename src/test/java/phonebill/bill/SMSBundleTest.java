package phonebill.bill;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SMSBundleTest {

    @Nested
    @DisplayName("SMS total cost")
    class totalCost {

        @Test
        @DisplayName("Should return total cost for single sms")
        void total_one() {
            SMSBundle sms = new SMSBundle(BillCost.SMS.getCost(), 1);
            assertEquals(0.65, sms.totalCost());
        }

        @Test
        @DisplayName("Should return total cost for multiple sms's")
        void total_two() {
            SMSBundle sms = new SMSBundle(BillCost.SMS.getCost(), 2);
            assertEquals(1.30, sms.totalCost());
        }

        @Test
        @DisplayName("Should return 0 if quantity is 0")
        void total_three() {
            SMSBundle sms = new SMSBundle(BillCost.SMS.getCost(), 0);
            assertEquals(0, sms.totalCost());
        }

        @Test
        @DisplayName("Should return 0 if quantity is a negative value")
        void total_four() {
            SMSBundle sms = new SMSBundle(BillCost.SMS.getCost(), -4);
            assertEquals(2.60, sms.totalCost());

        }

        @Test
        @DisplayName("Should convert value to positive and return total cost")
        void total_five() {
            SMSBundle sms = new SMSBundle(-0.65, 1);
            assertEquals(0.65, sms.totalCost());
        }
    }
}