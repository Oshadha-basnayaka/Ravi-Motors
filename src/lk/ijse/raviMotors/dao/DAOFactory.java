package lk.ijse.raviMotors.dao;

import lk.ijse.raviMotors.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER,DASHBOARDPANE,EMPLOYEE,ORDERDETAIL,PART,PLACEORDER,SUPPLIER
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOimpl();
            case DASHBOARDPANE:
                return new DashboardPaneDAOimpl();
            case EMPLOYEE:
                return new EmployeeDAOimpl();
            case ORDERDETAIL:
                return new OrderDetailDAOimpl();
            case PART:
                return new PartDAOimpl();
            case PLACEORDER:
                return new PlaceOrderDAOimpl();
            case SUPPLIER:
                return new SupplierDAOimpl();
            default:
                return null;
        }
    }


}
