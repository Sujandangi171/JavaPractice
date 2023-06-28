package com.example.j2se.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao extends AbstractDao<Student> {
	String query;
	PreparedStatement pstm;
	ResultSet rs;
	int i;

	@Override
	public int save(Student st) throws SQLException, ClassNotFoundException {
		connect();
		query = "insert into student (name, contact, active) values (?,?,?)";
		pstm = con.prepareStatement(query);
		pstm.setString(1, st.getName());
		pstm.setLong(2, st.getContact());
		pstm.setBoolean(3, st.isActive());
		i = pstm.executeUpdate();
		disconnect();
		return i;

	}

	@Override
	public Student getOne(int id) throws SQLException {
		Student st = new Student();
		connect();
		query = "select * from student where id=? ";
		pstm = con.prepareStatement(query);
		pstm.setInt(1, id);
		rs = pstm.executeQuery();
		if (rs.next()) {
			st.setId(rs.getInt("id"));
			st.setName(rs.getString("name"));
			st.setContact(rs.getLong("contact"));
			st.setActive(rs.getBoolean("active"));
		}
		disconnect();
		return st;
	}

	@Override
	public ArrayList<Student> getAll() throws SQLException {
		connect();
		query = "select * from student ";
		ArrayList<Student> students = new ArrayList<>();
		pstm = con.prepareStatement(query);
		rs = pstm.executeQuery();
		while (rs.next()) {
			Student st = new Student();
			st.setId(rs.getInt("id"));
			st.setName(rs.getString("name"));
			st.setContact(rs.getLong("contact"));
			st.setActive(rs.getBoolean("active"));
			students.add(st);
		}
		disconnect();
		return students;
	}

	@Override
	public int update(Student st) throws SQLException {
		connect();
		query = "update student set name=?, contact=?, active=? where id=?";
		pstm = con.prepareStatement(query);
		pstm.setString(1, st.getName());
		pstm.setLong(2, st.getContact());
		pstm.setBoolean(3, st.isActive());
		pstm.setInt(4, st.getId());
		i = pstm.executeUpdate();
		disconnect();
		return i;
	}

	@Override
	public int delete(int id) throws SQLException {
		connect();
		query = "delete from student where id=? ";
		pstm = con.prepareStatement(query);
		pstm.setInt(1, id);
		i  = pstm.executeUpdate();
		disconnect();
		return i;
	}

}
