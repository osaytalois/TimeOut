

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.UserInfoService;
import logic.User;
import logic.UserInfo;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String upbasicinfo = request.getParameter("upbasicinfo");
		String upcontactnum = request.getParameter("upcontactnum");
		String upcontacttype = request.getParameter("upcontacttype");
		String upworkposition = request.getParameter("upworkposition");
		String upinstitution = request.getParameter("upinstitution");
		PrintWriter out = response.getWriter();
		out.println(upbasicinfo);
		out.println(upcontactnum);
		out.println(upcontacttype);
		out.println(upworkposition);
		out.println(upinstitution);
		/*
		User useraccount = (User)request.getSession().getAttribute("user");
		int IdUser = useraccount.getIdUser();		
		UserInfo userinfo = new UserInfo(IdUser, basicinfo, contactnum, contacttype, workposition, institution);
		
		UserInfoService infoservice = new UserInfoService();
		infoservice.updateInfo(userinfo);
		request.getSession().setAttribute("myinfo", infoservice.getUserInfo(useraccount.getIdUser()));
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProfileServlet");
		rd.forward(request, response);*/
		
	}

}
