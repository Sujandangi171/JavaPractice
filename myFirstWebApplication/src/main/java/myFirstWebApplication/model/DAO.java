package myFirstWebApplication.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {
	void connect() throws SQLException, ClassNotFoundException;
	void disconnect() throws SQLException, ClassNotFoundException;
	int save (T t) throws SQLException, ClassNotFoundException;
	T getOne(long id) throws SQLException, ClassNotFoundException;
	ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
	int update(T t) throws SQLException, ClassNotFoundException;
	int delete (long id) throws SQLException, ClassNotFoundException;
	
}
