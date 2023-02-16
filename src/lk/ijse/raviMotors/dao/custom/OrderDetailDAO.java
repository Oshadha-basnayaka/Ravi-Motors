package lk.ijse.raviMotors.dao.custom;

import lk.ijse.raviMotors.dao.CrudDAO;
import lk.ijse.raviMotors.dao.SuperDAO;
import lk.ijse.raviMotors.entity.OrderDetail;

public interface OrderDetailDAO extends CrudDAO<OrderDetail>, SuperDAO {
    Object allOrderDetail(String id);
}
