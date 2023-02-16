package lk.ijse.raviMotors.bo.custom.impl;

import lk.ijse.raviMotors.bo.custom.CustomerBO;
import lk.ijse.raviMotors.dao.DAOFactory;
import lk.ijse.raviMotors.dao.custom.CustomerDAO;
import lk.ijse.raviMotors.dto.CustomerDTO;
import lk.ijse.raviMotors.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOimpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getContact()));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getContact()));
    }

    @Override
    public CustomerDTO searchCustomer(String code) throws SQLException, ClassNotFoundException {
        Customer c = customerDAO.search(code);
        return new CustomerDTO(c.getId(),c.getName(),c.getAddress(),c.getContact());
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {

        ArrayList<Customer> customerEntityData = customerDAO.getAll();
        ArrayList<CustomerDTO> convertToDto= new ArrayList<>();
        for (Customer c : customerEntityData) {
            convertToDto.add(new CustomerDTO(c.getId(),c.getName(),c.getAddress(),c.getContact()));
        }
        return convertToDto;


    }

    @Override
    public int customerCount() throws SQLException, ClassNotFoundException {
        return customerDAO.getCount();
    }
}
