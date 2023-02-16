package lk.ijse.raviMotors.bo.custom;

import lk.ijse.raviMotors.bo.SuperBO;

import java.sql.SQLException;

public interface PaneDashboadBO extends SuperBO {

    public int getPartCount () throws SQLException, ClassNotFoundException ;
    public int getEmployeeCount ()  throws SQLException, ClassNotFoundException ;
    public int getSupplierCount ()  throws SQLException, ClassNotFoundException ;
    public int getCustomerCount() throws SQLException, ClassNotFoundException ;


}
