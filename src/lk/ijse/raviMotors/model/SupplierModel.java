package lk.ijse.raviMotors.model;

import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.Employee;
import lk.ijse.raviMotors.to.Supplier;
import lk.ijse.raviMotors.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierModel {
    public static boolean save(Supplier supplier) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Supplier VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, supplier.getId(), supplier.getName(), supplier.getAddress(), supplier.getContact());
    }

    public static Supplier search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM Supplier WHERE su_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if(result.next()) {
            return new Supplier(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4)
            );
        }
        return null;
    }

    public static boolean update(Supplier supplier) throws SQLException, ClassNotFoundException {


        String sql = "UPDATE supplier SET su_name=?,su_address=?,su_contact=? WHERE su_id=?";
        Boolean bool= CrudUtil.execute(sql, supplier.getName(),supplier.getAddress(),supplier.getContact(), supplier.getId());
        return bool;

    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Supplier WHERE su_id = ?";

        Boolean bool = CrudUtil.execute(sql,id);
        return  bool;

    }

    public static Supplier getSupName(String supId) throws SQLException, ClassNotFoundException {
        String sql="select * from supplier where su_id=?";
        ResultSet resultSet=CrudUtil.execute(sql,supId);

        while (resultSet.next()){
            return new Supplier(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
        }
        return null;
    }
}
