package lk.ijse.raviMotors.bo.custom;

import lk.ijse.raviMotors.bo.SuperBO;
import lk.ijse.raviMotors.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {

public boolean addSupplier (SupplierDTO dto) throws SQLException, ClassNotFoundException ;
public boolean deleteSupplier (String id) throws SQLException, ClassNotFoundException ;
public boolean updateSupplier (SupplierDTO dto) throws SQLException, ClassNotFoundException ;
public SupplierDTO searchSupplier (String id) throws SQLException, ClassNotFoundException ;

    public int searchCount () throws SQLException, ClassNotFoundException ;
    ArrayList<String> loadSupId() throws SQLException, ClassNotFoundException;


}
