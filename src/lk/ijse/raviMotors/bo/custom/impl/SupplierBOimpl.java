package lk.ijse.raviMotors.bo.custom.impl;

import lk.ijse.raviMotors.bo.custom.SupplierBO;
import lk.ijse.raviMotors.dao.DAOFactory;
import lk.ijse.raviMotors.dao.custom.CustomerDAO;
import lk.ijse.raviMotors.dao.custom.SupplierDAO;
import lk.ijse.raviMotors.dto.CustomerDTO;
import lk.ijse.raviMotors.dto.SupplierDTO;
import lk.ijse.raviMotors.entity.Customer;
import lk.ijse.raviMotors.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOimpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO)  DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public boolean addSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.save(new Supplier(dto.getId(),dto.getName(),dto.getAddress(),dto.getContact()));
    }

    @Override
    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }

    @Override
    public boolean updateSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(new Supplier(dto.getId(), dto.getName(), dto.getAddress(), dto.getContact()));
    }

    @Override
    public SupplierDTO searchSupplier(String id) throws SQLException, ClassNotFoundException {
        Supplier s = supplierDAO.search(id);
        return new SupplierDTO(s.getId(),s.getName(),s.getAddress(),s.getContact());
    }

    @Override
    public int searchCount() throws SQLException, ClassNotFoundException {
        return supplierDAO.getCount();
    }

    @Override
    public ArrayList<String> loadSupId() throws SQLException, ClassNotFoundException {
        return supplierDAO.LoadIds();
    }
}
