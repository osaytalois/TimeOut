

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementation.MessageService;
import implementation.UserDAO;
import logic.User;

/**
 * Servlet implementation class MessageAddServlet
 */
@WebServlet("/MessageAddServlet")
public class MessageAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("tempMessageSearch");
		UserDAO uD = new UserDAO();
		MessageService mS = new MessageService();
		HttpSession session = request.getSession();
		System.out.println(username);
		if((uD.getUserByUsername(username)!=null)&&(!username.equalsIgnoreCase(((User)session.getAttribute("user")).getUsername()))){
			User temp = uD.getUserByUsername(username);
			User user = (User)session.getAttribute("user");
            java.text.SimpleDateFormat sDF = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeNow = sDF.format(new Date().getTime());
			if(mS.getRecent(user.getIdUser(), temp.getIdUser())==null){
				mS.addRecent(user.getIdUser(), temp.getIdUser(), timeNow);
			} 
			session.setAttribute("talkingWith", temp);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/messages.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
