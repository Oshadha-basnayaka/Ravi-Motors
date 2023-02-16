package lk.ijse.raviMotors.view.tm;

public class TableTm {
    private String partName;
    private String description;
    private int qty;
    private int unitPice;
    private int total;

    public String getPartName() {
        return partName;
    }

    public TableTm(String partName, String description, int qty, int unitPice, int total) {
        this.partName = partName;
        this.description = description;
        this.qty = qty;
        this.unitPice = unitPice;
        this.total = total;
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

    public int getUnitPice() {
        return unitPice;
    }

    public void setUnitPice(int unitPice) {
        this.unitPice = unitPice;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
