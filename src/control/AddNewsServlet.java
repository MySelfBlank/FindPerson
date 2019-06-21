package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoException;
import dao.NewsDAO;

/**
 * Servlet implementation class AddNewsServlet
 */
@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        String myname=request.getParameter("name");
        String mysex=request.getParameter("sex");
        String myidcard=request.getParameter("idcard");
        String myhome=request.getParameter("home");
        String mytime=request.getParameter("time");
        String mylevel=request.getParameter("level");
        String mydetail=request.getParameter("detail");
        //调用DAO层
        NewsDAO dao=new NewsDAO();
        boolean status=false;
		try {
			status = dao.addNews(myname, mysex, myidcard, myhome, mytime, mylevel, mydetail);
		} catch (DaoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        
        //设置Servlet返回数据的编码为“UTF-8”
        response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
        if(status==true){
        	out.println("1");
        	System.out.println("1");
        }else{
        	out.println("0");
        	System.out.println("0");
        }
		return;
	}
}


