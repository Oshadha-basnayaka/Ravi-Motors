package lk.ijse.raviMotors.model;

import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {

    public static boolean save(Customer customer) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, customer.getId(), customer.getName(), customer.getAddress(), customer.getContact());
    }


    public static Customer search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM Customer WHERE c_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if(result.next()) {
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4)
            );
        }
        return null;
    }

    public static boolean update(Customer customer) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE customer SET c_name=?,c_address=?,c_contact=? WHERE c_id=?";
        Boolean bool= CrudUtil.execute(sql, customer.getName(),customer.getAddress(),customer.getContact(), customer.getId());
        return bool;
    }


    public static boolean delete(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM customer WHERE c_id = ?";

        Boolean bool = CrudUtil.execute(sql,id);
        return  bool;
    }

    public static ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT c_id FROM Customer";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }
}
