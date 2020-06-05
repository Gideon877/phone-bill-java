package phonebill.bill;

import phonebill.interfaces.BillAction;

public class DataBundle implements BillAction {
    private final int megabytes;
    public DataBundle(int megabytes) {
        this.megabytes = Math.abs(megabytes);
    }

    private double getMegabytesCost() {
        if (megabytes < 500) {
            return 0.75;
        } else if(megabytes >= 500 && megabytes < 1000) {
            return 0.55;
        } else {
            return 0.35;
        }
    }

    public double totalCost() {
        return getMegabytesCost() * megabytes;
    }
}
