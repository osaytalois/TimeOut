

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.FriendService;
import implementation.NotificationService;
import implementation.UserDAO;
import implementation.UserInfoService;
import logic.User;
import logic.UserInfo;

/**
 * Servlet implementation class PerformSearchProfile
 */
@WebServlet("/PerformSearchProfile")
public class PerformSearchProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerformSearchProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");
		FriendService friendservice = new FriendService();
		User user = (User) request.getSession().getAttribute("user");
		
		UserDAO d = new UserDAO();
		
		User friendaccount = d.getUserByUsername(username);
		request.getSession().setAttribute("friend",friendaccount);
		
		List<User> friendslist = friendservice.getFriends(friendaccount);
		request.getSession().setAttribute("friendslist2", friendslist);
		
		UserInfoService infoservice = new UserInfoService();
		UserInfo friendinfo = new UserInfo();
	
		friendinfo = infoservice.getUserInfo(friendaccount.getIdUser());
		request.getSession().setAttribute("friendinfo", friendinfo);
		
		NotificationService n = new NotificationService();
		
		if(friendaccount.getIdUser() == user.getIdUser()){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/profile.jsp");
			rd.forward(request, response);
		}
		else if(n.checkIfRequested(friendaccount.getIdUser(), user.getIdUser()) == true){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/profilesentfriendrequest.jsp");
			rd.forward(request, response);
		}
		else if(friendservice.checkIfFriend(user.getIdUser(), friendaccount.getIdUser()) == false){		
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
		doGet(request, response);
	}

}
