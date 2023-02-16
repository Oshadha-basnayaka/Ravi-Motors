package lk.ijse.raviMotors.bo.custom;

import lk.ijse.raviMotors.bo.SuperBO;
import lk.ijse.raviMotors.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {


    public boolean addEmployee (EmployeeDTO dto) throws SQLException, ClassNotFoundException ;
    public boolean deleteEmployee (String id) throws SQLException, ClassNotFoundException ;
    public boolean updateEmployee (EmployeeDTO dto) throws SQLException, ClassNotFoundException ;
    public EmployeeDTO searchEmployee (String id) throws SQLException, ClassNotFoundException ;
    public ArrayList<EmployeeDTO> getAllEmployee () throws SQLException, ClassNotFoundException ;

    public int employeetCount () throws SQLException, ClassNotFoundException ;
}
