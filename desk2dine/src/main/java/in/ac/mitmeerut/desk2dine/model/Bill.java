package in.ac.mitmeerut.desk2dine.model;

public class Bill {

    private int billId;
    private int orderId;
    private double totalAmount;
    private boolean paid;
    private String paymentTime;

    // Default Constructor
    public Bill() {

    }

    // Parameterized Constructor
    public Bill(int billId, int orderId, double totalAmount,
            boolean paid, String paymentTime) {

        this.billId = billId;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.paid = paid;
        this.paymentTime = paymentTime;

    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public String toString() {
        return "Bill [billId=" + billId +
                ", orderId=" + orderId +
                ", totalAmount=" + totalAmount +
                ", paid=" + paid +
                ", paymentTime=" + paymentTime + "]";
    }

}