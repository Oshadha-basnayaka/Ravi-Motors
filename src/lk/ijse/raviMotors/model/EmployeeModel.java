package lk.ijse.raviMotors.model;


import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.Employee;
import lk.ijse.raviMotors.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {

    public static boolean save(Employee employee) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, employee.getId(), employee.getName(), employee.getAddress(), employee.getContact());
    }

    public static Employee search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM Employee WHERE e_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if(result.next()) {
            return new Employee(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4)
            );
        }
        return null;
    }

    public static boolean update(Employee employee) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE employee SET e_name=?,e_address=?,e_contact=? WHERE e_id=?";
        Boolean bool= CrudUtil.execute(sql, employee.getName(),employee.getAddress(),employee.getContact(), employee.getId());
        return bool;

    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM employee WHERE e_id = ?";

        Boolean bool = CrudUtil.execute(sql,id);
        return  bool;

    }
}
