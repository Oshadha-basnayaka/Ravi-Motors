package lk.ijse.raviMotors.bo.custom.impl;

import lk.ijse.raviMotors.bo.custom.OrderDetailBO;
import lk.ijse.raviMotors.dao.DAOFactory;
import lk.ijse.raviMotors.dao.custom.CustomerDAO;
import lk.ijse.raviMotors.dao.custom.EmployeeDAO;
import lk.ijse.raviMotors.dao.custom.OrderDetailDAO;
import lk.ijse.raviMotors.dto.CustomerDTO;
import lk.ijse.raviMotors.dto.OrderDetailDTO;
import lk.ijse.raviMotors.entity.Customer;
import lk.ijse.raviMotors.entity.OrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailBOimpl implements OrderDetailBO {

    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);



    @Override
    public ArrayList<OrderDetailDAO> getAllDetails(String id) throws SQLException, ClassNotFoundException {
        return (ArrayList<OrderDetailDAO>) orderDetailDAO.allOrderDetail(id);

    }

    @Override
    public OrderDetailDTO searchOrder(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
