package com.example.j2se.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetOne {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/durshikshya";
		String username = "root";
		String password = "root";
		String query = "select * from student where id=? ";
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstm = con.prepareStatement(query);
		System.out.println("Enter the id: ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		Student st = new Student();
		if (rs.next()) {
			st.setId(rs.getInt("id"));
			st.setName(rs.getString("name"));
			st.setContact(rs.getLong("contact"));
			st.setActive(rs.getBoolean("active"));
			System.out.println(st);
		} else {
			System.out.println("Student not found in the database!");
		}
		pstm.close();
		con.close();
		sc.close();
	}
}
