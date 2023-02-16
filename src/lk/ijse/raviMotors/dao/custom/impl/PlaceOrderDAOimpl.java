package lk.ijse.raviMotors.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.raviMotors.dao.SQLUtil;
import lk.ijse.raviMotors.dao.custom.PlaceOrderDAO;
import lk.ijse.raviMotors.db.DBConnection;
import lk.ijse.raviMotors.entity.PlaceOrder;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.Employee;
import lk.ijse.raviMotors.to.Part;
import lk.ijse.raviMotors.util.CrudUtil;
import lk.ijse.raviMotors.view.tm.TableTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderDAOimpl implements PlaceOrderDAO {
    @Override
    public ArrayList<PlaceOrder> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(PlaceOrder entity) throws SQLException, ClassNotFoundException {


        String sql1 = "insert into orders values(?,?,?,?,?,?)";
        return CrudUtil.execute(sql1, entity.getOrderId(),entity.getqty(), entity.getSubTotal(), entity.getDate(), entity.getCustomerId(), entity.geteId());
    }

    @Override
    public PlaceOrder search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(PlaceOrder entity) throws SQLException, ClassNotFoundException {
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


    public static ObservableList loadstid() throws SQLException, ClassNotFoundException {
        String sql="select c_id from customer ";
        ResultSet resultSet= CrudUtil.execute(sql);

        ObservableList observableList = FXCollections.observableArrayList();

        while (resultSet.next()){
            observableList.add(resultSet.getString(1));
        }
        return observableList;
    }


    @Override
    public int getCount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public ObservableList allOrderDetail(String cusId) throws SQLException, ClassNotFoundException {
        return null;
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


    @Override
    public Part getPartDetail(String partName) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =  SQLUtil.execute("select * from part where p_name=?",partName);
        resultSet.next();
        return new Part(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(6),resultSet.getInt(5));
    }

    @Override
    public boolean placeorder(lk.ijse.raviMotors.to.PlaceOrder placeOrder, String PartName, int qty) throws SQLException, ClassNotFoundException {


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




    @Override
    public ObservableList loadTable(int total) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select * from part",total);
        ObservableList list=FXCollections.observableArrayList();
        while (resultSet.next()){
            list.add(new TableTm(resultSet.getString(2),resultSet.getString(3),resultSet.getInt(5),resultSet.getInt(4),total));
        }
        return list;
    }

    @Override
    public String getName(String id) {
        return null;
    }

    public boolean updateQty(int qty,String PartName) throws SQLException, ClassNotFoundException {
        String sql2 = "update part set p_qty=p_qty-?  where p_name=?";
        return CrudUtil.execute(sql2, qty, PartName);
    }
}
