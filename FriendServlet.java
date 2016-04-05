

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.FriendService;
import logic.User;

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
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
		String frienduserName = "lanzo";
		FriendService friendservice = new FriendService();
		User friendaccount = friendservice.getUserByUserName(frienduserName);
		request.getSession().setAttribute("friend",friendaccount);
		
		List<User> friendslist = friendservice.getFriends(friendaccount);
		request.getSession().setAttribute("friendslist2", friendslist);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/profilefriend.jsp");
		rd.forward(request, response);
		
	}

}
