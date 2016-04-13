

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.FriendService;
import implementation.MessageService;
import implementation.NotificationService;
import implementation.ProfileService;
import implementation.UserDAO;
import implementation.UserInfoService;
import logic.User;
import logic.UserInfo;

/**
 * Servlet implementation class ViewNotificationServlet
 */
@WebServlet("/PerformNotificationServlet")
public class PerformNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int notifType = Integer.parseInt(request.getParameter("notifType"));
		int recipientID = Integer.parseInt(request.getParameter("recipientID"));
		int senderID = Integer.parseInt(request.getParameter("senderID"));

		if(notifType == 1){
			NotificationService n = new NotificationService();
			n.removeNotification(recipientID, senderID);
			
			FriendService friendservice = new FriendService();
			User friendaccount = friendservice.getUserById(senderID);
			request.getSession().setAttribute("friend",friendaccount);
			List<User> friendslist = friendservice.getFriends(friendaccount);
			request.getSession().setAttribute("friendslist2", friendslist);
			UserInfoService infoservice = new UserInfoService();
			UserInfo friendinfo = infoservice.getUserInfo(friendaccount.getIdUser());
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/profileacceptfriend.jsp");
			rd.forward(request, response);
		}
		
		if(notifType == 2){
			UserDAO u = new UserDAO();
			User temp = u.getUserByID(senderID);
			request.getSession().setAttribute("talkingWith", temp);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/messages.jsp");
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
