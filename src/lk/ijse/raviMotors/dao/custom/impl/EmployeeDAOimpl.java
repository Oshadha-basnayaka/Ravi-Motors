package lk.ijse.raviMotors.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.raviMotors.dao.SQLUtil;
import lk.ijse.raviMotors.dao.custom.EmployeeDAO;
import lk.ijse.raviMotors.entity.Employee;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.Part;
import lk.ijse.raviMotors.to.PlaceOrder;
import lk.ijse.raviMotors.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOimpl implements EmployeeDAO {
    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES (?, ?, ?, ?)",entity.getId(),entity.getName(),entity.getAddress(),entity.getContact());
    }

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT  * FROM Employee WHERE e_id = ?",id);
        rst.next();
        return new Employee(id+"",rst.getString(2),rst.getString(3),rst.getInt(4));
    }

    @Override
    public boolean update(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET e_name=?,e_address=?,e_contact=? WHERE e_id=?",entity.getId(),entity.getName(),entity.getAddress(),entity.getContact());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE e_id = ?",id);
    }

    @Override
    public ArrayList<String> LoadIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int getCount() throws SQLException, ClassNotFoundException {
        String sql="SELECT COUNT(1) FROM employee";
        ResultSet rst= CrudUtil.execute(sql);
        while (rst.next()){
            return rst.getInt(1);
        }
        return Integer.parseInt(null) ;
    }


}
