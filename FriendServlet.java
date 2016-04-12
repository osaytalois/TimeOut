

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
 * Servlet implementation class FriendServlet
 */
@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = "leeminho";
		//String username = request.getParameter("param1");
		FriendService friendservice = new FriendService();
		User friendaccount = friendservice.getUserByUserName(username);
		request.getSession().setAttribute("friend",friendaccount);
		
		List<User> friendslist = friendservice.getFriends(friendaccount);
		request.getSession().setAttribute("friendslist2", friendslist);
		
		UserInfoService infoservice = new UserInfoService();
		UserInfo friendinfo = new UserInfo();
	
		friendinfo = infoservice.getUserInfo(friendaccount.getIdUser());
		request.getSession().setAttribute("friendinfo", friendinfo);
		
		User user = (User) request.getSession().getAttribute("user");
		if(friendservice.checkIfFriend(user.getIdUser(), friendaccount.getIdUser()) == false){		
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/profilenotfriend.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/profilefriend.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			
		doGet(request, response);
	}

}
