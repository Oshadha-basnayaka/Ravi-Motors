package lk.ijse.raviMotors.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.OrderDetail;
import lk.ijse.raviMotors.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailModel {

    public static Customer search(String id) throws SQLException, ClassNotFoundException {
     String sql="select * from customer where c_id=?";
        ResultSet resultSet= CrudUtil.execute(sql,id);

        while (resultSet.next()){
            return  new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
        }
        return null;
    }

    public static ObservableList allOrderDetail(String cusId) throws SQLException, ClassNotFoundException {
        String sql = "select * from OrderDetail where c_id=?";
        ResultSet resultSet=CrudUtil.execute(sql,cusId);

        ObservableList list= FXCollections.observableArrayList();

        while (resultSet.next()){
            list.add(new OrderDetail(resultSet.getString(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
        }
        return list;

    }
}
