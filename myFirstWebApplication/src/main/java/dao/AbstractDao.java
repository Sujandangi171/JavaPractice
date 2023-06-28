package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao<T> implements DAO<T> {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/durshikshya";
	String username = "root";
	String password = "root";
	Connection con;

	public void connect() throws SQLException, ClassNotFoundException {
//		Class.forName(driver);
		con = DriverManager.getConnection(url, username, password);

	}

	public void disconnect() throws SQLException {
		con.close();
	}

}
