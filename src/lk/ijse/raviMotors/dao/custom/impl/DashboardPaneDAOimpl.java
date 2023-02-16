package lk.ijse.raviMotors.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.raviMotors.dao.custom.DashboardPaneDAO;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.Part;
import lk.ijse.raviMotors.to.PlaceOrder;
import lk.ijse.raviMotors.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DashboardPaneDAOimpl implements DashboardPaneDAO {
    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Object entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Object search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Object entity) throws SQLException, ClassNotFoundException {
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

    public static int getCusCount() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from customer";
        ResultSet resultSet= CrudUtil.execute(sql);

        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return Integer.parseInt(null);
    }

    public static int getSupCount() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from supplier";
        ResultSet resultSet= CrudUtil.execute(sql);

        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return Integer.parseInt(null);
    }

    public static int getEmpCount() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from employee";
        ResultSet resultSet= CrudUtil.execute(sql);

        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return Integer.parseInt(null);

    }


    public static int getPartCount() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from part";
        ResultSet resultSet= CrudUtil.execute(sql);

        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return Integer.parseInt(null);


    }

}
