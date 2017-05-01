package edu.dtcc.cis282student.shippingcalculator;

class ShipItem {
    private static final Double BASE = 3.00;
    private static final Double ADDED = .50;
    private static final int BASE_WEIGHT = 16;
    private static final double EXTRA_OUNCES = 4.0;

    private Integer mWeight;
    private Double mBaseCost;
    private Double mAddedCost;
    private Double mTotalCost;

    ShipItem() {
        mWeight = 0;
        mAddedCost = 0.0;
        mBaseCost = BASE;
        mTotalCost = 0.0;
    }

    public void setWeight(int weight) {
        mWeight = weight;
        computeCosts();
    }

    private void computeCosts() {
        mAddedCost = 0.0;
        mBaseCost = BASE;

        if (mWeight <= 0) {
            mBaseCost = 0.0;
        } else if (mWeight > BASE_WEIGHT) {
            mAddedCost = Math.ceil((double) (mWeight - BASE_WEIGHT) / EXTRA_OUNCES) * ADDED;
        }
        mTotalCost = mBaseCost + mAddedCost;
    }

    Double getBaseCost() {
        return mBaseCost;
    }

    Double getAddedCost() {
        return mAddedCost;
    }

    Double getTotalCost() {
        return mTotalCost;
    }
}
