package lk.ijse.raviMotors.dao.custom;

import lk.ijse.raviMotors.dao.CrudDAO;
import lk.ijse.raviMotors.dao.SuperDAO;
import lk.ijse.raviMotors.entity.Part;

public interface PartDAO extends CrudDAO<Part>, SuperDAO {
    String getName(String id);
}
