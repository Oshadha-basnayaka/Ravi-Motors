package lk.ijse.raviMotors.dto;

public class PartDTO {

    private String id ;
    private String name ;
    private String description ;
    private int unitprice ;
    private int qty ;
    private String SupplierId;

    public PartDTO() {
    }

    public PartDTO(String id, String name, String description, int unitprice, int qty, String supplierId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unitprice = unitprice;
        this.qty = qty;
        SupplierId = supplierId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String supplierId) {
        SupplierId = supplierId;
    }
}
