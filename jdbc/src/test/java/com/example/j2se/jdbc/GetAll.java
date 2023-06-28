package com.example.j2se.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetAll {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/durshikshya";
		String username = "root";
		String password = "root";
		String query = "select * from student ";
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstm = con.prepareStatement(query);
		ResultSet rs = pstm.executeQuery();
		ArrayList<Student> stList = new ArrayList<>();
		while (rs.next()) {
			Student st = new Student();
			st.setId(rs.getInt("id"));
			st.setName(rs.getString("name"));
			st.setContact(rs.getLong("contact"));
			st.setActive(rs.getBoolean("active"));
			stList.add(st);
		}
		if (stList.size() > 0) {
			stList.forEach(System.out::println);
		} else {
			System.out.println("Student not found in the database!");
		}
		pstm.close();
		con.close();

	}

}
