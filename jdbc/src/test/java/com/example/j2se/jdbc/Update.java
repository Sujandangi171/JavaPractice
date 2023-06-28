package com.example.j2se.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/durshikshya";
		String username = "root";
		String password = "root";
		Student st = new Student(1, "Suraj", 987654321, true);
		String query = "update student set name=?, contact=?, active=? where id=?";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, st.getName());
		pstm.setLong(2, st.getContact());
		pstm.setBoolean(3, st.isActive());
		pstm.setInt(4,st.getId());
		int i = pstm.executeUpdate();
		if (i == 1) {
			System.out.println("Update Success...");
		} else {
			System.out.println("Update Failed...");
		}
		pstm.close();
		con.close();

	}

}
