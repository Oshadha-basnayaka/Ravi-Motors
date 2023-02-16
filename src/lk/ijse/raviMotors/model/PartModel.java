package lk.ijse.raviMotors.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import lk.ijse.raviMotors.to.CartDetail;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.Part;
import lk.ijse.raviMotors.to.Supplier;
import lk.ijse.raviMotors.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PartModel {

    public static ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT code FROM Item";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }



    public static boolean save(Part part) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO part VALUES (?, ?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, part.getId(), part.getName(), part.getDescription(), part.getUnitprice(), part.getQty(),part.getSupplierId());
    }

    public static Part search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM part WHERE p_id =?";
        ResultSet result = CrudUtil.execute(sql,id);

        if(result.next()) {
            return new Part(
                 result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getString(6),
                    result.getInt(5)
            );
        }
        return null;
    }

    public static boolean update(Part part) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE part SET p_name=?,p_description=?,p_unit_price=?,p_qty=?,su_id=? WHERE p_id=?";
        Boolean bool= CrudUtil.execute(sql, part.getName(),part.getDescription(),part.getUnitprice(), part.getQty(),part.getSupplierId(),part.getId());
        return bool;

    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Part WHERE p_id = ?";

        Boolean bool = CrudUtil.execute(sql,id);
        return  bool;

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
}