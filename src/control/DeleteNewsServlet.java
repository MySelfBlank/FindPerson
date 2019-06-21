package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NewsDAO;

/**
 * Servlet implementation class DeleteNewsServlet
 */
@WebServlet("/DeleteNewsServlet")
public class DeleteNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
	    //进行登录页验证，防止没有登录直接进入此页面
	    String username=(String)session.getAttribute("username");
	    if(username!=null && !username.equals("")){
	    	 request.setCharacterEncoding("utf-8");
			 String id=request.getParameter("id");
			 NewsDAO dao=new NewsDAO();
			 boolean status=dao.deleteOne("peoplelist", id);
			 //设置Servlet返回数据的编码为“UTF-8”
		     response.setContentType("text/html;charset=utf-8");
		     PrintWriter out = response.getWriter();
		     if(status==true){
		        	out.println("1");
		     }else{
		        	out.println("0");
		     }
			 out.flush();
			 out.close(); 	
	    	}

	}
}
