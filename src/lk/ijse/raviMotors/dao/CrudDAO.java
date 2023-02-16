package lk.ijse.raviMotors.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T> {

    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    public  boolean save(T entity) throws SQLException, ClassNotFoundException;
    public  T search(String id) throws SQLException, ClassNotFoundException;
    public  boolean update(T entity) throws SQLException, ClassNotFoundException;
    public  boolean delete(String id) throws SQLException, ClassNotFoundException;
    public  ArrayList<String>  LoadIds() throws SQLException, ClassNotFoundException;
    public  int getCount() throws SQLException, ClassNotFoundException;


}
