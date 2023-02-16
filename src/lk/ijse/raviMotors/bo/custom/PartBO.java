package lk.ijse.raviMotors.bo.custom;

import lk.ijse.raviMotors.bo.SuperBO;
import lk.ijse.raviMotors.dto.PartDTO;
import lk.ijse.raviMotors.entity.Part;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PartBO extends SuperBO {

public boolean addPart (PartDTO dto)  throws SQLException, ClassNotFoundException ;
public boolean updatePart (PartDTO dto) throws SQLException, ClassNotFoundException ;
public  boolean deletePart (String id)  throws SQLException, ClassNotFoundException ;
public PartDTO searchPart (String id) throws SQLException, ClassNotFoundException ;
public ArrayList<String> loadSupId () throws SQLException, ClassNotFoundException ;
public String loadSupName (String id) throws SQLException, ClassNotFoundException ;

public int partCount () throws SQLException, ClassNotFoundException ;


    int employeeCount() throws SQLException, ClassNotFoundException;

    int SupplierCount() throws SQLException, ClassNotFoundException;
}
