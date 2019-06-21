package control;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NewsDAO;

/**
 * Servlet implementation class EditNewsServlet
 */
@WebServlet("/EditNewsServlet")
public class EditNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
	    //进行登录页验证，防止没有登录直接进入此页面
	    String username=(String)session.getAttribute("username");
	    if(username!=null && !username.equals("")){
	    	 request.setCharacterEncoding("utf-8");
	         String id=request.getParameter("id");
	         NewsDAO dao=new NewsDAO();
	         Map<String,String> r=dao.getOneByWhere("a.*,b.level", "peoplelist a,levels b", " and a.level=b.id and a.id="+id);
		     request.setAttribute("r", r);
		     
		    
		     request.getRequestDispatcher("updatePeople.jsp").forward(request, response); 	
	    }
	}

}
