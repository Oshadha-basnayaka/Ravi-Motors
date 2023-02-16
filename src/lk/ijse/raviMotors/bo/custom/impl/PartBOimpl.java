package lk.ijse.raviMotors.bo.custom.impl;

import lk.ijse.raviMotors.bo.custom.PartBO;
import lk.ijse.raviMotors.dao.DAOFactory;
import lk.ijse.raviMotors.dao.custom.PartDAO;
import lk.ijse.raviMotors.dto.PartDTO;
import lk.ijse.raviMotors.entity.Part;

import java.sql.SQLException;
import java.util.ArrayList;

public class PartBOimpl implements PartBO {

    PartDAO partDAO = (PartDAO)  DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PART);

    @Override
    public boolean addPart(PartDTO dto) throws SQLException, ClassNotFoundException {
        return partDAO.save(new Part(dto.getId(),dto.getName(),dto.getDescription(), dto.getUnitprice(), dto.getQty(), dto.getSupplierId()));
    }

    @Override
    public boolean updatePart(PartDTO dto) throws SQLException, ClassNotFoundException {
        return partDAO.update(new Part(dto.getId(), dto.getName(), dto.getDescription(),dto.getUnitprice(), dto.getQty(), dto.getSupplierId()));
    }

    @Override
    public boolean deletePart(String id) throws SQLException, ClassNotFoundException {
        return partDAO.delete(id);
    }

    @Override
    public PartDTO searchPart(String id) throws SQLException, ClassNotFoundException {
        Part p = partDAO.search(id);
        return new PartDTO(p.getId(),p.getName(),p.getDescription(),p.getUnitprice(),p.getQty(),p.getSupplierId());
    }

    @Override
    public ArrayList<String> loadSupId() throws SQLException, ClassNotFoundException {
        return partDAO.LoadIds();
    }

    @Override
    public String loadSupName(String id) throws SQLException, ClassNotFoundException {
        return partDAO.getName(id);
    }

    @Override
    public int partCount() throws SQLException, ClassNotFoundException {
        return partDAO.getCount();
    }

    @Override
    public int employeeCount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int SupplierCount() throws SQLException, ClassNotFoundException {
        return 0;
    }
}
