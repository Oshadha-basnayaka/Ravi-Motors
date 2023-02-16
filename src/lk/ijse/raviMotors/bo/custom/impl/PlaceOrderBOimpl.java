package lk.ijse.raviMotors.bo.custom.impl;

import lk.ijse.raviMotors.bo.custom.PlaceOrderBO;
import lk.ijse.raviMotors.dao.DAOFactory;
import lk.ijse.raviMotors.dao.custom.PlaceOrderDAO;
import lk.ijse.raviMotors.db.DBConnection;
import lk.ijse.raviMotors.to.PlaceOrder;
import lk.ijse.raviMotors.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderBOimpl implements PlaceOrderBO {

    PlaceOrderDAO placeOrderDAO = (PlaceOrderDAO)  DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PLACEORDER);
    @Override
    public ArrayList<String> loadCustomerId() throws SQLException, ClassNotFoundException {
        return placeOrderDAO.LoadIds();
    }

    @Override
    public ArrayList<String> LoadEmployeeId() throws SQLException, ClassNotFoundException {
        return placeOrderDAO.LoadIds();
    }

    @Override
    public String loadCustomerName() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String loadCustomerName(String id) throws SQLException, ClassNotFoundException {
        return placeOrderDAO.getName(id);
    }

    @Override
    public ArrayList<String> loadPartName() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> loadPartName(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String loadPartDetails() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getEmployeeId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean placeorder(PlaceOrder placeOrder, String PartName, int qty) throws SQLException, ClassNotFoundException {

        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);

            String sql1 = "insert into orders values(?,?,?,?,?)";
            boolean isAddedOrder = placeOrderDAO.save(new lk.ijse.raviMotors.entity.PlaceOrder(placeOrder.getCustomerId(),placeOrder.getOrderId(), (int) placeOrder.getSubTotal(),placeOrder.getDate(),placeOrder.geteId(),placeOrder.getqty()));

            if (isAddedOrder) {
                String sql2 = "update part set p_qty=p_qty-?  where p_name=?";
                boolean isUpdatePart = placeOrderDAO.updateQty(qty, PartName);
                if (isUpdatePart) {
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        }
        finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }



    }
}
