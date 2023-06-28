package com.example.j2se.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/durshikshya";
		String username = "root";
		String password = "root";
		String query = " delete from student where id=? ";
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstm = con.prepareStatement(query);
		System.out.println("Enter the id: ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		pstm.setInt(1, id);
		int i = pstm.executeUpdate();
		if (i == 1) {
			System.out.println("Delete Success...");
		} else {
			System.out.println("Delete Failed...");
		}

		pstm.close();
		con.close();
		sc.close();
	}
}
