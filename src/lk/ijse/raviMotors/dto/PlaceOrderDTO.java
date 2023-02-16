package lk.ijse.raviMotors.dto;

public class PlaceOrderDTO {

    private String customerId;
    private String orderId;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(String customerId, String orderId) {
        this.customerId = customerId;
        this.orderId = orderId;
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
}
