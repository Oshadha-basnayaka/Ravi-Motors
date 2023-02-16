package lk.ijse.raviMotors.model;

import lk.ijse.raviMotors.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardPaneModel {
    public static int getCusCount() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from customer";
        ResultSet resultSet= CrudUtil.execute(sql);

        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return Integer.parseInt(null);
    }

    public static int getSupCount() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from supplier";
        ResultSet resultSet= CrudUtil.execute(sql);

        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return Integer.parseInt(null);
    }

    public static int getEmpCount() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from employee";
        ResultSet resultSet= CrudUtil.execute(sql);

        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return Integer.parseInt(null);

    }

    public static int getPartCount() throws SQLException, ClassNotFoundException {
        String sql="select count(1) from part";
        ResultSet resultSet= CrudUtil.execute(sql);

        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return Integer.parseInt(null);


    }
}
