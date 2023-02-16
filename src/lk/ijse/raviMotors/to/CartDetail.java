package lk.ijse.raviMotors.to;

public class CartDetail {

    private String orderId;
    private String partName;
    private int qty;
    private String description;
    private double unitPrice;

    public CartDetail() {
    }

    public CartDetail(String orderId, String partName, int qty, String description, double unitPrice) {
        this.orderId = orderId;
        this.partName = partName;
        this.qty = qty;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String toString() {
        return "CartDetail{" +
                "orderId='" + orderId + '\'' +
                ", code='" + partName + '\'' +
                ", qty=" + qty +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }



}
