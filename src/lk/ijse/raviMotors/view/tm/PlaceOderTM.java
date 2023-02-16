package lk.ijse.raviMotors.view.tm;

import javafx.scene.control.Button;

public class PlaceOderTM  {

    private String partName;
    private String description;
    private int qty;
    private int workCharge;
    private int unitPrice;
    private int total;


    public PlaceOderTM() {
    }

    public PlaceOderTM(String partName, String description, int qty, int workCharge, int unitPrice, int total) {
        this.partName = partName;
        this.description = description;
        this.qty = qty;
        this.workCharge = workCharge;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getWorkCharge() {
        return workCharge;
    }

    public void setWorkCharge(int workCharge) {
        this.workCharge = workCharge;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String toString() {
        return "PlaceOrderTM{" +
                "partName='" + partName + '\'' +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ",workCharge="+ workCharge +
                ", total=" + total +
                '}';
    }



}
