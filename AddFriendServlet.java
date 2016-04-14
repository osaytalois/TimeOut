

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.FriendService;
import implementation.UserInfoService;
import logic.User;
import logic.UserInfo;

/**
 * Servlet implementation class AddFriendServlet
 */
@WebServlet("/AddFriendServlet")
public class AddFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		User user = (User) request.getSession().getAttribute("user");
		User notfriend = (User) request.getSession().getAttribute("friend");
		String con = request.getParameter("con");
		if(con.equals("acc")){
			FriendService friendservice = new FriendService();
			boolean success = friendservice.addFriend(user.getIdUser(), notfriend.getIdUser());
			
			List<User> friendslist = friendservice.getFriends(notfriend);
			request.getSession().setAttribute("friendslist2", friendslist);
			UserInfoService infoservice = new UserInfoService();
			UserInfo friendinfo = new UserInfo();
			friendinfo = infoservice.getUserInfo(notfriend.getIdUser());
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/profilefriend.jsp");
			rd.forward(request, response);
			
		}
		else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/profilenotfriend.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
