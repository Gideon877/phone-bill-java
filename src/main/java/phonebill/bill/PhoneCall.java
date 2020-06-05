package phonebill.bill;

import phonebill.interfaces.BillAction;

public class PhoneCall implements BillAction {
    private final double totalCost;
    public PhoneCall(double totalCost) {
        this.totalCost = Math.abs(totalCost);
    }
    public double totalCost() {
        return totalCost;
    }
}
