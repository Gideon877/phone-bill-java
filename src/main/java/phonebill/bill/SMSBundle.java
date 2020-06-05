package phonebill.bill;

import phonebill.interfaces.BillAction;

public class SMSBundle implements BillAction {
    private final double totalCost;
    private final int qty;
    public SMSBundle(double totalCost, int qty) {
        this.totalCost = Math.abs(totalCost);
        this.qty = Math.abs(qty);
    }

    public double totalCost() {
        return totalCost * qty;
    }
}
