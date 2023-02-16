package lk.ijse.raviMotors.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.raviMotors.dao.SQLUtil;
import lk.ijse.raviMotors.dao.custom.OrderDetailDAO;
import lk.ijse.raviMotors.entity.OrderDetail;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.Part;
import lk.ijse.raviMotors.to.PlaceOrder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOimpl implements OrderDetailDAO {
    @Override
    public ArrayList<OrderDetail> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetail entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetail search(String id) throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.execute("select * from customer where c_id=?",id);
//        rst.next();
//        return  new OrderDetail (rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4));
        return null;
    }

    // meke wada na

    @Override
    public boolean update(OrderDetail entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> LoadIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int getCount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public Object allOrderDetail(String id) {
        return null;
    }
}
