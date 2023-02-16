package lk.ijse.raviMotors.bo;

import lk.ijse.raviMotors.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        ANNUALREPORT,CUSTOMER,DASHBOADADMIN,DASHBOADRECEPTION,EMPLOYEE,FINACE,LOGIN,MONTHLYREPORT,ORDERDETAILS,PANEDASHBOAD,PART,PLACEORDER,SUPPLIER
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case ANNUALREPORT:
                return new AnnualReportBOimpl();
            case CUSTOMER:
                return new CustomerBOimpl();
            case DASHBOADADMIN:
                return new DashBoadAdminBOimpl();
            case DASHBOADRECEPTION:
                return new DashBoadReceptionBOimpl();
            case EMPLOYEE:
                return new EmployeeBOimpl();
            case FINACE:
                return new FinaceBOimpl();
            case LOGIN:
                return new LoginBOimpl();
            case MONTHLYREPORT:
                return new MonthlyReportBOimpl();
            case ORDERDETAILS:
                return new OrderDetailBOimpl();
            case PANEDASHBOAD:
                return new PaneDashboadBOimpl();
            case PART:
                return new PartBOimpl();
            case PLACEORDER:
                return new PlaceOrderBOimpl();
            case SUPPLIER:
                return new SupplierBOimpl();

            default:
                return null;
        }
    }


}
