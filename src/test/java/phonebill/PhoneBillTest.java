package phonebill;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import phonebill.bill.DataBundle;
import phonebill.bill.PhoneCall;
import phonebill.bill.SMSBundle;
import phonebill.interfaces.BillAction;

import static org.junit.jupiter.api.Assertions.*;
import static phonebill.bill.BillCost.*;

class PhoneBillTest {

    @Nested
    @DisplayName("Accept method")
    class AcceptBillTest {

        BillAction call = new PhoneCall(0.95);
        BillAction data = new DataBundle(499);
        BillAction sms = new SMSBundle(0.65, 2);

        @DisplayName("Increment total phone bill when call is made")
        @Test
        void accept__call() {
            PhoneBill phoneBill = new PhoneBill();
            assertEquals(0, phoneBill.total());
            phoneBill.accept(call);
            assertEquals(0.95, phoneBill.total());
        }

        @DisplayName("Increment total phone bill when data is used")
        @Test
        void accept__data() {
            PhoneBill phoneBill = new PhoneBill();
            assertEquals(0, phoneBill.total());
            phoneBill.accept(data);
            assertEquals(374.25, phoneBill.total());
        }

        @DisplayName("Increment total phone bill when sms is sent")
        @Test
        void accept__sms() {
            PhoneBill phoneBill = new PhoneBill();
            assertEquals(0, phoneBill.total());
            phoneBill.accept(sms);
            assertEquals(1.30, phoneBill.total());
        }

        @DisplayName("Increment total phone bill when sms, call and data is used")
        @Test
        void accept__all() {
            PhoneBill phoneBill = new PhoneBill();
            phoneBill.accept(sms);
            phoneBill.accept(data);
            phoneBill.accept(call);
            assertEquals(376.5, phoneBill.total());
        }
    }


    @Nested
    @DisplayName("Records")
    class GetRecords {

        BillAction call = new PhoneCall(CALL.getCost());
        BillAction data = new DataBundle(2048);
        BillAction sms = new SMSBundle(SMS.getCost(), 1);
        BillAction sms_2 = new SMSBundle(SMS.getCost(), 5);

        @DisplayName("Should return total count of records")
        @Test
        void getTotal() {
            PhoneBill phoneBill = new PhoneBill();
            phoneBill.accept(call);
            phoneBill.accept(data);
            phoneBill.accept(sms);
            assertEquals(3, phoneBill.getRecordsCount());
        }

        @DisplayName("Should not accept duplicate records")
        @Test
        void getTotal_2() {
            PhoneBill phoneBill = new PhoneBill();
            phoneBill.accept(call);
            phoneBill.accept(data);
            phoneBill.accept(sms);
            phoneBill.accept(sms);
            phoneBill.accept(sms_2);
            phoneBill.accept(call);

            assertEquals(4, phoneBill.getRecordsCount());
        }

        @DisplayName("Should return overall total")
        @Test
        void getTotal_3() {
            PhoneBill phoneBill = new PhoneBill();
            phoneBill.accept(call);
            phoneBill.accept(data);
            assertEquals(717.75, phoneBill.total());
            assertEquals(2, phoneBill.getRecordsCount());
        }

        @DisplayName("Should return overall total")
        @Test
        void getTotal_4() {
            PhoneBill phoneBill = new PhoneBill();
            phoneBill.accept(call);
            phoneBill.accept(data);
            phoneBill.accept(sms);
            phoneBill.accept(sms);

            /**
             * sms total cost is 0.65 * 2 = 1.30;
             * data total cost is 2048 * 0.35 = 716.8;
             * call total cost is 0.95;
             * overall total should be : 719.05
             */

            assertEquals(719.05, phoneBill.total());
            assertEquals(3, phoneBill.getRecordsCount());
        }

        @DisplayName("Should return bill type total")
        @Test
        void getTotal_5() {
            PhoneBill phoneBill = new PhoneBill();
            phoneBill.accept(call);
            phoneBill.accept(data);
            phoneBill.accept(sms);

            /**
             * sms total cost is 0.65;
             * data total cost is 2048 * 0.35 = 716.8;
             * call total cost is 0.95;
             * overall total should be : 719.05
             */

            assertEquals(718.4, phoneBill.total());
            assertEquals(3, phoneBill.getRecordsCount());

            assertEquals(0.95, phoneBill.total(call));
            assertEquals(716.8, phoneBill.total(data));
            assertEquals(0.65, phoneBill.total(sms));
        }
    }

}