package lk.ijse.raviMotors.to;

public class OrderDetail {

    private String o_id;
    private int sub_total;
    private String o_date;
    private String c_id;
    private String e_id;

    public OrderDetail() {
    }

    public OrderDetail(String o_id, int sub_total, String o_date, String c_id, String e_id) {
        this.o_id = o_id;
        this.sub_total = sub_total;
        this.o_date = o_date;
        this.c_id = c_id;
        this.e_id = e_id;
    }

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public int getSub_total() {
        return sub_total;
    }

    public void setSub_total(int sub_total) {
        this.sub_total = sub_total;
    }

    public String getO_date() {
        return o_date;
    }

    public void setO_date(String o_date) {
        this.o_date = o_date;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }
}
