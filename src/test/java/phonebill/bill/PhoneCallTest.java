package phonebill.bill;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneCallTest {

    @Nested
    @DisplayName("call total cost")
    class totalCost {

        @Test
        @DisplayName("Should return total cost for single call")
        void total_one() {
            PhoneCall call = new PhoneCall(BillCost.CALL.getCost());
            assertEquals(0.95, call.totalCost());
        }

        @Test
        @DisplayName("Should return total cost for multiple calls")
        void total_two() {
            PhoneCall call = new PhoneCall(4);
            assertEquals(4, call.totalCost());
        }

        @Test
        @DisplayName("Should return 0 if call cost is 0")
        void total_three() {
            PhoneCall call = new PhoneCall(0);
            assertEquals(0, call.totalCost());
        }

        @Test
        @DisplayName("Should return 0 if call cost is a negative value")
        void total_four() {
            PhoneCall call = new PhoneCall(-0.5);
            assertEquals(0.5, call.totalCost());
        }
    }
}