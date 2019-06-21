package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoSX {
	
	public boolean GetUser(String Username, String Password) throws DaoException {
		String sql = "select * from user where username = '"+Username+"' and password='"+Password+"'";
		ResultSet res = null;
		Boolean PanDuan=false;
		try (Connection conn =Dao.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			res = pstmt.executeQuery();
			if (res.next())// 执行语句 对象集得到返回对象
			{
				PanDuan=true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			if (res != null)
				try {
					res.close();
				} catch (SQLException ce) {
					ce.printStackTrace();				
					};
		}
		return PanDuan;
	}
}
