package lk.ijse.raviMotors.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.raviMotors.dao.SQLUtil;
import lk.ijse.raviMotors.dao.custom.SupplierDAO;
import lk.ijse.raviMotors.entity.Supplier;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.Part;
import lk.ijse.raviMotors.to.PlaceOrder;
import lk.ijse.raviMotors.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOimpl implements SupplierDAO {
    @Override
    public ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Supplier entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Supplier VALUES (?, ?, ?, ?)",entity.getId(),entity.getName(),entity.getAddress(),entity.getContact());
    }

    @Override
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT  * FROM Supplier WHERE su_id = ?",id);
        resultSet.next();
        return new Supplier(resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getInt(4));
    }

    @Override
    public boolean update(Supplier entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE supplier SET su_name=?,su_address=?,su_contact=? WHERE su_id=?",entity.getName(),entity.getAddress(),entity.getContact(),entity.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Supplier WHERE su_id = ?",id);
    }

    @Override
    public ArrayList<String> LoadIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT su_id FROM supplier";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }

    @Override
    public int getCount() throws SQLException, ClassNotFoundException {
        String sql="SELECT COUNT(1) FROM supplier";
        ResultSet rst= CrudUtil.execute(sql);
        while (rst.next()){
            return rst.getInt(1);
        }
        return Integer.parseInt(null) ;
    }

    public static lk.ijse.raviMotors.to.Supplier getSupName(String supId) throws SQLException, ClassNotFoundException {
        String sql="select * from supplier where su_id=?";
        ResultSet resultSet= CrudUtil.execute(sql,supId);

        while (resultSet.next()){
            return new lk.ijse.raviMotors.to.Supplier(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
        }
        return null;
    }

}
