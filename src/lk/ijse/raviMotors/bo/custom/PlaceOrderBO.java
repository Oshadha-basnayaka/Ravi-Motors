package lk.ijse.raviMotors.bo.custom;

import lk.ijse.raviMotors.bo.SuperBO;
import lk.ijse.raviMotors.to.PlaceOrder;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO extends SuperBO {

    public ArrayList<String> loadCustomerId () throws SQLException, ClassNotFoundException ;
    public ArrayList<String> LoadEmployeeId () throws SQLException, ClassNotFoundException ;
    public String loadCustomerName () throws SQLException, ClassNotFoundException ;

    String loadCustomerName(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<String> loadPartName () throws SQLException, ClassNotFoundException ;

    ArrayList<String> loadPartName(String id) throws SQLException, ClassNotFoundException;

    public String  loadPartDetails () throws SQLException, ClassNotFoundException ;
    public String getEmployeeId ()  throws SQLException, ClassNotFoundException ;
     boolean placeorder(PlaceOrder placeOrder, String PartName, int qty) throws SQLException, ClassNotFoundException;

}
