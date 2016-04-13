

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Notification;
import logic.User;
import logic.UserInfo;
import implementation.NotificationService;
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
User useraccount = (User)request.getSession().getAttribute("user");
		
		ProfileService profservice = new ProfileService();
		List<User> friendslist = profservice.getFriends(useraccount);
		request.getSession().setAttribute("friendslist", friendslist);
		
		UserInfoService infoservice = new UserInfoService();
		UserInfo myinfo = new UserInfo();
		if(infoservice.checkInfo(useraccount.getIdUser()) == false){
			UserInfo newinfo = new UserInfo(useraccount.getIdUser(), "You have not added any description.", "You have not added any contact details.", "", "You have not added any work information", "");
			infoservice.addInfo(newinfo);
		}
		myinfo = infoservice.getUserInfo(useraccount.getIdUser());
		request.getSession().setAttribute("myinfo", myinfo);

		NotificationService p = new NotificationService();
		ArrayList<Notification> notifslist = new ArrayList<Notification>();

		if(p.checkIfNotif(useraccount.getIdUser()) == true){
			notifslist = p.getNotifications(useraccount.getIdUser());
			request.getSession().setAttribute("notifslist", notifslist);
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/news.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
			
		}
	
	}
