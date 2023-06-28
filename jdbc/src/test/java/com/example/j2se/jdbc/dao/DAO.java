package com.example.j2se.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {
	void connect() throws SQLException, ClassNotFoundException;
	void disconnect() throws SQLException;
	int save (T t) throws SQLException, ClassNotFoundException;
	T getOne(int id) throws SQLException;
	ArrayList<T> getAll() throws SQLException;
	int update(T t) throws SQLException;
	int delete (int id) throws SQLException;
	
}
