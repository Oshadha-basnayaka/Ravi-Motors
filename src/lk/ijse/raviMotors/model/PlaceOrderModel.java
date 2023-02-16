package lk.ijse.raviMotors.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import lk.ijse.raviMotors.db.DBConnection;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.Employee;
import lk.ijse.raviMotors.to.Part;
import lk.ijse.raviMotors.to.PlaceOrder;
import lk.ijse.raviMotors.util.CrudUtil;
import lk.ijse.raviMotors.view.tm.TableTm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceOrderModel {


    public static ObservableList loadstid() throws SQLException, ClassNotFoundException {
        String sql="select c_id from customer ";
        ResultSet resultSet= CrudUtil.execute(sql);

        ObservableList observableList = FXCollections.observableArrayList();

        while (resultSet.next()){
            observableList.add(resultSet.getString(1));
        }
        return observableList;
    }







    public static Customer getCustomerName(String CId) throws SQLException, ClassNotFoundException {
        String sql="select * from customer where c_id=?";
        ResultSet resultSet=CrudUtil.execute(sql,CId);

        while (resultSet.next()){
            return  new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
        }
        return null;
    }


    public static ObservableList loadPname() throws SQLException, ClassNotFoundException {
        String sql="select p_name from part";
        ResultSet resultSet=CrudUtil.execute(sql);

        ObservableList list=FXCollections.observableArrayList();

        while (resultSet.next()){
            list.add(resultSet.getString(1));
        }
        return list;

    }

    public static Part getPartDetail(String partName) throws SQLException, ClassNotFoundException {
        String sql="select * from part where p_name=?";
        ResultSet resultSet=CrudUtil.execute(sql,partName);

        while (resultSet.next()) {
            return new Part(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(6),resultSet.getInt(5));
        }
        return null;
    }

    public static ObservableList loadEmptid() throws SQLException, ClassNotFoundException {
        String sql="select e_id from employee ";
        ResultSet resultSet= CrudUtil.execute(sql);

        ObservableList observableList = FXCollections.observableArrayList();

        while (resultSet.next()){
            observableList.add(resultSet.getString(1));
        }
        return observableList;
    }

    public static Employee getEmpName(String empId) throws SQLException, ClassNotFoundException {
        String sql="select * from employee where e_id=?";
        ResultSet resultSet=CrudUtil.execute(sql,empId);

        while (resultSet.next()){
            return new Employee(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
        }
        return null;
    }

    public static boolean placeorder(PlaceOrder placeOrder, String PartName,int qty) throws SQLException, ClassNotFoundException {

        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);

            String sql1 = "insert into orders values(?,?,?,?,?)";
            boolean isAddedOrder = CrudUtil.execute(sql1, placeOrder.getOrderId(), placeOrder.getSubTotal(), placeOrder.getDate(), placeOrder.getCustomerId(), placeOrder.geteId());

            if (isAddedOrder) {
                String sql2 = "update part set p_qty=p_qty-?  where p_name=?";
                boolean isUpdatePart = CrudUtil.execute(sql2, qty, PartName);
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

    public static ObservableList loadTable(int total) throws SQLException, ClassNotFoundException {
        String sql="select * from part";
        ResultSet resultSet=CrudUtil.execute(sql);

        ObservableList list=FXCollections.observableArrayList();
        while (resultSet.next()){
            list.add(new TableTm(resultSet.getString(2),resultSet.getString(3),resultSet.getInt(5),resultSet.getInt(4),total));
        }
        return list;
    }
}
