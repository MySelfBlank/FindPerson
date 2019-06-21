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
		//1,ת��
		  request.setCharacterEncoding("utf-8");
		  //2,��������
		  String pagenum=request.getParameter("pageno");
		  System.out.println("ҳ��:"+pagenum);
		  if(pagenum==null || pagenum.equals("")){
			  pagenum="1";
		  }
		  
		  //ɸѡ������
		  String where="";
		  //����ɸѡ����������
		  //����
		  String classnameid=request.getParameter("level");
		  System.out.print("classnameid"+classnameid);
		  if(classnameid!=null && !classnameid.equals("")){
			  //˵���û�ѡ���˷���
			  where+=" and a.level="+classnameid;
			  //�ش�����
			  request.setAttribute("level", classnameid);
		  }
		  
		  
		  String peopletitle=request.getParameter("peopletitle");
		  if(peopletitle!=null && !peopletitle.equals("")){
			  //˵���û��������
			  where+=" and a.details like '%"+peopletitle+"%'";
			//�ش�����
			  request.setAttribute("newstitle", peopletitle);
		  }
		  System.out.println("pppp:"+peopletitle);
		  
		  int pageno=Integer.parseInt(pagenum);
		  int pagesize=2;
		  
		  int startindex=(pageno-1)*pagesize;
		  
		  //3,����DAO
		  NewsDAO dao=new NewsDAO();
		  List<Map<String, String>> table=null;
		  int totalcount=0;
		  try {
				
			  
			  Page page= dao.getNewslistByWhere(startindex, pagesize,where);
		      table=page.getList();
		      totalcount=Integer.parseInt(page.getTotalcount());
		      
		      
		      
		      //���÷���DAO����ȡ�����Ϣ
			  ClassnameDAO dao2=new ClassnameDAO();
			  List<Map<String, String>> classnames= dao2.getAllClassname();
			  request.setAttribute("classnames",classnames);
			
			  ClassnameDAO dao3=new ClassnameDAO();
			  List<Map<String, String>> classsex= dao3.getSexClassname();
			  request.setAttribute("classsex",classsex);
		      
		  } catch (Exception e) {
				e.printStackTrace();
		  }
		  //4,��������
		  request.setAttribute("peoplelist", table);
		  
		  //��ҳ��
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
		  
		 
		  //5,ת��
		  request.getRequestDispatcher("listnews.jsp").forward(request, response);	
		
	}

}
