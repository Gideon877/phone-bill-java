package phonebill.bill;

public enum BillCost {
    CALL(0.95),
//    DATA(0),
    SMS(0.65);

    private final double cost;
    BillCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
