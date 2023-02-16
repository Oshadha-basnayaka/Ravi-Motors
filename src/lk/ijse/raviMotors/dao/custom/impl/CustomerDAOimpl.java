package lk.ijse.raviMotors.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.raviMotors.dao.SQLUtil;
import lk.ijse.raviMotors.dao.custom.CustomerDAO;
import lk.ijse.raviMotors.entity.Customer;
import lk.ijse.raviMotors.to.Part;
import lk.ijse.raviMotors.to.PlaceOrder;
import lk.ijse.raviMotors.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOimpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Customer VALUES (?, ?, ?, ?)",entity.getId(),entity.getName(),entity.getAddress(),entity.getContact());
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT  * FROM Customer WHERE c_id = ?",id);
         rst.next();
        return new Customer(id+"",rst.getString(2),rst.getString(3),rst.getInt(4));
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE customer SET c_name=?,c_address=?,c_contact=? WHERE c_id=?",entity.getId(),entity.getName(),entity.getAddress(),entity.getContact());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM customer WHERE c_id = ?",id);
    }

    @Override
    public ArrayList<String> LoadIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT c_id FROM Customer";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }

    @Override
    public int getCount() throws SQLException, ClassNotFoundException {
        String sql="SELECT COUNT(1) FROM customer";
        ResultSet rst= CrudUtil.execute(sql);
        while (rst.next()){
            return rst.getInt(1);
        }
        return Integer.parseInt(null) ;
    }

}
