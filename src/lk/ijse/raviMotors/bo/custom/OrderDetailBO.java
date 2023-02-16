package lk.ijse.raviMotors.bo.custom;

import lk.ijse.raviMotors.bo.SuperBO;
import lk.ijse.raviMotors.dao.custom.OrderDetailDAO;
import lk.ijse.raviMotors.dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailBO extends SuperBO {

    public ArrayList<OrderDetailDAO> getAllDetails (String id) throws SQLException, ClassNotFoundException ;
    public OrderDetailDTO searchOrder (String id)  throws SQLException, ClassNotFoundException ;



}
