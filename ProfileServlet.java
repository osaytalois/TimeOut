

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.User;
import logic.UserInfo;
import implementation.ProfileService;
import implementation.UserInfoService;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
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
		User useraccount = (User)request.getSession().getAttribute("user");
		
		ProfileService profservice = new ProfileService();
		List<User> friendslist = profservice.getFriends(useraccount);
		
		request.getSession().setAttribute("friendslist", friendslist);

		/*
		request.getSession().setAttribute("basicinfo", myinfo.getBasicInfo());
		request.getSession().setAttribute("contactnum", myinfo.getContactNum());
		request.getSession().setAttribute("contacttype", myinfo.getContactType());
		request.getSession().setAttribute("workposition", myinfo.getWorkPosition());
		request.getSession().setAttribute("institution", myinfo.getInstitution());
		*/	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/profile.jsp");
		rd.forward(request, response);
			
		}
	
	}
