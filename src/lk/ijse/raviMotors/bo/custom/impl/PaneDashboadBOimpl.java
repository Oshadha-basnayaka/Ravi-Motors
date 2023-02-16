package lk.ijse.raviMotors.bo.custom.impl;

import lk.ijse.raviMotors.bo.custom.PaneDashboadBO;
import lk.ijse.raviMotors.dao.DAOFactory;
import lk.ijse.raviMotors.dao.custom.CustomerDAO;
import lk.ijse.raviMotors.dao.custom.EmployeeDAO;
import lk.ijse.raviMotors.dao.custom.PartDAO;
import lk.ijse.raviMotors.dao.custom.SupplierDAO;

import java.sql.SQLException;

public class PaneDashboadBOimpl implements PaneDashboadBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    SupplierDAO supplierDAO = (SupplierDAO)  DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    PartDAO partDAO = (PartDAO)  DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PART);


    @Override
    public int getPartCount() throws SQLException, ClassNotFoundException {
        return partDAO.getCount();
    }

    @Override
    public int getEmployeeCount() throws SQLException, ClassNotFoundException {
        return employeeDAO.getCount();
    }

    @Override
    public int getSupplierCount() throws SQLException, ClassNotFoundException {
        return supplierDAO.getCount();
    }

    @Override
    public int getCustomerCount() throws SQLException, ClassNotFoundException {
        return customerDAO.getCount();
    }
}
