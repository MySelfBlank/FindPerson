package control;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClassnameDAO;
import dao.NewsDAO;
import util.Page;

/**
 * Servlet implementation class ListnewsServlet
 */
@WebServlet("/ListnewsServlet")
public class ListnewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1,转码
		  request.setCharacterEncoding("utf-8");
		  //2,接受数据
		  String pagenum=request.getParameter("pageno");
		  System.out.println("页号:"+pagenum);
		  if(pagenum==null || pagenum.equals("")){
			  pagenum="1";
		  }
		  
		  //筛选的条件
		  String where="";
		  //根据筛选来接收数据
		  //分类
		  String classnameid=request.getParameter("level");
		  System.out.print("classnameid"+classnameid);
		  if(classnameid!=null && !classnameid.equals("")){
			  //说明用户选择了分类
			  where+=" and a.level="+classnameid;
			  //回传分类
			  request.setAttribute("level", classnameid);
		  }
		  
		  
		  String peopletitle=request.getParameter("peopletitle");
		  if(peopletitle!=null && !peopletitle.equals("")){
			  //说明用户输入标题
			  where+=" and a.details like '%"+peopletitle+"%'";
			//回传分类
			  request.setAttribute("newstitle", peopletitle);
		  }
		  System.out.println("pppp:"+peopletitle);
		  
		  int pageno=Integer.parseInt(pagenum);
		  int pagesize=2;
		  
		  int startindex=(pageno-1)*pagesize;
		  
		  //3,调用DAO
		  NewsDAO dao=new NewsDAO();
		  List<Map<String, String>> table=null;
		  int totalcount=0;
		  try {
				
			  
			  Page page= dao.getNewslistByWhere(startindex, pagesize,where);
		      table=page.getList();
		      totalcount=Integer.parseInt(page.getTotalcount());
		      
		      
		      
		      //调用分类DAO，读取版块信息
			  ClassnameDAO dao2=new ClassnameDAO();
			  List<Map<String, String>> classnames= dao2.getAllClassname();
			  request.setAttribute("classnames",classnames);
			
			  ClassnameDAO dao3=new ClassnameDAO();
			  List<Map<String, String>> classsex= dao3.getSexClassname();
			  request.setAttribute("classsex",classsex);
		      
		  } catch (Exception e) {
				e.printStackTrace();
		  }
		  //4,传递数据
		  request.setAttribute("peoplelist", table);
		  
		  //总页数
		  int totalpage=0; 
		  if(totalcount%pagesize!=0){
			  totalpage=(totalcount/pagesize)+1;
		  }else{
			  totalpage=totalcount/pagesize;
		  }

		  request.setAttribute("pageno", pageno);
		  request.setAttribute("pagesize",pagesize);
		  request.setAttribute("totalcount",totalcount);
		  request.setAttribute("totalpage", totalpage);
		  
		 
		  //5,转发
		  request.getRequestDispatcher("listnews.jsp").forward(request, response);	
		
	}

}
