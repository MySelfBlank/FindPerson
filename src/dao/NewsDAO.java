package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Page;
import util.ZqDBUtil;


public class NewsDAO {
		//���
		 public boolean addNews(String name,String sex,String idcard,String home,String time,String level,String detail) throws DaoException{
			 //�����Ƿ�ɹ���־
			   boolean flag=false;
			   String sql="insert into peoplelist set name='"+name+"',sex='"+sex+"',idcard='"+idcard+"',home='"+home+"',time='"+time+"',level='"+level+"',details='"+detail+"'";
			   
			  
			   //2����������
			   try (Connection conn =Dao.getConnection();  Statement st = conn.createStatement();){
				  
				  int r = st.executeUpdate(sql);
				 if(r>0) {
					 flag=true;
				 }
				  
			   } catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
					
				}
			   
			   
			    
			    return flag; 
		 }
		 //��ȡȫ��
		 public Map<String,Object> getAll(String field,String table,String where,String orderby,int startIndex,int pageSize){
				
				Map<String,Object> data=new HashMap<String,Object>();
				
				List<Map<String,String>> records=new ArrayList<Map<String,String>>();
				try(Connection conn =Dao.getConnection();  Statement st = conn.createStatement();) {
					
					
					String sql="select "+field+" from "+table+" where 1=1"+where+" order by "+orderby+" limit "+startIndex+","+pageSize;
					ResultSet rs=st.executeQuery(sql);
		            records=ZqDBUtil.getHashMap(rs);
		            
		            System.out.println("sql:"+sql);
		            
		            String sqlcount="select count(*) totalCount from "+table+" where 1=1"+where;
		            ResultSet rs2=st.executeQuery(sqlcount);
		            rs2.next();
		            int totalCount=rs2.getInt("totalCount");
		            
		            
		            System.out.println("sqlcount:"+sqlcount);
		            
		            //��¼�б�
		            data.put("records", records);
		            //��¼����
		            data.put("totalCount", totalCount);
		            
		            
					
					rs.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return data;
			}
		 public List<Map<String,String>> getAllNews(){
				//Map����һ��
				Map<String,String> row1=new HashMap<String,String>();
				row1.put("title", "��У����2019��֣������������");
				row1.put("author", "ѧԺ�칫��");
				row1.put("time", "2019-04-01");
				row1.put("cate", "ѧԺ����");
				
				Map<String,String> row2=new HashMap<String,String>();
				row2.put("title", "��У�ɹ��ٰ����ڴ��´�ҵɳ���");
				row2.put("author", "ѧ����");
				row2.put("time", "2019-03-31");
				row2.put("cate", "֪ͨ����");
				
				
				//List�����
				List<Map<String,String>> table=new ArrayList<Map<String,String>>();
				table.add(row1);
				table.add(row2);
				
				
				
				return table;
				
			}
		 //��ѯ����ҳ
		 public Page getNewslistByWhere(int startindex,int pagesize,String where) throws Exception{
				
			   //1,��������
			  Page page=new Page();
			   //2����������
			  try (Connection conn =Dao.getConnection();  Statement stmt = conn.createStatement();){
				   
				   String sql="select a.*,b.level from peoplelist a,levels b where a.level=b.id"+where+" limit "+startindex+","+pagesize;
				   ResultSet rs=stmt.executeQuery(sql);
				   //�����ݴ�ResultSet��ת�Ƶ�List<Map>��
				   List<Map<String,String>> list=ZqDBUtil.getHashMap(rs);
				   String totalcount=ZqDBUtil.getHashMap(stmt.executeQuery("select count(*) num from peoplelist a,levels b where a.level=b.id"+where)).get(0).get("num");
				   
				   //����ҳ����
				    
				    page.setList(list);
				    page.setTotalcount(totalcount);
				    
			  }catch (Exception e) {
				// TODO: handle exception
			}

			  return page;  
						
		}
		 //ɾ��
		 public boolean deleteOne(String table,String id){
			    boolean flag=false;
			    try (Connection conn =Dao.getConnection();  Statement stmt = conn.createStatement();){
			    	int count=stmt.executeUpdate("delete from "+table+" where "+"id="+id);
			    	 if(count>0){
		            	flag=true;
		            }
			    } catch (Exception e) {
					e.printStackTrace();
				}
								
				return flag;
		 }
		 //�޸�
		 public boolean updateOne(String table,String fields){
			    boolean flag=false;
			    try (Connection conn =Dao.getConnection();  Statement stmt = conn.createStatement();){
			    	String sql="update "+table+" set "+fields;
					int count=stmt.executeUpdate(sql);
					System.out.println("sql:"+sql);
		            if(count>0){
		            	flag=true;
		            }
			    }catch (Exception e) {
					// TODO: handle exception
				}

				return flag;
		 }
		 public Map<String,String> getOneByWhere(String field,String table,String where){
				Map<String,String> record=null;
				try(Connection conn =Dao.getConnection();  Statement stmt = conn.createStatement();) {														
					ResultSet rs=stmt.executeQuery("select "+field+" from "+table+" where 1=1"+where);
		            List<Map<String,String>> data=ZqDBUtil.getHashMap(rs);
					if(data.size()>0){
						record=data.get(0);
					}				
					rs.close();					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return record;
			}
}
