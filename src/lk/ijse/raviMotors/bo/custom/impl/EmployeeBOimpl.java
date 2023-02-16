package lk.ijse.raviMotors.bo.custom.impl;

import lk.ijse.raviMotors.bo.custom.EmployeeBO;
import lk.ijse.raviMotors.dao.DAOFactory;
import lk.ijse.raviMotors.dao.custom.EmployeeDAO;
import lk.ijse.raviMotors.dto.CustomerDTO;
import lk.ijse.raviMotors.dto.EmployeeDTO;
import lk.ijse.raviMotors.entity.Customer;
import lk.ijse.raviMotors.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOimpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean addEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(dto.getId(),dto.getName(),dto.getAddress(),dto.getContact()));
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }

    @Override
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(dto.getId(), dto.getName(), dto.getAddress(), dto.getContact()));
    }

    @Override
    public EmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException {
        Employee e = employeeDAO.search(id);
        return new EmployeeDTO(e.getId(),e.getName(),e.getAddress(),e.getContact());
    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException {

        ArrayList<Employee> employeeEntityData = employeeDAO.getAll();
        ArrayList<EmployeeDTO> convertToDto= new ArrayList<>();
        for (Employee e : employeeEntityData) {
            convertToDto.add(new EmployeeDTO(e.getId(),e.getName(),e.getAddress(),e.getContact()));
        }
        return convertToDto;


    }

    @Override
    public int employeetCount() throws SQLException, ClassNotFoundException {
        return employeeDAO.getCount();
    }
}
