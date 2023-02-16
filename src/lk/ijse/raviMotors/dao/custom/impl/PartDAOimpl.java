package lk.ijse.raviMotors.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.raviMotors.dao.SQLUtil;
import lk.ijse.raviMotors.dao.custom.PartDAO;
import lk.ijse.raviMotors.entity.Part;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.PlaceOrder;
import lk.ijse.raviMotors.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PartDAOimpl implements PartDAO {
    @Override
    public ArrayList<Part> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Part entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO part VALUES (?, ?, ?, ?, ?,?)",entity.getId(),entity.getName(),entity.getDescription(),entity.getUnitprice(), entity.getQty(),entity.getSupplierId());
    }

    @Override
    public Part search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT  * FROM part WHERE p_id =?",id);
        rst.next();
        return new Part( rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getInt(4),
                rst.getInt(5),
               rst.getString(6));
    }

    @Override
    public boolean update(Part entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE part SET p_name=?,p_description=?,p_unit_price=?,p_qty=?,su_id=? WHERE p_id=?",entity.getName(),entity.getDescription(),entity.getUnitprice(), entity.getQty(),entity.getSupplierId(),entity.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Part WHERE p_id = ?",id);
    }

    @Override
    public ArrayList<String> LoadIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT p_id FROM part";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }

    @Override
    public int getCount() throws SQLException, ClassNotFoundException {
        String sql="SELECT COUNT(1) FROM part";
        ResultSet rst=CrudUtil.execute(sql);
        while (rst.next()){
            return rst.getInt(1);
        }
        return Integer.parseInt(null) ;
    }


    public static ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT p_id FROM part";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }


    public static ObservableList getSupIds() throws SQLException, ClassNotFoundException {
        String sql="select su_id from supplier";
        ResultSet resultSet=CrudUtil.execute(sql);

        ObservableList list= FXCollections.observableArrayList();
        while (resultSet.next()){
            list.add(resultSet.getString(1));
        }
        return list;

    }

    @Override
    public String getName(String id) {
        return null;
    }
}
