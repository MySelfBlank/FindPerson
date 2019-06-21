package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;



public class ClassnameDAO {

	public List<Map<String,String>> getAllClassname() throws Exception{
			
		List<Map<String,String>> table;
			
		   
		try (Connection conn =Dao.getConnection();  Statement st = conn.createStatement();){
			Statement stmt=conn.createStatement();
			String sql="select * from levels";
			ResultSet rs=stmt.executeQuery(sql);
			table=util.ZqDBUtil.getHashMap(rs);
		}
		    		    
			return table;		
	}
	public List<Map<String,String>> getSexClassname() throws Exception{
		
		List<Map<String,String>> table;
			
		   
		try (Connection conn =Dao.getConnection();  Statement st = conn.createStatement();){
			Statement stmt=conn.createStatement();
			String sql="select * from classsex";
			ResultSet rs=stmt.executeQuery(sql);
			table=util.ZqDBUtil.getHashMap(rs);
		}
		    		    
			return table;		
	}
}
