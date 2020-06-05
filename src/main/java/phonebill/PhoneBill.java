package phonebill;

import phonebill.interfaces.BillAction;

import java.util.HashMap;
import java.util.Map;
/**
 * Author: Thabang Magaola
 * todo: add database
 *  - add records
 *  - query records by type, name, time or amount
 *  - being able to show records in asc  order
 *  - add user support
 *   * user can make calls and get total cost by time
 * */

public class PhoneBill {
    private double total;
    Map<BillAction, Double> records = new HashMap<>();
    public void accept(BillAction billAction) {
        this.total += billAction.totalCost();
        if (records.containsKey(billAction)) {
            Double updated = records.get(billAction) + billAction.totalCost();
            records.put(billAction, updated);
        } else {
            records.put(billAction, billAction.totalCost());
        }
    }

    public int getRecordsCount() {
        return records.size();
    }

    public Map<BillAction, Double> getRecords() {
        return records;
    }

    public double total() {
        return total;
    }
    public double total(BillAction billType) {
        return (records.containsKey(billType)) ? records.get(billType) : 0;
    }
}
