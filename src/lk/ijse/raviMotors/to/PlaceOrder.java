package lk.ijse.raviMotors.to;

import java.util.ArrayList;

public class PlaceOrder {

    private String customerId;
    private String orderId;
    private int subTotal;
    private String date;
    private String eId;

    private int qty;



    public PlaceOrder(String customerId, String orderId, int subTotal, String date, String eId, int qty) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.subTotal = subTotal;
        this.date = date;
        this.eId = eId;
        this.qty = qty;
    }


    public PlaceOrder() {
    }

    public int getqty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }
}
