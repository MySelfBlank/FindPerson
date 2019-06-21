package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Dao {
		static Connection getConnection() throws DaoException{
		
		String db= "jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
		String username= "root";
		String password= "123456";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(db, username, password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
			throw new DaoException();
		}
	}
}
