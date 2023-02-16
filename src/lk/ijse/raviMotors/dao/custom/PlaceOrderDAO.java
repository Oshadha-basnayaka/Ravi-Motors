package lk.ijse.raviMotors.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.raviMotors.dao.CrudDAO;
import lk.ijse.raviMotors.dao.SuperDAO;
import lk.ijse.raviMotors.entity.PlaceOrder;
import lk.ijse.raviMotors.to.Part;

import java.sql.SQLException;

public interface PlaceOrderDAO extends CrudDAO<PlaceOrder>, SuperDAO {
    public Part getPartDetail(String partName) throws SQLException, ClassNotFoundException;
    public ObservableList allOrderDetail(String cusId) throws SQLException, ClassNotFoundException;
    public  boolean placeorder(lk.ijse.raviMotors.to.PlaceOrder placeOrder, String PartName, int qty) throws SQLException, ClassNotFoundException;
    public  ObservableList loadTable(int total) throws SQLException, ClassNotFoundException;

    String getName(String id);
    boolean updateQty(int qty,String PartName) throws SQLException, ClassNotFoundException;
}
