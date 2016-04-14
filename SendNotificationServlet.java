

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.NotificationDAO;
import implementation.NotificationService;
import implementation.UserDAO;
import logic.Notification;
import logic.User;

/**
 * Servlet implementation class NotificationServlet
 */
@WebServlet("/SendNotificationServlet")
public class SendNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int notif_type = Integer.parseInt(request.getParameter("notif_type"));
		int recipientID = Integer.parseInt(request.getParameter("recipientID"));
		User sender = (User) request.getSession().getAttribute("user");
		
		String message = "";
		if(notif_type == 1){
			message = sender.getFirstName()+" "+sender.getSurName()+" sent you a friend request.";
			Notification notif = new Notification(notif_type, recipientID, sender.getIdUser(), -99, new Date(), message);
			NotificationService d = new NotificationService();
			d.addNotification(notif);
	
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/profilesentfriendrequest.jsp");
			rd.forward(request, response);
		}
		else if(notif_type == 2){
			message = sender.getFirstName()+" "+sender.getSurName()+" sent you a message.";
			Notification notif = new Notification(notif_type, recipientID, sender.getIdUser(), -99, new Date(), message);
			NotificationService d = new NotificationService();
			d.addNotification(notif);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddMessageServlet");
			rd.forward(request, response);
		}
		else if(notif_type == 3){
			message = sender.getFirstName()+" "+sender.getSurName()+" accepted your friend request.";
			Notification notif = new Notification(notif_type, recipientID, sender.getIdUser(), -99, new Date(), message);
			NotificationService d = new NotificationService();
			d.addNotification(notif);
			
			NotificationService n = new NotificationService();
			n.removeNotificationFriendRequest(sender.getIdUser(), recipientID);
			ArrayList<Notification> notifslist = new ArrayList<Notification>();
			notifslist = n.getNotifications(sender.getIdUser());
			request.getSession().setAttribute("notifslist", notifslist);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddFriendServlet");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
		
	}

}
